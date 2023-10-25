package org.demo.persistence;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.demo.data.record.BookOrderItemRecord ;
import org.demo.persistence.BookOrderItemPersistence;

/**
 * Generic test class for a persistence service
 * 
 */
public class BookOrderItemPersistenceGenericTest {

	/**
	 * Generic test for a persistence service
	 * @param persistenceService
	 * @throws SQLException
	 */
	public void testPersistenceService(BookOrderItemPersistence persistenceService) {
    	System.out.println("--- test BookOrderItemPersistence ");

    	BookOrderItemRecord bookOrderItem = new BookOrderItemRecord();
		//--- Key values
		bookOrderItem.setBookOrderId(Integer.valueOf(100)); // "BOOK_ORDER_ID" : java.lang.Integer
		bookOrderItem.setBookId(Integer.valueOf(100)); // "BOOK_ID" : java.lang.Integer
		//--- Other values
		bookOrderItem.setQuantity(Integer.valueOf(100)); // "QUANTITY" : java.lang.Integer
		bookOrderItem.setPrice(java.math.BigDecimal.valueOf(10000)); // "PRICE" : java.math.BigDecimal


    	//--- DELETE
    	System.out.println("Delete : " + bookOrderItem );
    	persistenceService.delete(bookOrderItem) ; // Just to be sure it doesn't exist before insert

		long initialCount = persistenceService.countAll() ;
    	System.out.println("Initial count = " + initialCount );

    	//--- CREATE
    	System.out.println("Create : " + bookOrderItem );

    	persistenceService.create(bookOrderItem);
    	assertTrue( persistenceService.exists(Integer.valueOf(100), Integer.valueOf(100)) );
		assertTrue( persistenceService.exists(bookOrderItem) );
		long count = persistenceService.countAll() ;
    	System.out.println("Count = " + count );
		assertEquals(initialCount+1, count );

    	//--- FIND
    	System.out.println("Find by id..." );
    	BookOrderItemRecord bookOrderItem2 = persistenceService.findById(Integer.valueOf(100), Integer.valueOf(100));
    	System.out.println("Found : " + bookOrderItem2 );
    	assertNotNull(bookOrderItem2);
		assertTrue( bookOrderItem2.getBookOrderId().equals(Integer.valueOf(100)) ) ;
		assertTrue( bookOrderItem2.getBookId().equals(Integer.valueOf(100)) ) ;
    	assertTrue( persistenceService.exists(bookOrderItem2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		bookOrderItem2.setQuantity(Integer.valueOf(200)); // "QUANTITY" : java.lang.Integer
		bookOrderItem2.setPrice(java.math.BigDecimal.valueOf(20000)); // "PRICE" : java.math.BigDecimal
    	System.out.println("Update : " + bookOrderItem2 );
    	assertTrue( persistenceService.update(bookOrderItem2) );
    	
    	//--- RELOAD AFTER UPDATE
    	System.out.println("Find by id..." );
    	BookOrderItemRecord bookOrderItem3 = persistenceService.findById(Integer.valueOf(100), Integer.valueOf(100));
    	assertNotNull(bookOrderItem3);
    	System.out.println("Found : " + bookOrderItem3 );
		assertEquals(bookOrderItem2.getQuantity(), bookOrderItem3.getQuantity() ); 
		assertEquals(bookOrderItem2.getPrice(), new BigDecimal(bookOrderItem3.getPrice().intValue()) ); 

    	//--- DELETE
    	System.out.println("Delete : " + bookOrderItem2 );
    	assertTrue( persistenceService.delete(bookOrderItem2) ); // Delete #1 : OK
    	assertFalse( persistenceService.delete(bookOrderItem2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById(Integer.valueOf(100), Integer.valueOf(100)) ); // Nothing (already deleted)

		long finalCount = persistenceService.countAll() ;
    	System.out.println("Final count = " + finalCount );
		assertEquals(initialCount, finalCount);

    	assertFalse( persistenceService.exists(Integer.valueOf(100), Integer.valueOf(100)) ) ;
    	assertFalse( persistenceService.exists(bookOrderItem2) ) ;
    	bookOrderItem2 = persistenceService.findById(Integer.valueOf(100), Integer.valueOf(100));
    	assertNull( bookOrderItem2 );
    	
    	System.out.println("Normal end of persistence service test." );
	}
}
