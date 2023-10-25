package org.demo.persistence.impl.jpa;

import org.demo.persistence.EmployeeGroupPersistence ;
import org.demo.persistence.EmployeeGroupPersistenceGenericTest;
import org.junit.Test;

/**
 * JUnit tests for EmployeeGroup persistence service
 */
public class EmployeeGroupPersistenceJpaTest extends EmployeeGroupPersistenceGenericTest {

	@Test
	public void testPersistenceService() {

    	EmployeeGroupPersistence persistenceService = new EmployeeGroupPersistenceJpa();


    	testPersistenceService(persistenceService);
	}	
}
