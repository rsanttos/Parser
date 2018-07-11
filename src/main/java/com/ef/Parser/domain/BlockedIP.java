package com.ef.Parser.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Entity representing blocked IPs
 * @author ramonsantos
 *
 */
@Entity
public class BlockedIP {

	/**
	 * Unique identifier of the BlockedIP in the database
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_blocked_ip")
	private long idBlockedIp;

	/**
	 * IP blocked
	 */
	private String ipAddress;

	/**
	 * Blocking justification
	 */
	private String justification;

	public BlockedIP() {
		super();
	}

	public BlockedIP(String ipAddress, String justification) {
		super();
		this.ipAddress = ipAddress;
		this.justification = justification;
	}

	public long getIdBlockedIp() {
		return idBlockedIp;
	}

	public void setIdBlockedIp(long idBlockedIp) {
		this.idBlockedIp = idBlockedIp;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

}
