package faasworker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executors;

import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import client.RegisterWorkerToMaster;
import masterthriftservices.RegisterWorkerRequest;
import masterthriftservices.WorkerNodeLocation;
import miscellaneous.Constants;
import model.WorkerInfo;
import servicehandler.WorkerServiceHandler;
import thriftservices.WorkerService;

public class WorkerServer {

	private static final Logger LOGGER = LoggerFactory.getLogger(WorkerServer.class);
	public static WorkerServiceHandler workerServiceHandler = null;
	public static WorkerService.Processor<WorkerServiceHandler> eventProcessor = null;
	public static WorkerInfo workerInfo;
	public static WorkerInfo masterInfo;

	public static void createEdgeCacheDirectory() {

		/**
		 * https://stackoverflow.com/questions/28947250/create-a-directory-if-it-does-not-exist-and-then-create-the-files-in-that-direct
		 */
		File directory = new File(Constants.EDGE_PARAMS_DIRECTORY);
		if (!directory.exists()) {
			directory.mkdir();
			// If you require it to make the entire directory path including parents,
			// use directory.mkdirs(); here instead.
		}
	}

	public static void main(String[] args) {

		String workerIP = "";
		Integer workerPort = 8000;

		if (args.length != 1) {
			LOGGER.info(
					"Usage: java -cp target/faasworker-0.0.1-SNAPSHOT-jar-with-dependencies.jar faasworker.WorkerServer config.json");
			System.exit(0);
		}
		File f = new File(args[0]);
		if (f.exists() == false) {
			System.out.println("The config file does not exist");
			System.exit(0);
		}

		JSONParser parser = new JSONParser();
		Object obj;
		try {
			obj = parser.parse(new FileReader(args[0]));
			JSONObject jsonObject = (JSONObject) obj;
			workerIP = (String) jsonObject.get("worker_ip");
			String workerPortFromConfig = (String) jsonObject.get("worker_port");
			workerPort = Integer.valueOf(workerPortFromConfig);
			String resType = (String) jsonObject.get("res_type");
			String nodeIDFromConfig = (String) jsonObject.get("nodeid");
			Integer nodeID = Integer.valueOf(nodeIDFromConfig);
			workerInfo = new WorkerInfo(workerIP, workerPort, nodeID, resType);
			
			String masterIP =  (String) jsonObject.get("master_ip");
			String masterPortFromConfig = (String) jsonObject.get("master_port");
			Integer masterPort = Integer.valueOf(masterPortFromConfig);
			masterInfo = new WorkerInfo();
			masterInfo.setIP(masterIP);
			masterInfo.setPort(masterPort);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		System.out.println(workerInfo.toString());

		LOGGER.info("Starting Worker Server IP " + workerIP + " Port " + workerPort);
		createEdgeCacheDirectory();

		WorkerNodeLocation nodeLoc = new WorkerNodeLocation();
		nodeLoc.setIp(workerIP);
		nodeLoc.setPort(workerPort);
		RegisterWorkerRequest registerReqObj = new RegisterWorkerRequest();
		registerReqObj.setWorkerNodeLoc(nodeLoc);
		registerReqObj.setResourceType(workerInfo.getResourceType()); // Workery type is added here
		registerReqObj.setNodeId(workerInfo.getID());
		RegisterWorkerToMaster.registerMyWorker(registerReqObj);

		workerServiceHandler = new WorkerServiceHandler();
		eventProcessor = new WorkerService.Processor<WorkerServiceHandler>(workerServiceHandler);

		Runnable masterRunnable = new Runnable() {

			@Override
			public void run() {

				startMasterServer(eventProcessor, Constants.WORKER_PORT);
			}
		};

		/** start listening and expose services **/
		Thread masterThread = new Thread(masterRunnable);
		masterThread.start();
	}

	/**
	 * Start listening to clients
	 */
	public static void startMasterServer(WorkerService.Processor<WorkerServiceHandler> eventProcessor,
			Integer serverPort) {
		try {
			TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(serverPort);
			/*
			 * TServer server = new TNonblockingServer( new
			 * TNonblockingServer.Args(serverTransport).processor(eventProcessor));
			 */
			TThreadedSelectorServer.Args serverArgs = new TThreadedSelectorServer.Args(serverTransport);
			// 20 threads for processing requests
			serverArgs.executorService(Executors.newFixedThreadPool(1));
			serverArgs.processor(eventProcessor);
			TThreadedSelectorServer server = new TThreadedSelectorServer(serverArgs);
			LOGGER.info("Starting the Worker Server.. ");
			server.serve();
			LOGGER.info("Closed the connection Thrift Server");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static WorkerInfo getWorkerLocation() {
		return workerInfo;
	}

}
