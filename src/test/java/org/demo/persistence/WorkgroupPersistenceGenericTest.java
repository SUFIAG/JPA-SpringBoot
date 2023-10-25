package org.demo.persistence;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.demo.data.record.WorkgroupRecord ;
import org.demo.persistence.WorkgroupPersistence;

/**
 * Generic test class for a persistence service
 */
public class WorkgroupPersistenceGenericTest {

	/**
	 * Generic test for a persistence service
	 * @param persistenceService
	 * @throws SQLException
	 */
	public void testPersistenceService(WorkgroupPersistence persistenceService) {
    	System.out.println("--- test WorkgroupPersistence ");

    	WorkgroupRecord workgroup = new WorkgroupRecord();
		//--- Key values
		workgroup.setId(Short.valueOf((short)1)); // "ID" : java.lang.Short
		//--- Other values
		workgroup.setName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "NAME" : java.lang.String
		workgroup.setDescription("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "DESCRIPTION" : java.lang.String
		workgroup.setCreationDate(java.sql.Date.valueOf("2001-06-22")); // "CREATION_DATE" : java.util.Date


    	//--- DELETE
    	System.out.println("Delete : " + workgroup );
    	persistenceService.delete(workgroup) ; // Just to be sure it doesn't exist before insert

		long initialCount = persistenceService.countAll() ;
    	System.out.println("Initial count = " + initialCount );

    	//--- CREATE
    	System.out.println("Create : " + workgroup );

    	persistenceService.create(workgroup);
    	assertTrue( persistenceService.exists(Short.valueOf((short)1)) );
		assertTrue( persistenceService.exists(workgroup) );
		long count = persistenceService.countAll() ;
    	System.out.println("Count = " + count );
		assertEquals(initialCount+1, count );

    	//--- FIND
    	System.out.println("Find by id..." );
    	WorkgroupRecord workgroup2 = persistenceService.findById(Short.valueOf((short)1));
    	System.out.println("Found : " + workgroup2 );
    	assertNotNull(workgroup2);
		assertTrue( workgroup2.getId().equals(Short.valueOf((short)1)) ) ;
    	assertTrue( persistenceService.exists(workgroup2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		workgroup2.setName("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "NAME" : java.lang.String
		workgroup2.setDescription("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "DESCRIPTION" : java.lang.String
		workgroup2.setCreationDate(java.sql.Date.valueOf("2002-06-22")); // "CREATION_DATE" : java.util.Date
    	System.out.println("Update : " + workgroup2 );
    	assertTrue( persistenceService.update(workgroup2) );
    	
    	//--- RELOAD AFTER UPDATE
    	System.out.println("Find by id..." );
    	WorkgroupRecord workgroup3 = persistenceService.findById(Short.valueOf((short)1));
    	assertNotNull(workgroup3);
    	System.out.println("Found : " + workgroup3 );
		assertEquals(workgroup2.getName(), workgroup3.getName() ); 
		assertEquals(workgroup2.getDescription(), workgroup3.getDescription() ); 
		assertEquals(workgroup2.getCreationDate(), workgroup3.getCreationDate() ); 

    	//--- DELETE
    	System.out.println("Delete : " + workgroup2 );
    	assertTrue( persistenceService.delete(workgroup2) ); // Delete #1 : OK
    	assertFalse( persistenceService.delete(workgroup2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById(Short.valueOf((short)1)) ); // Nothing (already deleted)

		long finalCount = persistenceService.countAll() ;
    	System.out.println("Final count = " + finalCount );
		assertEquals(initialCount, finalCount);

    	assertFalse( persistenceService.exists(Short.valueOf((short)1)) ) ;
    	assertFalse( persistenceService.exists(workgroup2) ) ;
    	workgroup2 = persistenceService.findById(Short.valueOf((short)1));
    	assertNull( workgroup2 );
    	
    	System.out.println("Normal end of persistence service test." );
	}
}
