package com.ef.Parser.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Class responsible for managing the connection to the Database
 * Singleton
 * @author ramonsantos
 *
 */
public class HibernateUtil {

	private static EntityManagerFactory INSTANCE;

	public static EntityManager getManager() {
		if (INSTANCE == null) {
			INSTANCE = Persistence.createEntityManagerFactory("logs");
		}
		return INSTANCE.createEntityManager();
	}
}