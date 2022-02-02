package model;

public class WorkerInfo {
	
	private String IP;
	private Integer port;
	
	public WorkerInfo(String argIP, Integer argPort) {
		IP = argIP;
		port = argPort;
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
