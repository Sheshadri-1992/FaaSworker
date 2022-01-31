package dataservices;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
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

		if (localIP == location.getIP()) {
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
				LOGGER.info("The Exec request response "+response.toString());
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
			Integer numOfParams = (Integer) jsonObject.get("totalParam");

			for (int i = 0; i < numOfParams; i++) {
				String paramName = "arg" + (i + 1) + "";
				Argument argObj = (Argument) jsonObject.get(paramName);
				parameterArray.add(argObj);
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

}
