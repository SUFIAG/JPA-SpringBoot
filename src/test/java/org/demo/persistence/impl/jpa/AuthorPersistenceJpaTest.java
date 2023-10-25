package org.demo.persistence.impl.jpa;

import org.demo.persistence.AuthorPersistence ;
import org.demo.persistence.AuthorPersistenceGenericTest;
import org.junit.Test;

/**
 * JUnit tests for Author persistence service
 */
public class AuthorPersistenceJpaTest extends AuthorPersistenceGenericTest {

	@Test
	public void testPersistenceService() {

    	AuthorPersistence persistenceService = new AuthorPersistenceJpa();


    	testPersistenceService(persistenceService);
	}	
}
