package org.demo.persistence.impl.jpa.commons;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 * JPA environment for JPA operations execution <br>
 * Provided by Telosys Tools for JPA testing
 * 
 */
public class JpaEnvironment {

	private final String persistenceUnitName ; 
	
	private final EntityManagerFactory emf ; 
	
	/**
	 * Constructor 
	 * @param persistenceUnitName the name of the JPA persistence unit to be used
	 */
	public JpaEnvironment(String persistenceUnitName ) {
		super();
		this.persistenceUnitName = persistenceUnitName ;
		this.emf = Persistence.createEntityManagerFactory(persistenceUnitName);
	}


	public final String getPersistenceUnitName() {
		return this.persistenceUnitName ;
	}
	
	public final Object executeWithTransaction(JpaOperation operation) throws PersistenceException {
		
		Object result = null ;
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();

			try {
				// Begin Transaction
				transaction.begin();
				
				// Execute application JPA operation with the current EntityManager
				result = operation.execute(em);
				
				// Commit Transaction
				transaction.commit();
				
			} finally {
				// Rollback Transaction if Transaction is still active ( Commit not done )
				if (transaction.isActive())
					transaction.rollback();
			}
		} finally {
			// Ensure EntityManager is closed 
			em.close();
		}
		
		return result ;
	}

	public final Object executeWithoutTransaction(JpaOperation operation) throws PersistenceException {
		
		Object result = null ;
		EntityManager em = emf.createEntityManager();
		try {
				// Execute application JPA operation with the current EntityManager
				result = operation.execute(em);
				
		} finally {
			// Ensure EntityManager is closed 
			em.close();
		}
		
		return result ;
	}
	
}
