package org.demo.persistence.impl.jpa;

import org.demo.persistence.ShopPersistence ;
import org.demo.persistence.ShopPersistenceGenericTest;
import org.junit.Test;

/**
 * JUnit tests for Shop persistence service
 */
public class ShopPersistenceJpaTest extends ShopPersistenceGenericTest {

	@Test
	public void testPersistenceService() {

    	ShopPersistence persistenceService = new ShopPersistenceJpa();


    	testPersistenceService(persistenceService);
	}	
}
