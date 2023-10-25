package org.demo.persistence;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.demo.data.record.SynopsisRecord ;
import org.demo.persistence.SynopsisPersistence;

/**
 * Generic test class for a persistence service
 *
 */
public class SynopsisPersistenceGenericTest {

	/**
	 * Generic test for a persistence service
	 * @param persistenceService
	 * @throws SQLException
	 */
	public void testPersistenceService(SynopsisPersistence persistenceService) {
    	System.out.println("--- test SynopsisPersistence ");

    	SynopsisRecord synopsis = new SynopsisRecord();
		//--- Key values
		synopsis.setBookId(Integer.valueOf(100)); // "BOOK_ID" : java.lang.Integer
		//--- Other values
		synopsis.setSynopsis("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "SYNOPSIS" : java.lang.String


    	//--- DELETE
    	System.out.println("Delete : " + synopsis );
    	persistenceService.delete(synopsis) ; // Just to be sure it doesn't exist before insert

		long initialCount = persistenceService.countAll() ;
    	System.out.println("Initial count = " + initialCount );

    	//--- CREATE
    	System.out.println("Create : " + synopsis );

    	persistenceService.create(synopsis);
    	assertTrue( persistenceService.exists(Integer.valueOf(100)) );
		assertTrue( persistenceService.exists(synopsis) );
		long count = persistenceService.countAll() ;
    	System.out.println("Count = " + count );
		assertEquals(initialCount+1, count );

    	//--- FIND
    	System.out.println("Find by id..." );
    	SynopsisRecord synopsis2 = persistenceService.findById(Integer.valueOf(100));
    	System.out.println("Found : " + synopsis2 );
    	assertNotNull(synopsis2);
		assertTrue( synopsis2.getBookId().equals(Integer.valueOf(100)) ) ;
    	assertTrue( persistenceService.exists(synopsis2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		synopsis2.setSynopsis("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "SYNOPSIS" : java.lang.String
    	System.out.println("Update : " + synopsis2 );
    	assertTrue( persistenceService.update(synopsis2) );
    	
    	//--- RELOAD AFTER UPDATE
    	System.out.println("Find by id..." );
    	SynopsisRecord synopsis3 = persistenceService.findById(Integer.valueOf(100));
    	assertNotNull(synopsis3);
    	System.out.println("Found : " + synopsis3 );
		assertEquals(synopsis2.getSynopsis(), synopsis3.getSynopsis() ); 

    	//--- DELETE
    	System.out.println("Delete : " + synopsis2 );
    	assertTrue( persistenceService.delete(synopsis2) ); // Delete #1 : OK
    	assertFalse( persistenceService.delete(synopsis2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById(Integer.valueOf(100)) ); // Nothing (already deleted)

		long finalCount = persistenceService.countAll() ;
    	System.out.println("Final count = " + finalCount );
		assertEquals(initialCount, finalCount);

    	assertFalse( persistenceService.exists(Integer.valueOf(100)) ) ;
    	assertFalse( persistenceService.exists(synopsis2) ) ;
    	synopsis2 = persistenceService.findById(Integer.valueOf(100));
    	assertNull( synopsis2 );
    	
    	System.out.println("Normal end of persistence service test." );
	}
}
