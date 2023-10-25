package org.demo.persistence.impl.jpa;

import org.demo.persistence.SynopsisPersistence ;
import org.demo.persistence.SynopsisPersistenceGenericTest;
import org.junit.Test;

/**
 * JUnit tests for Synopsis persistence service
 */
public class SynopsisPersistenceJpaTest extends SynopsisPersistenceGenericTest {

	@Test
	public void testPersistenceService() {

    	SynopsisPersistence persistenceService = new SynopsisPersistenceJpa();


    	testPersistenceService(persistenceService);
	}	
}
