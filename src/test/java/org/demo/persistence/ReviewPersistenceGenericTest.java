package org.demo.persistence;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.demo.data.record.ReviewRecord ;
import org.demo.persistence.ReviewPersistence;

/**
 * Generic test class for a persistence service
 */
public class ReviewPersistenceGenericTest {

	/**
	 * Generic test for a persistence service
	 * @param persistenceService
	 * @throws SQLException
	 */
	public void testPersistenceService(ReviewPersistence persistenceService) {
    	System.out.println("--- test ReviewPersistence ");

    	ReviewRecord review = new ReviewRecord();
		//--- Key values
		review.setCustomerCode("AAAAA"); // "CUSTOMER_CODE" : java.lang.String
		review.setBookId(Integer.valueOf(100)); // "BOOK_ID" : java.lang.Integer
		//--- Other values
		review.setReviewText("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "REVIEW_TEXT" : java.lang.String
		review.setReviewNote(Integer.valueOf(100)); // "REVIEW_NOTE" : java.lang.Integer
		review.setCreation(java.sql.Timestamp.valueOf("2001-05-21 01:46:52")); // "CREATION" : java.util.Date
		review.setLastUpdate(java.sql.Timestamp.valueOf("2001-05-21 01:46:52")); // "LAST_UPDATE" : java.util.Date


    	//--- DELETE
    	System.out.println("Delete : " + review );
    	persistenceService.delete(review) ; // Just to be sure it doesn't exist before insert

		long initialCount = persistenceService.countAll() ;
    	System.out.println("Initial count = " + initialCount );

    	//--- CREATE
    	System.out.println("Create : " + review );

    	persistenceService.create(review);
    	assertTrue( persistenceService.exists("AAAAA", Integer.valueOf(100)) );
		assertTrue( persistenceService.exists(review) );
		long count = persistenceService.countAll() ;
    	System.out.println("Count = " + count );
		assertEquals(initialCount+1, count );

    	//--- FIND
    	System.out.println("Find by id..." );
    	ReviewRecord review2 = persistenceService.findById("AAAAA", Integer.valueOf(100));
    	System.out.println("Found : " + review2 );
    	assertNotNull(review2);
		assertTrue( review2.getCustomerCode().equals("AAAAA") ) ;
		assertTrue( review2.getBookId().equals(Integer.valueOf(100)) ) ;
    	assertTrue( persistenceService.exists(review2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		review2.setReviewText("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "REVIEW_TEXT" : java.lang.String
		review2.setReviewNote(Integer.valueOf(200)); // "REVIEW_NOTE" : java.lang.Integer
		review2.setCreation(java.sql.Timestamp.valueOf("2002-05-21 02:46:52")); // "CREATION" : java.util.Date
		review2.setLastUpdate(java.sql.Timestamp.valueOf("2002-05-21 02:46:52")); // "LAST_UPDATE" : java.util.Date
    	System.out.println("Update : " + review2 );
    	assertTrue( persistenceService.update(review2) );
    	
    	//--- RELOAD AFTER UPDATE
    	System.out.println("Find by id..." );
    	ReviewRecord review3 = persistenceService.findById("AAAAA", Integer.valueOf(100));
    	assertNotNull(review3);
    	System.out.println("Found : " + review3 );
		assertEquals(review2.getReviewText(), review3.getReviewText() ); 
		assertEquals(review2.getReviewNote(), review3.getReviewNote() ); 
		assertEquals(review2.getCreation(), review3.getCreation() ); 
		assertEquals(review2.getLastUpdate(), review3.getLastUpdate() ); 

    	//--- DELETE
    	System.out.println("Delete : " + review2 );
    	assertTrue( persistenceService.delete(review2) ); // Delete #1 : OK
    	assertFalse( persistenceService.delete(review2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById("AAAAA", Integer.valueOf(100)) ); // Nothing (already deleted)

		long finalCount = persistenceService.countAll() ;
    	System.out.println("Final count = " + finalCount );
		assertEquals(initialCount, finalCount);

    	assertFalse( persistenceService.exists("AAAAA", Integer.valueOf(100)) ) ;
    	assertFalse( persistenceService.exists(review2) ) ;
    	review2 = persistenceService.findById("AAAAA", Integer.valueOf(100));
    	assertNull( review2 );
    	
    	System.out.println("Normal end of persistence service test." );
	}
}
