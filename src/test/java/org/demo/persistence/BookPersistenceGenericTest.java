package org.demo.persistence;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.demo.data.record.BookRecord ;
import org.demo.persistence.BookPersistence;

/**
 * Generic test class for a persistence service
 * 
 */
public class BookPersistenceGenericTest {

	/**
	 * Generic test for a persistence service
	 * @param persistenceService
	 * @throws SQLException
	 */
	public void testPersistenceService(BookPersistence persistenceService) {
    	System.out.println("--- test BookPersistence ");

    	BookRecord book = new BookRecord();
		//--- Key values
		book.setId(Integer.valueOf(100)); // "ID" : java.lang.Integer
		//--- Other values
		book.setPublisherId(Integer.valueOf(100)); // "PUBLISHER_ID" : java.lang.Integer
		book.setAuthorId(Integer.valueOf(100)); // "AUTHOR_ID" : java.lang.Integer
		book.setIsbn("AAAAAAAAAAAAA"); // "ISBN" : java.lang.String
		book.setTitle("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "TITLE" : java.lang.String
		book.setPrice(java.math.BigDecimal.valueOf(10000)); // "PRICE" : java.math.BigDecimal
		book.setQuantity(Integer.valueOf(100)); // "QUANTITY" : java.lang.Integer
		book.setDiscount(Integer.valueOf(100)); // "DISCOUNT" : java.lang.Integer
		book.setAvailability(Short.valueOf((short)1)); // "AVAILABILITY" : java.lang.Short
		book.setBestSeller(Short.valueOf((short)1)); // "BEST_SELLER" : java.lang.Short


    	//--- DELETE
    	System.out.println("Delete : " + book );
    	persistenceService.delete(book) ; // Just to be sure it doesn't exist before insert

		long initialCount = persistenceService.countAll() ;
    	System.out.println("Initial count = " + initialCount );

    	//--- CREATE
    	System.out.println("Create : " + book );

    	persistenceService.create(book);
    	assertTrue( persistenceService.exists(Integer.valueOf(100)) );
		assertTrue( persistenceService.exists(book) );
		long count = persistenceService.countAll() ;
    	System.out.println("Count = " + count );
		assertEquals(initialCount+1, count );

    	//--- FIND
    	System.out.println("Find by id..." );
    	BookRecord book2 = persistenceService.findById(Integer.valueOf(100));
    	System.out.println("Found : " + book2 );
    	assertNotNull(book2);
		assertTrue( book2.getId().equals(Integer.valueOf(100)) ) ;
    	assertTrue( persistenceService.exists(book2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		book2.setPublisherId(Integer.valueOf(200)); // "PUBLISHER_ID" : java.lang.Integer
		book2.setAuthorId(Integer.valueOf(200)); // "AUTHOR_ID" : java.lang.Integer
		book2.setIsbn("BBBBBBBBBBBBB"); // "ISBN" : java.lang.String
		book2.setTitle("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "TITLE" : java.lang.String
		book2.setPrice(java.math.BigDecimal.valueOf(20000)); // "PRICE" : java.math.BigDecimal
		book2.setQuantity(Integer.valueOf(200)); // "QUANTITY" : java.lang.Integer
		book2.setDiscount(Integer.valueOf(200)); // "DISCOUNT" : java.lang.Integer
		book2.setAvailability(Short.valueOf((short)2)); // "AVAILABILITY" : java.lang.Short
		book2.setBestSeller(Short.valueOf((short)2)); // "BEST_SELLER" : java.lang.Short
    	System.out.println("Update : " + book2 );
    	assertTrue( persistenceService.update(book2) );
    	
    	//--- RELOAD AFTER UPDATE
    	System.out.println("Find by id..." );
    	BookRecord book3 = persistenceService.findById(Integer.valueOf(100));
    	assertNotNull(book3);
    	System.out.println("Found : " + book3 );
		assertEquals(book2.getPublisherId(), book3.getPublisherId() ); 
		assertEquals(book2.getAuthorId(), book3.getAuthorId() ); 
		assertEquals(book2.getIsbn(), book3.getIsbn() ); 
		assertEquals(book2.getTitle(), book3.getTitle() ); 
		assertEquals(book2.getPrice(), new BigDecimal(book3.getPrice().intValue() )); 
		assertEquals(book2.getQuantity(), book3.getQuantity() ); 
		assertEquals(book2.getDiscount(), book3.getDiscount() ); 
		assertEquals(book2.getAvailability(), book3.getAvailability() ); 
		assertEquals(book2.getBestSeller(), book3.getBestSeller() ); 

    	//--- DELETE
    	System.out.println("Delete : " + book2 );
    	assertTrue( persistenceService.delete(book2) ); // Delete #1 : OK
    	assertFalse( persistenceService.delete(book2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById(Integer.valueOf(100)) ); // Nothing (already deleted)

		long finalCount = persistenceService.countAll() ;
    	System.out.println("Final count = " + finalCount );
		assertEquals(initialCount, finalCount);

    	assertFalse( persistenceService.exists(Integer.valueOf(100)) ) ;
    	assertFalse( persistenceService.exists(book2) ) ;
    	book2 = persistenceService.findById(Integer.valueOf(100));
    	assertNull( book2 );
    	
    	System.out.println("Normal end of persistence service test." );
	}
}
