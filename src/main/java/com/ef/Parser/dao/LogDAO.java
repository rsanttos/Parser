package com.ef.Parser.dao;

import java.util.List;

import javax.persistence.Query;

import com.ef.Parser.domain.Log;
import com.ef.Parser.utils.HibernateUtil;

/**
 * Class for persistence and interactions with the database for the Log entity
 * @author ramonsantos
 *
 */
public class LogDAO extends GenericDAO {

	/**
	 * Method responsible for obtaining the number of accesses of each IP in a given period
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<String> countIpAddressByPeriod(long startDate, long endDate) {
		manager = HibernateUtil.getManager();
		String strQuery = "SELECT concat(count(ipAddress), '-', ipAddress) "
				+ "FROM Log WHERE dateOfAccess >= :startDate AND dateOfAccess <= :endDate " + "GROUP BY ipAddress "
				+ "ORDER BY count(ipAddress) DESC";
		Query query = manager.createQuery(strQuery);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		List<String> resultado = query.getResultList();
		manager.close();
		return resultado;
	}
}
