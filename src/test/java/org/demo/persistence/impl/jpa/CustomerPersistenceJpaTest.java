package org.demo.persistence.impl.jpa;

import org.demo.persistence.CustomerPersistence ;
import org.demo.persistence.CustomerPersistenceGenericTest;
import org.junit.Test;

/**
 * JUnit tests for Customer persistence service
 */
public class CustomerPersistenceJpaTest extends CustomerPersistenceGenericTest {

	@Test
	public void testPersistenceService() {

    	CustomerPersistence persistenceService = new CustomerPersistenceJpa();


    	testPersistenceService(persistenceService);
	}	
}
