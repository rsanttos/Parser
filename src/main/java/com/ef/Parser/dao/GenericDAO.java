package com.ef.Parser.dao;

import javax.persistence.EntityManager;

import com.ef.Parser.utils.HibernateUtil;

/**
 * Generic class for entity data persistence
 * @author ramonsantos
 *
 */
public class GenericDAO {
	
	public static EntityManager manager;

	public void saveOrUpdate(Object obj) {		
		manager = HibernateUtil.getManager();
		manager.getTransaction().begin();
		manager.persist(obj);
		manager.getTransaction().commit();
		manager.close();
	}
}
