package org.demo.persistence;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.demo.data.record.BookOrderRecord ;
import org.demo.persistence.BookOrderPersistence;

/**
 * Generic test class for a persistence service
 * 
 */
public class BookOrderPersistenceGenericTest {

	/**
	 * Generic test for a persistence service
	 * @param persistenceService
	 * @throws SQLException
	 */
	public void testPersistenceService(BookOrderPersistence persistenceService) {
    	System.out.println("--- test BookOrderPersistence ");

    	BookOrderRecord bookOrder = new BookOrderRecord();
		//--- Key values
		bookOrder.setId(Integer.valueOf(100)); // "ID" : java.lang.Integer
		//--- Other values
		bookOrder.setShopCode("AAA"); // "SHOP_CODE" : java.lang.String
		bookOrder.setCustomerCode("AAAAA"); // "CUSTOMER_CODE" : java.lang.String
		bookOrder.setEmployeeCode("AAAA"); // "EMPLOYEE_CODE" : java.lang.String
		bookOrder.setDate(java.sql.Date.valueOf("2001-06-22")); // "DATE" : java.util.Date
		bookOrder.setState(Integer.valueOf(100)); // "STATE" : java.lang.Integer


    	//--- DELETE
    	System.out.println("Delete : " + bookOrder );
    	persistenceService.delete(bookOrder) ; // Just to be sure it doesn't exist before insert

		long initialCount = persistenceService.countAll() ;
    	System.out.println("Initial count = " + initialCount );

    	//--- CREATE
    	System.out.println("Create : " + bookOrder );

    	persistenceService.create(bookOrder);
    	assertTrue( persistenceService.exists(Integer.valueOf(100)) );
		assertTrue( persistenceService.exists(bookOrder) );
		long count = persistenceService.countAll() ;
    	System.out.println("Count = " + count );
		assertEquals(initialCount+1, count );

    	//--- FIND
    	System.out.println("Find by id..." );
    	BookOrderRecord bookOrder2 = persistenceService.findById(Integer.valueOf(100));
    	System.out.println("Found : " + bookOrder2 );
    	assertNotNull(bookOrder2);
		assertTrue( bookOrder2.getId().equals(Integer.valueOf(100)) ) ;
    	assertTrue( persistenceService.exists(bookOrder2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		bookOrder2.setShopCode("BBB"); // "SHOP_CODE" : java.lang.String
		bookOrder2.setCustomerCode("BBBBB"); // "CUSTOMER_CODE" : java.lang.String
		bookOrder2.setEmployeeCode("BBBB"); // "EMPLOYEE_CODE" : java.lang.String
		bookOrder2.setDate(java.sql.Date.valueOf("2002-06-22")); // "DATE" : java.util.Date
		bookOrder2.setState(Integer.valueOf(200)); // "STATE" : java.lang.Integer
    	System.out.println("Update : " + bookOrder2 );
    	assertTrue( persistenceService.update(bookOrder2) );
    	
    	//--- RELOAD AFTER UPDATE
    	System.out.println("Find by id..." );
    	BookOrderRecord bookOrder3 = persistenceService.findById(Integer.valueOf(100));
    	assertNotNull(bookOrder3);
    	System.out.println("Found : " + bookOrder3 );
		assertEquals(bookOrder2.getShopCode(), bookOrder3.getShopCode() ); 
		assertEquals(bookOrder2.getCustomerCode(), bookOrder3.getCustomerCode() ); 
		assertEquals(bookOrder2.getEmployeeCode(), bookOrder3.getEmployeeCode() ); 
		assertEquals(bookOrder2.getDate(), bookOrder3.getDate() ); 
		assertEquals(bookOrder2.getState(), bookOrder3.getState() ); 

    	//--- DELETE
    	System.out.println("Delete : " + bookOrder2 );
    	assertTrue( persistenceService.delete(bookOrder2) ); // Delete #1 : OK
    	assertFalse( persistenceService.delete(bookOrder2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById(Integer.valueOf(100)) ); // Nothing (already deleted)

		long finalCount = persistenceService.countAll() ;
    	System.out.println("Final count = " + finalCount );
		assertEquals(initialCount, finalCount);

    	assertFalse( persistenceService.exists(Integer.valueOf(100)) ) ;
    	assertFalse( persistenceService.exists(bookOrder2) ) ;
    	bookOrder2 = persistenceService.findById(Integer.valueOf(100));
    	assertNull( bookOrder2 );
    	
    	System.out.println("Normal end of persistence service test." );
	}
}
