package org.demo.persistence;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.demo.data.record.ShopRecord ;
import org.demo.persistence.ShopPersistence;

/**
 * Generic test class for a persistence service
 *
 */
public class ShopPersistenceGenericTest {

	/**
	 * Generic test for a persistence service
	 * @param persistenceService
	 * @throws SQLException
	 */
	public void testPersistenceService(ShopPersistence persistenceService) {
    	System.out.println("--- test ShopPersistence ");

    	ShopRecord shop = new ShopRecord();
		//--- Key values
		shop.setCode("AAA"); // "CODE" : java.lang.String
		//--- Other values
		shop.setName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "NAME" : java.lang.String
		shop.setAddress1("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "ADDRESS_1" : java.lang.String
		shop.setAddress2("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "ADDRESS_2" : java.lang.String
		shop.setZipCode(Integer.valueOf(100)); // "ZIP_CODE" : java.lang.Integer
		shop.setCity("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "CITY" : java.lang.String
		shop.setCountryCode("AA"); // "COUNTRY_CODE" : java.lang.String
		shop.setPhone("AAAAAAAAAAAAAA"); // "PHONE" : java.lang.String
		shop.setEmail("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "EMAIL" : java.lang.String
		shop.setExecutive("AAAA"); // "EXECUTIVE" : java.lang.String


    	//--- DELETE
    	System.out.println("Delete : " + shop );
    	persistenceService.delete(shop) ; // Just to be sure it doesn't exist before insert

		long initialCount = persistenceService.countAll() ;
    	System.out.println("Initial count = " + initialCount );

    	//--- CREATE
    	System.out.println("Create : " + shop );

    	persistenceService.create(shop);
    	assertTrue( persistenceService.exists("AAA") );
		assertTrue( persistenceService.exists(shop) );
		long count = persistenceService.countAll() ;
    	System.out.println("Count = " + count );
		assertEquals(initialCount+1, count );

    	//--- FIND
    	System.out.println("Find by id..." );
    	ShopRecord shop2 = persistenceService.findById("AAA");
    	System.out.println("Found : " + shop2 );
    	assertNotNull(shop2);
		assertTrue( shop2.getCode().equals("AAA") ) ;
    	assertTrue( persistenceService.exists(shop2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		shop2.setName("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "NAME" : java.lang.String
		shop2.setAddress1("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "ADDRESS_1" : java.lang.String
		shop2.setAddress2("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "ADDRESS_2" : java.lang.String
		shop2.setZipCode(Integer.valueOf(200)); // "ZIP_CODE" : java.lang.Integer
		shop2.setCity("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "CITY" : java.lang.String
		shop2.setCountryCode("BB"); // "COUNTRY_CODE" : java.lang.String
		shop2.setPhone("BBBBBBBBBBBBBB"); // "PHONE" : java.lang.String
		shop2.setEmail("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "EMAIL" : java.lang.String
		shop2.setExecutive("BBBB"); // "EXECUTIVE" : java.lang.String
    	System.out.println("Update : " + shop2 );
    	assertTrue( persistenceService.update(shop2) );
    	
    	//--- RELOAD AFTER UPDATE
    	System.out.println("Find by id..." );
    	ShopRecord shop3 = persistenceService.findById("AAA");
    	assertNotNull(shop3);
    	System.out.println("Found : " + shop3 );
		assertEquals(shop2.getName(), shop3.getName() ); 
		assertEquals(shop2.getAddress1(), shop3.getAddress1() ); 
		assertEquals(shop2.getAddress2(), shop3.getAddress2() ); 
		assertEquals(shop2.getZipCode(), shop3.getZipCode() ); 
		assertEquals(shop2.getCity(), shop3.getCity() ); 
		assertEquals(shop2.getCountryCode(), shop3.getCountryCode() ); 
		assertEquals(shop2.getPhone(), shop3.getPhone() ); 
		assertEquals(shop2.getEmail(), shop3.getEmail() ); 
		assertEquals(shop2.getExecutive(), shop3.getExecutive() ); 

    	//--- DELETE
    	System.out.println("Delete : " + shop2 );
    	assertTrue( persistenceService.delete(shop2) ); // Delete #1 : OK
    	assertFalse( persistenceService.delete(shop2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById("AAA") ); // Nothing (already deleted)

		long finalCount = persistenceService.countAll() ;
    	System.out.println("Final count = " + finalCount );
		assertEquals(initialCount, finalCount);

    	assertFalse( persistenceService.exists("AAA") ) ;
    	assertFalse( persistenceService.exists(shop2) ) ;
    	shop2 = persistenceService.findById("AAA");
    	assertNull( shop2 );
    	
    	System.out.println("Normal end of persistence service test." );
	}
}
