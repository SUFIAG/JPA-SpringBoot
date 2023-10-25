package org.demo.persistence.impl.jpa;

import org.demo.persistence.CountryPersistence ;
import org.demo.persistence.CountryPersistenceGenericTest;
import org.junit.Test;

/**
 * JUnit tests for Country persistence service
 */
public class CountryPersistenceJpaTest extends CountryPersistenceGenericTest {

	@Test
	public void testPersistenceService() {

    	CountryPersistence persistenceService = new CountryPersistenceJpa();


    	testPersistenceService(persistenceService);
	}	
}
