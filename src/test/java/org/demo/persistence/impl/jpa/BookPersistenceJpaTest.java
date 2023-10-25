package org.demo.persistence.impl.jpa;

import org.demo.persistence.BookPersistence ;
import org.demo.persistence.BookPersistenceGenericTest;
import org.junit.Test;

/**
 * JUnit tests for Book persistence service
 */
public class BookPersistenceJpaTest extends BookPersistenceGenericTest {

	@Test
	public void testPersistenceService() {

    	BookPersistence persistenceService = new BookPersistenceJpa();


    	testPersistenceService(persistenceService);
	}	
}
