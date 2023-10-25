package org.demo.persistence.impl.jpa;

import org.demo.persistence.ReviewPersistence ;
import org.demo.persistence.ReviewPersistenceGenericTest;
import org.junit.Test;

/**
 * JUnit tests for Review persistence service
 */
public class ReviewPersistenceJpaTest extends ReviewPersistenceGenericTest {

	@Test
	public void testPersistenceService() {

    	ReviewPersistence persistenceService = new ReviewPersistenceJpa();


    	testPersistenceService(persistenceService);
	}	
}
