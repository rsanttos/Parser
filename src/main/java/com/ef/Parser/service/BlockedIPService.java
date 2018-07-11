package com.ef.Parser.service;

import com.ef.Parser.dao.BlockedIPDAO;
import com.ef.Parser.domain.BlockedIP;

/**
 * Class of Service for BlockedIP
 * Class responsible for managing business rules and performing interaction with the DAO layer
 * @author ramonsantos
 *
 */
public class BlockedIPService {

	private BlockedIPDAO blockedIpDao;
	
	public BlockedIPService() {
		this.blockedIpDao = new BlockedIPDAO();
	}
	
	public void saveOrUpdate(BlockedIP blockedIp) {
		blockedIpDao.saveOrUpdate(blockedIp);
	}
	
}
