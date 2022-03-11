package model;

public class WorkerInfo {
	
	@Override
	public String toString() {
		return "WorkerInfo [IP=" + IP + ", port=" + port + ", ID=" + ID + ", resourceType=" + resourceType
				+ ", subResourceType=" + subResourceType + "]";
	}

	private String IP;
	private Integer port;
	private Integer ID;
	private String resourceType;
	private String subResourceType;
	
	public String getSubResourceType() {
		return subResourceType;
	}

	public void setSubResourceType(String subResourceType) {
		this.subResourceType = subResourceType;
	}

	public WorkerInfo() {
		
	}
	
	public WorkerInfo(String argIP, Integer argPort, Integer argID, String argResourceType,String argSubResourceType) {
		IP = argIP;
		port = argPort;
		ID = argID;
		resourceType = argResourceType;
		subResourceType = argSubResourceType;
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
