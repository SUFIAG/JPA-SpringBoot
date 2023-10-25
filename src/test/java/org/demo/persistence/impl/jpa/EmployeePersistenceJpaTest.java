package org.demo.persistence.impl.jpa;

import org.demo.persistence.EmployeePersistence ;
import org.demo.persistence.EmployeePersistenceGenericTest;
import org.junit.Test;

/**
 * JUnit tests for Employee persistence service
 */
public class EmployeePersistenceJpaTest extends EmployeePersistenceGenericTest {

	@Test
	public void testPersistenceService() {

    	EmployeePersistence persistenceService = new EmployeePersistenceJpa();


    	testPersistenceService(persistenceService);
	}	
}
