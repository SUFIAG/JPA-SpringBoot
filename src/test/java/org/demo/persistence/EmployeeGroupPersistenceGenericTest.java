package org.demo.persistence;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.demo.data.record.EmployeeGroupRecord ;
import org.demo.persistence.EmployeeGroupPersistence;

/**
 * Generic test class for a persistence service
 * 
 */
public class EmployeeGroupPersistenceGenericTest {

	/**
	 * Generic test for a persistence service
	 * @param persistenceService
	 * @throws SQLException
	 */
	public void testPersistenceService(EmployeeGroupPersistence persistenceService) {
    	System.out.println("--- test EmployeeGroupPersistence ");

    	EmployeeGroupRecord employeeGroup = new EmployeeGroupRecord();
		//--- Key values
		employeeGroup.setEmployeeCode("AAAA"); // "EMPLOYEE_CODE" : java.lang.String
		employeeGroup.setGroupId(Short.valueOf((short)1)); // "GROUP_ID" : java.lang.Short
		//--- Other values


    	//--- DELETE
    	System.out.println("Delete : " + employeeGroup );
    	persistenceService.delete(employeeGroup) ; // Just to be sure it doesn't exist before insert

		long initialCount = persistenceService.countAll() ;
    	System.out.println("Initial count = " + initialCount );

    	//--- CREATE
    	System.out.println("Create : " + employeeGroup );

    	persistenceService.create(employeeGroup);
    	assertTrue( persistenceService.exists("AAAA", Short.valueOf((short)1)) );
		assertTrue( persistenceService.exists(employeeGroup) );
		long count = persistenceService.countAll() ;
    	System.out.println("Count = " + count );
		assertEquals(initialCount+1, count );

    	//--- FIND
    	System.out.println("Find by id..." );
    	EmployeeGroupRecord employeeGroup2 = persistenceService.findById("AAAA", Short.valueOf((short)1));
    	System.out.println("Found : " + employeeGroup2 );
    	assertNotNull(employeeGroup2);
		assertTrue( employeeGroup2.getEmployeeCode().equals("AAAA") ) ;
		assertTrue( employeeGroup2.getGroupId().equals(Short.valueOf((short)1)) ) ;
    	assertTrue( persistenceService.exists(employeeGroup2) ) ;
    	
    	//--- NO UPDATE FOR THIS ENTITY (ALL COLUMNS IN PRIMARY KEY)
    	
    	//--- RELOAD AFTER UPDATE
    	System.out.println("Find by id..." );
    	EmployeeGroupRecord employeeGroup3 = persistenceService.findById("AAAA", Short.valueOf((short)1));
    	assertNotNull(employeeGroup3);
    	System.out.println("Found : " + employeeGroup3 );

    	//--- DELETE
    	System.out.println("Delete : " + employeeGroup2 );
    	assertTrue( persistenceService.delete(employeeGroup2) ); // Delete #1 : OK
    	assertFalse( persistenceService.delete(employeeGroup2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById("AAAA", Short.valueOf((short)1)) ); // Nothing (already deleted)

		long finalCount = persistenceService.countAll() ;
    	System.out.println("Final count = " + finalCount );
		assertEquals(initialCount, finalCount);

    	assertFalse( persistenceService.exists("AAAA", Short.valueOf((short)1)) ) ;
    	assertFalse( persistenceService.exists(employeeGroup2) ) ;
    	employeeGroup2 = persistenceService.findById("AAAA", Short.valueOf((short)1));
    	assertNull( employeeGroup2 );
    	
    	System.out.println("Normal end of persistence service test." );
	}
}
