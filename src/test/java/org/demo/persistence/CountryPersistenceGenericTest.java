package org.demo.persistence;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.demo.data.record.CountryRecord ;
import org.demo.persistence.CountryPersistence;

/**
 * Generic test class for a persistence service
 * 
 */
public class CountryPersistenceGenericTest {

	/**
	 * Generic test for a persistence service
	 * @param persistenceService
	 * @throws SQLException
	 */
	public void testPersistenceService(CountryPersistence persistenceService) {
    	System.out.println("--- test CountryPersistence ");

    	CountryRecord country = new CountryRecord();
		//--- Key values
		country.setCode("AA"); // "CODE" : java.lang.String
		//--- Other values
		country.setName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "NAME" : java.lang.String


    	//--- DELETE
    	System.out.println("Delete : " + country );
    	persistenceService.delete(country) ; // Just to be sure it doesn't exist before insert

		long initialCount = persistenceService.countAll() ;
    	System.out.println("Initial count = " + initialCount );

    	//--- CREATE
    	System.out.println("Create : " + country );

    	persistenceService.create(country);
    	assertTrue( persistenceService.exists("AA") );
		assertTrue( persistenceService.exists(country) );
		long count = persistenceService.countAll() ;
    	System.out.println("Count = " + count );
		assertEquals(initialCount+1, count );

    	//--- FIND
    	System.out.println("Find by id..." );
    	CountryRecord country2 = persistenceService.findById("AA");
    	System.out.println("Found : " + country2 );
    	assertNotNull(country2);
		assertTrue( country2.getCode().equals("AA") ) ;
    	assertTrue( persistenceService.exists(country2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		country2.setName("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "NAME" : java.lang.String
    	System.out.println("Update : " + country2 );
    	assertTrue( persistenceService.update(country2) );
    	
    	//--- RELOAD AFTER UPDATE
    	System.out.println("Find by id..." );
    	CountryRecord country3 = persistenceService.findById("AA");
    	assertNotNull(country3);
    	System.out.println("Found : " + country3 );
		assertEquals(country2.getName(), country3.getName() ); 

    	//--- DELETE
    	System.out.println("Delete : " + country2 );
    	assertTrue( persistenceService.delete(country2) ); // Delete #1 : OK
    	assertFalse( persistenceService.delete(country2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById("AA") ); // Nothing (already deleted)

		long finalCount = persistenceService.countAll() ;
    	System.out.println("Final count = " + finalCount );
		assertEquals(initialCount, finalCount);

    	assertFalse( persistenceService.exists("AA") ) ;
    	assertFalse( persistenceService.exists(country2) ) ;
    	country2 = persistenceService.findById("AA");
    	assertNull( country2 );
    	
    	System.out.println("Normal end of persistence service test." );
	}
}
