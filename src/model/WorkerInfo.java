package model;

public class WorkerInfo {
	
	@Override
	public String toString() {
		return "WorkerInfo [IP=" + IP + ", port=" + port + ", ID=" + ID + ", resourceType=" + resourceType + "]";
	}

	private String IP;
	private Integer port;
	private Integer ID;
	private String resourceType;
	
	public WorkerInfo() {
		
	}
	
	public WorkerInfo(String argIP, Integer argPort, Integer argID, String argResourceType) {
		IP = argIP;
		port = argPort;
		ID = argID;
		resourceType = argResourceType;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

}
