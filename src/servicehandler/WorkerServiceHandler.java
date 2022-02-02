package servicehandler;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dataservices.GetRequest;
import dataservices.PutRequest;
import docker.ContainerManagement;
import thriftservices.Argument;
import thriftservices.GetBlockResponse;
import thriftservices.InvokeFunctionResponse;
import thriftservices.Location;
import thriftservices.PutBlockResponse;
import thriftservices.Specification;
import thriftservices.WorkerService;

public class WorkerServiceHandler implements WorkerService.Iface {

	/**
	 * Write the block locally
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(WorkerServiceHandler.class);

	@Override
	public PutBlockResponse putBlock(String event_function_id, List<Argument> parameterArray) throws TException {
		// TODO Auto-generated method stub
		LOGGER.info("The worker node is called for putBlock() " + event_function_id);
		PutRequest objectPutRequest = new PutRequest();
		objectPutRequest.prepareJSONObject(event_function_id, parameterArray);
		objectPutRequest.writeJSONLocally();

		PutBlockResponse response = new PutBlockResponse();
		response.setStatus(1);
		response.setResponse("Wrote the parameters on the file " + event_function_id);

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

}
