package com.ef.Parser.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Class responsible for entity representation Log
 * 
 * @author ramonsantos
 *
 */
@Entity
public class Log {

	/**
	 * Unique identifier of the Log in the database
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_log")
	private long idLog;

	/**
	 * Access date
	 */
	private long dateOfAccess;

	/**
	 * Origin Ip Address
	 */
	private String ipAddress;

	/**
	 * Status of request
	 */
	private Integer requestStatus;

	/**
	 * Information about the request made
	 */
	private String request;

	/**
	 * Agent used to make the request
	 */
	private String userAgent;

	public Log() {
		super();
	}

	public Log(long dateOfAccess, String ipAddress, Integer requestStatus, String request, String userAgent) {
		super();
		this.dateOfAccess = dateOfAccess;
		this.ipAddress = ipAddress;
		this.requestStatus = requestStatus;
		this.request = request;
		this.userAgent = userAgent;
	}

	public void setDateOfAccess(long dateOfAccess) {
		this.dateOfAccess = dateOfAccess;
	}

	public long getIdLog() {
		return idLog;
	}

	public void setIdLog(long idLog) {
		this.idLog = idLog;
	}

	public long getDateOfAccess() {
		return dateOfAccess;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public Integer getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(Integer requestStatus) {
		this.requestStatus = requestStatus;
	}

	@Override
	public String toString() {
		return "Log [idLog=" + idLog + ", dateOfAccess=" + dateOfAccess + ", ipAddress=" + ipAddress
				+ ", requestStatus=" + requestStatus + ", request=" + request + ", userAgent=" + userAgent + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idLog ^ (idLog >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Log other = (Log) obj;
		if (idLog != other.idLog)
			return false;
		return true;
	}

}

