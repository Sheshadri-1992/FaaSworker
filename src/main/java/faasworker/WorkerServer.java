package faasworker;

import java.io.File;
import java.util.concurrent.Executors;

import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import miscellaneous.Constants;
import servicehandler.WorkerServiceHandler;
import thriftservices.WorkerService;



public class WorkerServer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WorkerServer.class);
	public static WorkerServiceHandler workerServiceHandler = null;
	public static WorkerService.Processor<WorkerServiceHandler> eventProcessor = null;
	
	public static void createEdgeCacheDirectory() {
		
		/**
		 * https://stackoverflow.com/questions/28947250/create-a-directory-if-it-does-not-exist-and-then-create-the-files-in-that-direct
		 */
		File directory = new File(Constants.EDGE_PARAMS_DIRECTORY);
	    if (! directory.exists()){
	        directory.mkdir();
	        // If you require it to make the entire directory path including parents,
	        // use directory.mkdirs(); here instead.
	    }
	}

	public static void main(String[] args) {
		
		String workerIP = "";
		Integer workerPort = 8000;
		
		if(args.length != 2) {
			LOGGER.info("Usage: java -cp target/faasworker-0.0.1-SNAPSHOT-jar-with-dependencies.jar faasworker.WorkerServer <IP> <Port>");
			System.exit(0);
		}
		
		workerIP = args[0];
		workerPort = Integer.valueOf(args[1]);
		
		// TODO Auto-generated method stub
		LOGGER.info("Starting Worker Server IP "+workerIP+" Port "+workerPort);
		
		createEdgeCacheDirectory();

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
			LOGGER.info("Starting the Master Server.. ");
			server.serve();
			LOGGER.info("Closed the connection Thrift Server");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
