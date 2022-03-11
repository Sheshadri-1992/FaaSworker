package servicehandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
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
import masterthriftservices.FaaSMasterService;
import masterthriftservices.WriteResultsResponse;
import miscellaneous.Constants;
import thriftservices.Argument;
import thriftservices.GetBlockResponse;
import thriftservices.ImageBinary;
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
		LOGGER.info("Put block event ID " + event_function_id + " Time taken " + put_block_time);

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
	public WriteResultResponse writeResultsToMaster(String functionName, String eventID, String directoryName,
			int dataNodeID) throws TException {

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
		try {
			WriteResultsResponse response = masterClient.writeFunctionOutput(eventID, functionName, directoryName,
					dataNodeID);
			LOGGER.info("The Exec request response " + response.toString());
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resObj;
	}

	@Override
	public String testmethod(String test) throws TException {
		System.out.println("Things are working fine");
		return "Working";
	}

	@Override
	public String testinputsize(ByteBuffer inputsize) throws TException {
		int input_size = inputsize.array().length;
		System.out.println("Got the input of size " + input_size);
		try (FileOutputStream fos = new FileOutputStream("pathname")) {
			fos.write(inputsize.array());
			fos.flush();
			System.out.println("File is written to system");
			// fos.close(); There is no more need for this line since you had created the
			// instance of "fos" inside the try. And this will automatically close the
			// OutputStream
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return input_size + "";
	}

	@Override
	public String writeFileToWorker(String directoryName, List<ImageBinary> imageBinaryList, Location workerLocation) {
		File directory = new File(directoryName);
		if (!directory.exists()) {
			directory.mkdirs();
			// If you require it to make the entire directory path including parents,
			// use directory.mkdirs(); here instead.
		}
		int index=0;
		for(ImageBinary imgBin : imageBinaryList) {
			String imageFileName = directoryName + "img_"+index+".jpg";
			try {
				FileUtils.writeByteArrayToFile(new File(imageFileName), imgBin.getImageFile());				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			index = index + 1;
		}				
		/** Write the file locally **/

		return "Written Successfully";
	}

	@Override
	public String readFileFromWorker(String directoryName, Location workerLocation) throws TException {

		if(directoryName.charAt(directoryName.length()-1) != '/') {
			directoryName = directoryName + "/";
		}
		LOGGER.info(directoryName);
		
		ArrayList<String> imageFileNameList = new ArrayList<String>();
		File folder = new File(directoryName);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				LOGGER.info("File " + listOfFiles[i].getName());
				imageFileNameList.add(directoryName+listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				LOGGER.info("Directory " + listOfFiles[i].getName());			
				
			}
		}

		List<ImageBinary> imageBinaryList = new ArrayList<ImageBinary>();
		
		for(String imageFile : imageFileNameList) {
			Path path = Paths.get(imageFile);

			byte[] payloadByteArray = null;
			try {
				payloadByteArray = Files.readAllBytes(path);
				ImageBinary  myBinImage = new ImageBinary();
				myBinImage.setImageFile(payloadByteArray);
				myBinImage.setFileLength(payloadByteArray.length);
				imageBinaryList.add(myBinImage);
				LOGGER.info("The length of the payload is " + payloadByteArray.length);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		
		TTransport transport = new TFramedTransport(new TSocket(workerLocation.getIP(), workerLocation.getPort()));
		try {
			transport.open();
		} catch (TTransportException e) {
			transport.close();
			LOGGER.error("Error opening connection to Master IP : {} and port : {}", workerLocation.getIP(),
					workerLocation.getPort());
			e.printStackTrace();
		}	

		TProtocol protocol = new TBinaryProtocol(transport);
		WorkerService.Client workerClient = new WorkerService.Client(protocol);
		String result = workerClient.writeFileToWorker(directoryName, imageBinaryList, workerLocation);
		LOGGER.info("Response "+result);
		
		transport.close();
		

		return "Sent all files to Worker";
	}

}