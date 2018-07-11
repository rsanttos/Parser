package com.ef.Parser.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.ef.Parser.dao.LogDAO;
import com.ef.Parser.domain.BlockedIP;
import com.ef.Parser.domain.Log;
import com.ef.Parser.enums.DurationEnum;
import com.ef.Parser.factory.JustificationFactory;
import com.ef.Parser.utils.DateUtil;

/**
 * Class of Service for Log Class responsible for managing business rules and
 * performing interaction with the DAO layer
 * 
 * @author ramonsantos
 *
 */
public class LogService {

	private LogDAO logDao;

	private BlockedIPService blockedIpService;

	public LogService() {
		this.logDao = new LogDAO();
		this.blockedIpService = new BlockedIPService();
	}

	/**
	 * Method responsible for verifying IP access according to received parameters
	 * 
	 * @param start
	 * @param duration
	 * @param threshold
	 * @throws ParseException
	 */
	public void analyzeIpAddressByPeriod(Date start, String duration, int threshold) throws ParseException {
		Date startDate = start;
		Date endDate = new Date();
		if (duration.equals(DurationEnum.DAILY.value)) {
			endDate = DateUtil.getNextDay(startDate);
		} else if (duration.equals(DurationEnum.HOURLY.value)) {
			endDate = DateUtil.getNextHour(startDate);
		}
		for (String str : countIpAddressByPeriod(startDate.getTime(), endDate.getTime())) {
			String[] concatenate = str.split("-");
			if (Integer.parseInt(concatenate[0]) > threshold) {
				System.out.println(String.format("IP address: %s | Number of access: %s | Status: IP was blocked.",
						concatenate[1], concatenate[0]));
				BlockedIP blockedIp = new BlockedIP(str,
						JustificationFactory.getJustification(startDate, endDate, concatenate[0]));
				blockedIpService.saveOrUpdate(blockedIp);
			}
		}
	}

	/**
	 * Method responsible for obtaining the number of accesses of each IP
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<String> countIpAddressByPeriod(long startDate, long endDate) {
		return logDao.countIpAddressByPeriod(startDate, endDate);
	}
}
