package org.demo.persistence.impl.jpa;

import org.demo.persistence.BadgePersistence ;
import org.demo.persistence.BadgePersistenceGenericTest;
import org.junit.Test;

/**
 * JUnit tests for Badge persistence service
 */
public class BadgePersistenceJpaTest extends BadgePersistenceGenericTest {

	@Test
	public void testPersistenceService() {

    	BadgePersistence persistenceService = new BadgePersistenceJpa();


    	testPersistenceService(persistenceService);
	}	
}
