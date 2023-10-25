package org.demo.persistence.impl.jpa.commons;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JpaPersistenceConfig {

	private final static String  PROPERTIES_FILE_NAME  = "/META-INF/persistence.properties";
	private final static String  PERSISTENCE_UNIT_NAME = "persistenceUnitName";
	
	private final Properties properties          = new Properties();
	private final String     persistenceUnitName ;
	
	public JpaPersistenceConfig() {
		InputStream stream = this.getClass().getResourceAsStream(PROPERTIES_FILE_NAME) ;
		if ( stream == null ) {
			throw new RuntimeException("Cannot found propertie file " + PROPERTIES_FILE_NAME );
		}
		try {
		    properties.load(stream);
		}
		catch ( IOException e ) {
			throw new RuntimeException("IOException : Cannot load propertie from file " + PROPERTIES_FILE_NAME );
		}
		finally {
			try {
				stream.close();
			} catch (IOException e) {
				throw new RuntimeException("IOException : Cannot close file stream " + PROPERTIES_FILE_NAME );
			}
		}
		
		//--- Persistence Unit Name 
		persistenceUnitName = properties.getProperty(PERSISTENCE_UNIT_NAME);
		if ( persistenceUnitName == null ) {
			throw new RuntimeException("Property '" + PERSISTENCE_UNIT_NAME + "' not found in file '" + PROPERTIES_FILE_NAME + "'");
		}
	}
	
	public String getPersistenceUnitName() {
		return persistenceUnitName ;
	}
	
}
