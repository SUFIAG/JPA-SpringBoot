package org.demo.persistence;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.demo.data.record.BadgeRecord ;
import org.demo.persistence.BadgePersistence;

/**
 * Generic test class for a persistence service
 * 
 */
public class BadgePersistenceGenericTest {

	/**
	 * Generic test for a persistence service
	 * @param persistenceService
	 * @throws SQLException
	 */
	public void testPersistenceService(BadgePersistence persistenceService) {
    	System.out.println("--- test BadgePersistence ");

    	BadgeRecord badge = new BadgeRecord();
		//--- Key values
		badge.setBadgeNumber(Integer.valueOf(100)); // "BADGE_NUMBER" : java.lang.Integer
		//--- Other values
		badge.setAuthorizationLevel(Short.valueOf((short)1)); // "AUTHORIZATION_LEVEL" : java.lang.Short
		badge.setEndOfValidity(java.sql.Date.valueOf("2001-06-22")); // "END_OF_VALIDITY" : java.util.Date


    	//--- DELETE
    	System.out.println("Delete : " + badge );
    	persistenceService.delete(badge) ; // Just to be sure it doesn't exist before insert

		long initialCount = persistenceService.countAll() ;
    	System.out.println("Initial count = " + initialCount );

    	//--- CREATE
    	System.out.println("Create : " + badge );

    	persistenceService.create(badge);
    	assertTrue( persistenceService.exists(Integer.valueOf(100)) );
		assertTrue( persistenceService.exists(badge) );
		long count = persistenceService.countAll() ;
    	System.out.println("Count = " + count );
		assertEquals(initialCount+1, count );

    	//--- FIND
    	System.out.println("Find by id..." );
    	BadgeRecord badge2 = persistenceService.findById(Integer.valueOf(100));
    	System.out.println("Found : " + badge2 );
    	assertNotNull(badge2);
		assertTrue( badge2.getBadgeNumber().equals(Integer.valueOf(100)) ) ;
    	assertTrue( persistenceService.exists(badge2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		badge2.setAuthorizationLevel(Short.valueOf((short)2)); // "AUTHORIZATION_LEVEL" : java.lang.Short
		badge2.setEndOfValidity(java.sql.Date.valueOf("2002-06-22")); // "END_OF_VALIDITY" : java.util.Date
    	System.out.println("Update : " + badge2 );
    	assertTrue( persistenceService.update(badge2) );
    	
    	//--- RELOAD AFTER UPDATE
    	System.out.println("Find by id..." );
    	BadgeRecord badge3 = persistenceService.findById(Integer.valueOf(100));
    	assertNotNull(badge3);
    	System.out.println("Found : " + badge3 );
		assertEquals(badge2.getAuthorizationLevel(), badge3.getAuthorizationLevel() ); 
		assertEquals(badge2.getEndOfValidity(), badge3.getEndOfValidity() ); 

    	//--- DELETE
    	System.out.println("Delete : " + badge2 );
    	assertTrue( persistenceService.delete(badge2) ); // Delete #1 : OK
    	assertFalse( persistenceService.delete(badge2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById(Integer.valueOf(100)) ); // Nothing (already deleted)

		long finalCount = persistenceService.countAll() ;
    	System.out.println("Final count = " + finalCount );
		assertEquals(initialCount, finalCount);

    	assertFalse( persistenceService.exists(Integer.valueOf(100)) ) ;
    	assertFalse( persistenceService.exists(badge2) ) ;
    	badge2 = persistenceService.findById(Integer.valueOf(100));
    	assertNull( badge2 );
    	
    	System.out.println("Normal end of persistence service test." );
	}
}
