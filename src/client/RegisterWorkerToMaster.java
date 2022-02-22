package client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import masterthriftservices.FaaSMasterService;
import masterthriftservices.RegisterWorkerRequest;
import masterthriftservices.RegisterWorkerResponse;
import miscellaneous.Constants;

public class RegisterWorkerToMaster {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterWorkerToMaster.class);
	
	public static void registerMyWorker(RegisterWorkerRequest registerReq) {
		
		TTransport transport = new TFramedTransport(new TSocket(Constants.MASTER_IP, Constants.MASTER_PORT));
		try {			
			transport.open();
			TProtocol protocol = new TBinaryProtocol(transport);
			FaaSMasterService.Client masterClient = new FaaSMasterService.Client(protocol);
			
			RegisterWorkerResponse invokeFuncResponse = masterClient.registerWorker(registerReq);
			LOGGER.info("The invoke function response is "+invokeFuncResponse.toString());

		} catch (TTransportException e) {
			transport.close();
			LOGGER.error("Error opening connection to Worker Node IP : {} and port : {}", Constants.MASTER_IP,
					Constants.MASTER_PORT);
			e.printStackTrace();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
