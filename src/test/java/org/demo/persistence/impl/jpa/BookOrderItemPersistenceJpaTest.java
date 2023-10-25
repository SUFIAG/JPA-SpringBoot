package org.demo.persistence.impl.jpa;

import org.demo.persistence.BookOrderItemPersistence ;
import org.demo.persistence.BookOrderItemPersistenceGenericTest;
import org.junit.Test;

/**
 * JUnit tests for BookOrderItem persistence service
 */
public class BookOrderItemPersistenceJpaTest extends BookOrderItemPersistenceGenericTest {

	@Test
	public void testPersistenceService() {

    	BookOrderItemPersistence persistenceService = new BookOrderItemPersistenceJpa();


    	testPersistenceService(persistenceService);
	}	
}
