package org.demo.persistence.impl.jpa.commons;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JpaPersistenceConfigTest {

	private final static String PERSISTENCE_UNIT_NAME = "h2-test" ; // Expected unit name for JUnit tests
	
	@Test
	public void testConfig() {
		System.out.println("Test / JpaPersistenceConfig " );
		JpaPersistenceConfig config = new JpaPersistenceConfig() ;
		String persistenceUnitName = config.getPersistenceUnitName();
		System.out.println("  persistenceUnitName = " + persistenceUnitName );
		assertEquals(PERSISTENCE_UNIT_NAME, persistenceUnitName);
	}
	
	@Test
	public void testJpaEnvironment() {
		System.out.println("Test / JpaEnvironment " );
		
		JpaEnvironments environments = JpaEnvironments.getInstance();
		Assert.assertNotNull( environments );
		
		// Get the default persistence environment : supposed to be the H2 database used for JUnit tests 
		JpaEnvironment jpaEnvironment = environments.getJpaEnvironment();
		Assert.assertNotNull( jpaEnvironment );

		String persistenceUnitName = jpaEnvironment.getPersistenceUnitName() ;
		System.out.println("  persistenceUnitName = " + persistenceUnitName );
    	Assert.assertEquals(PERSISTENCE_UNIT_NAME, persistenceUnitName);
    	
	}

	@Test
	public void testJpaEnvironmentH2() {
		System.out.println("Test / JpaEnvironment for H2" );
		
		JpaEnvironment jpaEnvironment = JpaEnvironments.getInstance().getJpaEnvironment(PERSISTENCE_UNIT_NAME);
		Assert.assertNotNull( jpaEnvironment );

    	Assert.assertEquals(PERSISTENCE_UNIT_NAME, jpaEnvironment.getPersistenceUnitName());
    	
	}

	@Test (expected= javax.persistence.PersistenceException.class )
	public void testJpaEnvironmentUNDEFINED() {
		System.out.println("Test / JpaEnvironment for UNDEFINED" );
		
		JpaEnvironments.getInstance().getJpaEnvironment("UNDEFINED"); // throws PersistenceException
	}

}
