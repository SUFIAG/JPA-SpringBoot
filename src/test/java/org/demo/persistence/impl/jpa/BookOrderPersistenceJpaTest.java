package org.demo.persistence.impl.jpa;

import org.demo.persistence.BookOrderPersistence ;
import org.demo.persistence.BookOrderPersistenceGenericTest;
import org.junit.Test;

/**
 * JUnit tests for BookOrder persistence service
 */
public class BookOrderPersistenceJpaTest extends BookOrderPersistenceGenericTest {

	@Test
	public void testPersistenceService() {

    	BookOrderPersistence persistenceService = new BookOrderPersistenceJpa();


    	testPersistenceService(persistenceService);
	}	
}
