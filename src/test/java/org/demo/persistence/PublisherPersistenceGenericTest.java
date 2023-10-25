package org.demo.persistence;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.demo.data.record.PublisherRecord ;
import org.demo.persistence.PublisherPersistence;

/**
 * Generic test class for a persistence service
 * 
 */
public class PublisherPersistenceGenericTest {

	/**
	 * Generic test for a persistence service
	 * @param persistenceService
	 * @throws SQLException
	 */
	public void testPersistenceService(PublisherPersistence persistenceService) {
    	System.out.println("--- test PublisherPersistence ");

    	PublisherRecord publisher = new PublisherRecord();
		//--- Key values
		publisher.setCode(Integer.valueOf(100)); // "CODE" : java.lang.Integer
		//--- Other values
		publisher.setCountryCode("AA"); // "COUNTRY_CODE" : java.lang.String
		publisher.setName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "NAME" : java.lang.String
		publisher.setEmail("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "EMAIL" : java.lang.String
		publisher.setContact("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "CONTACT" : java.lang.String
		publisher.setCity("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "CITY" : java.lang.String
		publisher.setZipCode(Integer.valueOf(100)); // "ZIP_CODE" : java.lang.Integer
		publisher.setPhone("AAAAAAAAAAAAAA"); // "PHONE" : java.lang.String


    	//--- DELETE
    	System.out.println("Delete : " + publisher );
    	persistenceService.delete(publisher) ; // Just to be sure it doesn't exist before insert

		long initialCount = persistenceService.countAll() ;
    	System.out.println("Initial count = " + initialCount );

    	//--- CREATE
    	System.out.println("Create : " + publisher );

    	persistenceService.create(publisher);
    	assertTrue( persistenceService.exists(Integer.valueOf(100)) );
		assertTrue( persistenceService.exists(publisher) );
		long count = persistenceService.countAll() ;
    	System.out.println("Count = " + count );
		assertEquals(initialCount+1, count );

    	//--- FIND
    	System.out.println("Find by id..." );
    	PublisherRecord publisher2 = persistenceService.findById(Integer.valueOf(100));
    	System.out.println("Found : " + publisher2 );
    	assertNotNull(publisher2);
		assertTrue( publisher2.getCode().equals(Integer.valueOf(100)) ) ;
    	assertTrue( persistenceService.exists(publisher2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		publisher2.setCountryCode("BB"); // "COUNTRY_CODE" : java.lang.String
		publisher2.setName("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "NAME" : java.lang.String
		publisher2.setEmail("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "EMAIL" : java.lang.String
		publisher2.setContact("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "CONTACT" : java.lang.String
		publisher2.setCity("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "CITY" : java.lang.String
		publisher2.setZipCode(Integer.valueOf(200)); // "ZIP_CODE" : java.lang.Integer
		publisher2.setPhone("BBBBBBBBBBBBBB"); // "PHONE" : java.lang.String
    	System.out.println("Update : " + publisher2 );
    	assertTrue( persistenceService.update(publisher2) );
    	
    	//--- RELOAD AFTER UPDATE
    	System.out.println("Find by id..." );
    	PublisherRecord publisher3 = persistenceService.findById(Integer.valueOf(100));
    	assertNotNull(publisher3);
    	System.out.println("Found : " + publisher3 );
		assertEquals(publisher2.getCountryCode(), publisher3.getCountryCode() ); 
		assertEquals(publisher2.getName(), publisher3.getName() ); 
		assertEquals(publisher2.getEmail(), publisher3.getEmail() ); 
		assertEquals(publisher2.getContact(), publisher3.getContact() ); 
		assertEquals(publisher2.getCity(), publisher3.getCity() ); 
		assertEquals(publisher2.getZipCode(), publisher3.getZipCode() ); 
		assertEquals(publisher2.getPhone(), publisher3.getPhone() ); 

    	//--- DELETE
    	System.out.println("Delete : " + publisher2 );
    	assertTrue( persistenceService.delete(publisher2) ); // Delete #1 : OK
    	assertFalse( persistenceService.delete(publisher2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById(Integer.valueOf(100)) ); // Nothing (already deleted)

		long finalCount = persistenceService.countAll() ;
    	System.out.println("Final count = " + finalCount );
		assertEquals(initialCount, finalCount);

    	assertFalse( persistenceService.exists(Integer.valueOf(100)) ) ;
    	assertFalse( persistenceService.exists(publisher2) ) ;
    	publisher2 = persistenceService.findById(Integer.valueOf(100));
    	assertNull( publisher2 );
    	
    	System.out.println("Normal end of persistence service test." );
	}
}
