package br.com.matrixenergia.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Log")
public class Logs  {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
    
	@NotNull(message="O atributo é obrigatorio")
	@Size(max = 15)
	private String ip;
	
	@NotNull(message="O atributo request é obrigatorio")
	@Size(max=50)
	private String request;
	
	@NotNull(message="O atributo status é obrigatorio")
	private int status;
	
	@NotNull(message="O atributo user agent é obrigatorio")
	private String userAgent;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
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

	@Override
	public String toString() {
		return "Logs [id=" + id + ", data=" + data + ", ip=" + ip + ", request=" + request + ", status=" + status
				+ ", userAgent=" + userAgent + "]";
	}
		
}
