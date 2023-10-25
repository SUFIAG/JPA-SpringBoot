package org.demo.persistence;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.demo.data.record.EmployeeRecord ;
import org.demo.persistence.EmployeePersistence;

/**
 * Generic test class for a persistence service
 * 
 */
public class EmployeePersistenceGenericTest {

	/**
	 * Generic test for a persistence service
	 * @param persistenceService
	 * @throws SQLException
	 */
	public void testPersistenceService(EmployeePersistence persistenceService) {
    	System.out.println("--- test EmployeePersistence ");

    	EmployeeRecord employee = new EmployeeRecord();
		//--- Key values
		employee.setCode("AAAA"); // "CODE" : java.lang.String
		//--- Other values
		employee.setShopCode("AAA"); // "SHOP_CODE" : java.lang.String
		employee.setFirstName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "FIRST_NAME" : java.lang.String
		employee.setLastName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "LAST_NAME" : java.lang.String
		employee.setManager(Short.valueOf((short)1)); // "MANAGER" : java.lang.Short
		employee.setBadgeNumber(Integer.valueOf(100)); // "BADGE_NUMBER" : java.lang.Integer
		employee.setEmail("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "EMAIL" : java.lang.String


    	//--- DELETE
    	System.out.println("Delete : " + employee );
    	persistenceService.delete(employee) ; // Just to be sure it doesn't exist before insert

		long initialCount = persistenceService.countAll() ;
    	System.out.println("Initial count = " + initialCount );

    	//--- CREATE
    	System.out.println("Create : " + employee );

    	persistenceService.create(employee);
    	assertTrue( persistenceService.exists("AAAA") );
		assertTrue( persistenceService.exists(employee) );
		long count = persistenceService.countAll() ;
    	System.out.println("Count = " + count );
		assertEquals(initialCount+1, count );

    	//--- FIND
    	System.out.println("Find by id..." );
    	EmployeeRecord employee2 = persistenceService.findById("AAAA");
    	System.out.println("Found : " + employee2 );
    	assertNotNull(employee2);
		assertTrue( employee2.getCode().equals("AAAA") ) ;
    	assertTrue( persistenceService.exists(employee2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		employee2.setShopCode("BBB"); // "SHOP_CODE" : java.lang.String
		employee2.setFirstName("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "FIRST_NAME" : java.lang.String
		employee2.setLastName("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "LAST_NAME" : java.lang.String
		employee2.setManager(Short.valueOf((short)2)); // "MANAGER" : java.lang.Short
		employee2.setBadgeNumber(Integer.valueOf(200)); // "BADGE_NUMBER" : java.lang.Integer
		employee2.setEmail("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "EMAIL" : java.lang.String
    	System.out.println("Update : " + employee2 );
    	assertTrue( persistenceService.update(employee2) );
    	
    	//--- RELOAD AFTER UPDATE
    	System.out.println("Find by id..." );
    	EmployeeRecord employee3 = persistenceService.findById("AAAA");
    	assertNotNull(employee3);
    	System.out.println("Found : " + employee3 );
		assertEquals(employee2.getShopCode(), employee3.getShopCode() ); 
		assertEquals(employee2.getFirstName(), employee3.getFirstName() ); 
		assertEquals(employee2.getLastName(), employee3.getLastName() ); 
		assertEquals(employee2.getManager(), employee3.getManager() ); 
		assertEquals(employee2.getBadgeNumber(), employee3.getBadgeNumber() ); 
		assertEquals(employee2.getEmail(), employee3.getEmail() ); 

    	//--- DELETE
    	System.out.println("Delete : " + employee2 );
    	assertTrue( persistenceService.delete(employee2) ); // Delete #1 : OK
    	assertFalse( persistenceService.delete(employee2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById("AAAA") ); // Nothing (already deleted)

		long finalCount = persistenceService.countAll() ;
    	System.out.println("Final count = " + finalCount );
		assertEquals(initialCount, finalCount);

    	assertFalse( persistenceService.exists("AAAA") ) ;
    	assertFalse( persistenceService.exists(employee2) ) ;
    	employee2 = persistenceService.findById("AAAA");
    	assertNull( employee2 );
    	
    	System.out.println("Normal end of persistence service test." );
	}
}
