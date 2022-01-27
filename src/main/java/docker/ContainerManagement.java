package docker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

		try {
			
			LOGGER.info("Setting docker with the following configuration ");
			dockerClient.updateContainerCmd("2d7cf8bc4b05").withCpuQuota((int)specs.getVCPUs());

			Process p = Runtime.getRuntime().exec("python call_container.py");
			try {
				p.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));			

			// read the output from the command
			LOGGER.info("Here is the standard output of the command:\n");
			String s;
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
			}
						
		} catch (IOException e) {
			System.out.println("exception happened - here's what I know: ");
			e.printStackTrace();
			System.exit(-1);
		}
	}
	

	public void stopContainer() {

	}

}
