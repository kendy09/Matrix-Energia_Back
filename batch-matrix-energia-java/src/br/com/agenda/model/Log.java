package br.com.agenda.model;

public class Log {
	private long id;
	private String data;
	private String ip;
	private String request;
	private int status;
	private String user_agent;
	public long getId() {
		return id;
	}
	

	public Log(long id, String data, String ip, String request, int status, String user_agent) {
		super();
		this.id = id;
		this.data = data;
		this.ip = ip;
		this.request = request;
		this.status = status;
		this.user_agent = user_agent;
	}


	public Log() {
		// TODO Auto-generated constructor stub
	}


	public void setId(long id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUser_agent() {
		return user_agent;
	}
	public void setUser_agent(String user_agent) {
		this.user_agent = user_agent;
	}
	
	
}