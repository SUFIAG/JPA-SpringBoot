package org.demo.persistence.impl.jpa;

import org.demo.persistence.WorkgroupPersistence ;
import org.demo.persistence.WorkgroupPersistenceGenericTest;
import org.junit.Test;

/**
 * JUnit tests for Workgroup persistence service
 *
 */
public class WorkgroupPersistenceJpaTest extends WorkgroupPersistenceGenericTest {

	@Test
	public void testPersistenceService() {

    	WorkgroupPersistence persistenceService = new WorkgroupPersistenceJpa();


    	testPersistenceService(persistenceService);
	}	
}
