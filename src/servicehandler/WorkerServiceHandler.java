package servicehandler;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dataservices.GetRequest;
import dataservices.PutRequest;
import docker.ContainerManagement;
import faasworker.WorkerServer;
import masterthriftservices.ExecRequestResponse;
import masterthriftservices.FaaSMasterService;
import masterthriftservices.Result;
import masterthriftservices.WriteResultsResponse;
import miscellaneous.Constants;
import thriftservices.Argument;
import thriftservices.GetBlockResponse;
import thriftservices.InvokeFunctionResponse;
import thriftservices.Location;
import thriftservices.PutBlockResponse;
import thriftservices.Specification;
import thriftservices.WorkerService;
import thriftservices.WriteResultResponse;

public class WorkerServiceHandler implements WorkerService.Iface {

	/**
	 * Write the block locally
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(WorkerServiceHandler.class);

	@Override
	public PutBlockResponse putBlock(String event_function_id, List<Argument> parameterArray) throws TException {
		// TODO Auto-generated method stub
		long start_time = System.currentTimeMillis();
		LOGGER.info("The worker node is called for putBlock() " + event_function_id);
		PutRequest objectPutRequest = new PutRequest();
		objectPutRequest.prepareJSONObject(event_function_id, parameterArray);
		objectPutRequest.writeJSONLocally();
		long end_time = System.currentTimeMillis();
		long put_block_time = end_time - start_time;

		PutBlockResponse response = new PutBlockResponse();
		response.setStatus(1);
		response.setResponse("Wrote the parameters on the file " + event_function_id);
		LOGGER.info("Put block event ID "+event_function_id+" Time taken "+put_block_time);

		return response;
	}

	@Override
	public InvokeFunctionResponse invokeFunction(String functionName, Specification specs, Location paramLocation,
			String paramFileName) throws TException {
		LOGGER.info("The worker node is called for invokeFunction() " + functionName + " " + specs.toString() + " "
				+ paramLocation.toString() + " " + paramFileName);

		InvokeFunctionResponse response = new InvokeFunctionResponse();

		// TODO Auto-generated method stub
		ContainerManagement containerMgmt = new ContainerManagement();
		containerMgmt.updateContainerAndStart(functionName, specs, paramLocation, paramFileName);

		response.setStatus(1);
		response.setResponse("Function " + functionName + " succesffully invoked");

		return response;
	}

	@Override
	public GetBlockResponse getBlock(String filename, Location dataLocation) throws TException {
		// TODO Auto-generated method stub
		GetBlockResponse getBlkResponse = new GetBlockResponse();
		GetRequest getReqObj = new GetRequest();
		ArrayList<Argument> paramList = getReqObj.getParameters(filename, dataLocation);
		getBlkResponse.setParamList(paramList);
		getBlkResponse.setResponse("File read successfully");

		return getBlkResponse;
	}

	@Override
	public WriteResultResponse writeResultsToMaster(List<Argument> resultSet, String functionName, String eventID)
			throws TException {

		WriteResultResponse resObj = new WriteResultResponse();
		resObj.setStatus(1);
		resObj.setResponse("Write results to master called ");

		TTransport transport = new TFramedTransport(
				new TSocket(WorkerServer.masterInfo.getIP(), WorkerServer.masterInfo.getPort()));
		try {
			transport.open();
		} catch (TTransportException e) {
			transport.close();
			LOGGER.error("Error opening connection to Master IP : {} and port : {}", WorkerServer.masterInfo.getIP(),
					WorkerServer.masterInfo.getPort());
			e.printStackTrace();
		}

		TProtocol protocol = new TBinaryProtocol(transport);
		FaaSMasterService.Client masterClient = new FaaSMasterService.Client(protocol);

		ArrayList<Result> myResultSet = new ArrayList<Result>();
		if (resultSet != null) {
			for (Argument argUnit : resultSet) {
				Result resultUnit = new Result();
				resultUnit.setResultName(argUnit.getArgName());
				resultUnit.setResultData(argUnit.getArgPayload());
				myResultSet.add(resultUnit);
			}
		}

		try {
			WriteResultsResponse response = masterClient.writeFunctionOutput(eventID, myResultSet, functionName);
			LOGGER.info("The Exec request response " + response.toString());
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resObj;
	}

}
