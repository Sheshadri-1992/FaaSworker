package docker;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DockerClientBuilder;

import thriftservices.Location;
import thriftservices.Specification;

public class ContainerManagement {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContainerManagement.class);
	DockerClient dockerClient = null;

	public ContainerManagement() {
		dockerClient = DockerClientBuilder.getInstance().build();
		dockerClient.listContainersCmd();
	}

	public void listAllContainers() {

	}

	public void checkFunctionImageExists(String functionImageName) {

		/** Docker code to start the container **/
	}

	public void updateContainerAndStart(String functionName, Specification specs, Location paramLocation,
			String paramFileName) {

		Runnable containerRunnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				startAppropriateContainer(functionName, specs, paramLocation, paramFileName);		
			}
		};
		Thread myThread = new Thread(containerRunnable);
		myThread.start();		
	}

	private void startAppropriateContainer(String functionName, Specification specs, Location paramLocation,
			String paramFileName) {
		try {

			String command = "/usr/bin/python " + functionName + "_function.py " + (int)specs.getVCPUs() + " " + (int)specs.getRAM() + " "
					+ paramLocation.getIP() + " " + paramLocation.getPort() + " " + paramFileName;
			LOGGER.info("The command is "+command);

			Process p = Runtime.getRuntime().exec(command);
			try {
				p.waitFor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

//			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
//			LOGGER.info("Here is the standard output of the command:\n");
//			String s;
//			while ((s = stdInput.readLine()) != null) {
//				System.out.println(s);
//			}

		} catch (IOException e) {
			System.out.println("exception happened - here's what I know: ");
			e.printStackTrace();
			System.exit(-1);
		}

	}
	
	@SuppressWarnings("unused")
	private void startContainer() {
		
	}
	

	public void stopContainer() {
//		ProcessBuilder pb = new 
	}

}
