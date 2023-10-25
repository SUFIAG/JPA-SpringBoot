package org.demo.persistence.impl.jpa;

import org.demo.persistence.PublisherPersistence ;
import org.demo.persistence.PublisherPersistenceGenericTest;
import org.junit.Test;

/**
 * JUnit tests for Publisher persistence service
 */
public class PublisherPersistenceJpaTest extends PublisherPersistenceGenericTest {

	@Test
	public void testPersistenceService() {

    	PublisherPersistence persistenceService = new PublisherPersistenceJpa();


    	testPersistenceService(persistenceService);
	}	
}
