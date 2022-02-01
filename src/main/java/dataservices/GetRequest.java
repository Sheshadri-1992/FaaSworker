package dataservices;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import faasworker.WorkerServer;
import miscellaneous.Constants;
import thriftservices.Argument;
import thriftservices.GetBlockResponse;
import thriftservices.Location;
import thriftservices.WorkerService;

public class GetRequest {
	private static final Logger LOGGER = LoggerFactory.getLogger(GetRequest.class);

	public ArrayList<Argument> getParameters(String filename, Location location) {

		String localIP = WorkerServer.getWorkerLocation().getIP();
		Integer localPort = WorkerServer.getWorkerLocation().getPort();

		ArrayList<Argument> parameterArray = null;
		LOGGER.info("Local IP " + localIP + " IP to read " + location.getIP() + " Filename " + filename);
		if (localIP.equals(location.getIP())) {
			/** Local read **/
			parameterArray = readJSONfile(filename);
			LOGGER.info("Local Read");
		} else {
			/** Remote read **/
			LOGGER.info("Remote Read");
			TTransport transport = new TFramedTransport(new TSocket(location.getIP(), location.getPort()));
			try {
				transport.open();
			} catch (TTransportException e) {
				transport.close();
				LOGGER.error("Error opening connection to Master IP : {} and port : {}", location.getIP(),
						location.getPort());
				e.printStackTrace();
			}

			TProtocol protocol = new TBinaryProtocol(transport);
			WorkerService.Client workerClient = new WorkerService.Client(protocol);

			try {

				GetBlockResponse response = workerClient.getBlock(filename, location);
				parameterArray = (ArrayList<Argument>) response.getParamList();
				LOGGER.info("The Exec request response " + response.toString());
			} catch (TException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return parameterArray;
	}

	public ArrayList<Argument> readJSONfile(String filename) {

		ArrayList<Argument> parameterArray = new ArrayList<Argument>();

		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(Constants.EDGE_PARAMS_DIRECTORY + filename));

			JSONObject jsonObject = (JSONObject) obj;
			Long numOfParams = (Long) jsonObject.get("totalParam");
			System.out.println(numOfParams);

			for (int i = 0; i < numOfParams; i++) {
				
				String paramName = "arg"+(i+1);
				String encodedString = (String) jsonObject.get(paramName);
				byte[] byteArray = java.util.Base64.getDecoder().decode(encodedString);
				int length = byteArray.length;
				LOGGER.info("Length of the bytearray is "+length);
				
				Argument arg= new Argument();
				arg.setArgName(paramName);
				arg.setArgPayload(byteArray);
				
				parameterArray.add(arg);
			}

			for (Argument arg : parameterArray) {
				LOGGER.info("Argument name : " + arg.getArgName() + " Payload length :  " + arg.getArgPayload().length);
			}

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

		return parameterArray;

	}
	
	
	/** For testing purposes **/
	private void testMethod(String[] args) {
		String str1 = "192.168.0.103";
		String str2 = "192.168.0.103";
		if (str1.equals(str2)) {
			/** Local read **/
			LOGGER.info("Local Read");
		}

		GetRequest getReqObj = new GetRequest();
		getReqObj.prepareJSONObject();
		getReqObj.readJSONfile("/home/swamiji/new-eclipse-workspace/faasworker/shesh");
	}
	
	public void prepareJSONObject() {

		JSONObject myJSONObject = new JSONObject();
		String filename = "/home/swamiji/new-eclipse-workspace/faasworker/shesh";
		Integer numOfArgs = 1;
		
		myJSONObject.put("totalParam", numOfArgs+"");
		
		ArrayList<Argument> paramArray = new ArrayList<Argument>();
		Argument argObj =  new Argument();
		argObj.setArgName("arg1");
		
		
		Path path = Paths.get("/home/swamiji/new-eclipse-workspace/EdgeCloudFaaS/inputfiles/shawshank.jpg");

		byte[] payloadByteArray = null;
		try {
			payloadByteArray = Files.readAllBytes(path);
			LOGGER.info("The length of the payload is "+payloadByteArray.length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		argObj.setArgPayload(payloadByteArray);
		paramArray.add(argObj);

		try {
			myJSONObject.put("totalParam", numOfArgs);
			for (Argument arg : paramArray) {
				String paramName = arg.getArgName();
				byte[] paramValue = arg.getArgPayload();
				String encodedString = java.util.Base64.getEncoder().encodeToString(paramValue);
				myJSONObject.put(paramName, encodedString);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			FileWriter myFileWriter = new FileWriter(filename);
			myFileWriter.write(myJSONObject.toString());
			myFileWriter.flush();
			myFileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
