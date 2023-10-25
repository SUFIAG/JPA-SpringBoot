package org.demo.persistence;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.demo.data.record.AuthorRecord ;
import org.demo.persistence.AuthorPersistence;

/**
 * Generic test class for a persistence service
 * 
 */
public class AuthorPersistenceGenericTest {

	/**
	 * Generic test for a persistence service
	 * @param persistenceService
	 * @throws SQLException
	 */
	public void testPersistenceService(AuthorPersistence persistenceService) {
    	System.out.println("--- test AuthorPersistence ");

    	AuthorRecord author = new AuthorRecord();
		//--- Key values
		author.setId(Integer.valueOf(100)); // "ID" : java.lang.Integer
		//--- Other values
		author.setFirstName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "FIRST_NAME" : java.lang.String
		author.setLastName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "LAST_NAME" : java.lang.String


    	//--- DELETE
    	System.out.println("Delete : " + author );
    	persistenceService.delete(author) ; // Just to be sure it doesn't exist before insert

		long initialCount = persistenceService.countAll() ;
    	System.out.println("Initial count = " + initialCount );

    	//--- CREATE
    	System.out.println("Create : " + author );

    	persistenceService.create(author);
    	assertTrue( persistenceService.exists(Integer.valueOf(100)) );
		assertTrue( persistenceService.exists(author) );
		long count = persistenceService.countAll() ;
    	System.out.println("Count = " + count );
		assertEquals(initialCount+1, count );

    	//--- FIND
    	System.out.println("Find by id..." );
    	AuthorRecord author2 = persistenceService.findById(Integer.valueOf(100));
    	System.out.println("Found : " + author2 );
    	assertNotNull(author2);
		assertTrue( author2.getId().equals(Integer.valueOf(100)) ) ;
    	assertTrue( persistenceService.exists(author2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		author2.setFirstName("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "FIRST_NAME" : java.lang.String
		author2.setLastName("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "LAST_NAME" : java.lang.String
    	System.out.println("Update : " + author2 );
    	assertTrue( persistenceService.update(author2) );
    	
    	//--- RELOAD AFTER UPDATE
    	System.out.println("Find by id..." );
    	AuthorRecord author3 = persistenceService.findById(Integer.valueOf(100));
    	assertNotNull(author3);
    	System.out.println("Found : " + author3 );
		assertEquals(author2.getFirstName(), author3.getFirstName() ); 
		assertEquals(author2.getLastName(), author3.getLastName() ); 

    	//--- DELETE
    	System.out.println("Delete : " + author2 );
    	assertTrue( persistenceService.delete(author2) ); // Delete #1 : OK
    	assertFalse( persistenceService.delete(author2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById(Integer.valueOf(100)) ); // Nothing (already deleted)

		long finalCount = persistenceService.countAll() ;
    	System.out.println("Final count = " + finalCount );
		assertEquals(initialCount, finalCount);

    	assertFalse( persistenceService.exists(Integer.valueOf(100)) ) ;
    	assertFalse( persistenceService.exists(author2) ) ;
    	author2 = persistenceService.findById(Integer.valueOf(100));
    	assertNull( author2 );
    	
    	System.out.println("Normal end of persistence service test." );
	}
}
