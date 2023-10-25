package org.demo.persistence.impl.jpa.commons;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 * JPA operation interface
 * Provided by Telosys Tools for JPA testing
 *
 */
public interface JpaOperation {

	/**
	 * Executes a JPA operation using the given EntityManager
	 * @param em the EntityManager to be used
	 * @return
	 * @throws PersistenceException
	 */
	public Object execute(EntityManager em) throws PersistenceException;
	
}
