package org.demo.persistence;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.demo.data.record.CustomerRecord ;
import org.demo.persistence.CustomerPersistence;

/**
 * Generic test class for a persistence service
 * 
 */
public class CustomerPersistenceGenericTest {

	/**
	 * Generic test for a persistence service
	 * @param persistenceService
	 * @throws SQLException
	 */
	public void testPersistenceService(CustomerPersistence persistenceService) {
    	System.out.println("--- test CustomerPersistence ");

    	CustomerRecord customer = new CustomerRecord();
		//--- Key values
		customer.setCode("AAAAA"); // "CODE" : java.lang.String
		//--- Other values
		customer.setCountryCode("AA"); // "COUNTRY_CODE" : java.lang.String
		customer.setFirstName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "FIRST_NAME" : java.lang.String
		customer.setLastName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "LAST_NAME" : java.lang.String
		customer.setLogin("AAAAAAAAAAAAAAAAAAAA"); // "LOGIN" : java.lang.String
		customer.setPassword("AAAAAAAAAAAAAAAAAAAA"); // "PASSWORD" : java.lang.String
		customer.setAge(Integer.valueOf(100)); // "AGE" : java.lang.Integer
		customer.setCity("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "CITY" : java.lang.String
		customer.setZipCode(Integer.valueOf(100)); // "ZIP_CODE" : java.lang.Integer
		customer.setPhone("AAAAAAAAAAAAAAAAAAAA"); // "PHONE" : java.lang.String
		customer.setReviewer(Short.valueOf((short)1)); // "REVIEWER" : java.lang.Short


    	//--- DELETE
    	System.out.println("Delete : " + customer );
    	persistenceService.delete(customer) ; // Just to be sure it doesn't exist before insert

		long initialCount = persistenceService.countAll() ;
    	System.out.println("Initial count = " + initialCount );

    	//--- CREATE
    	System.out.println("Create : " + customer );

    	persistenceService.create(customer);
    	assertTrue( persistenceService.exists("AAAAA") );
		assertTrue( persistenceService.exists(customer) );
		long count = persistenceService.countAll() ;
    	System.out.println("Count = " + count );
		assertEquals(initialCount+1, count );

    	//--- FIND
    	System.out.println("Find by id..." );
    	CustomerRecord customer2 = persistenceService.findById("AAAAA");
    	System.out.println("Found : " + customer2 );
    	assertNotNull(customer2);
		assertTrue( customer2.getCode().equals("AAAAA") ) ;
    	assertTrue( persistenceService.exists(customer2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		customer2.setCountryCode("BB"); // "COUNTRY_CODE" : java.lang.String
		customer2.setFirstName("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "FIRST_NAME" : java.lang.String
		customer2.setLastName("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "LAST_NAME" : java.lang.String
		customer2.setLogin("BBBBBBBBBBBBBBBBBBBB"); // "LOGIN" : java.lang.String
		customer2.setPassword("BBBBBBBBBBBBBBBBBBBB"); // "PASSWORD" : java.lang.String
		customer2.setAge(Integer.valueOf(200)); // "AGE" : java.lang.Integer
		customer2.setCity("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "CITY" : java.lang.String
		customer2.setZipCode(Integer.valueOf(200)); // "ZIP_CODE" : java.lang.Integer
		customer2.setPhone("BBBBBBBBBBBBBBBBBBBB"); // "PHONE" : java.lang.String
		customer2.setReviewer(Short.valueOf((short)2)); // "REVIEWER" : java.lang.Short
    	System.out.println("Update : " + customer2 );
    	assertTrue( persistenceService.update(customer2) );
    	
    	//--- RELOAD AFTER UPDATE
    	System.out.println("Find by id..." );
    	CustomerRecord customer3 = persistenceService.findById("AAAAA");
    	assertNotNull(customer3);
    	System.out.println("Found : " + customer3 );
		assertEquals(customer2.getCountryCode(), customer3.getCountryCode() ); 
		assertEquals(customer2.getFirstName(), customer3.getFirstName() ); 
		assertEquals(customer2.getLastName(), customer3.getLastName() ); 
		assertEquals(customer2.getLogin(), customer3.getLogin() ); 
		assertEquals(customer2.getPassword(), customer3.getPassword() ); 
		assertEquals(customer2.getAge(), customer3.getAge() ); 
		assertEquals(customer2.getCity(), customer3.getCity() ); 
		assertEquals(customer2.getZipCode(), customer3.getZipCode() ); 
		assertEquals(customer2.getPhone(), customer3.getPhone() ); 
		assertEquals(customer2.getReviewer(), customer3.getReviewer() ); 

    	//--- DELETE
    	System.out.println("Delete : " + customer2 );
    	assertTrue( persistenceService.delete(customer2) ); // Delete #1 : OK
    	assertFalse( persistenceService.delete(customer2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById("AAAAA") ); // Nothing (already deleted)

		long finalCount = persistenceService.countAll() ;
    	System.out.println("Final count = " + finalCount );
		assertEquals(initialCount, finalCount);

    	assertFalse( persistenceService.exists("AAAAA") ) ;
    	assertFalse( persistenceService.exists(customer2) ) ;
    	customer2 = persistenceService.findById("AAAAA");
    	assertNull( customer2 );
    	
    	System.out.println("Normal end of persistence service test." );
	}
}
