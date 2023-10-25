package org.demo.persistence.impl.jpa;


import java.util.List;

import javax.inject.Named;

import org.demo.data.record.CountryRecord; // "Neutral Record" class 
import org.demo.persistence.CountryPersistence; // Persistence service interface
import org.demo.persistence.impl.jpa.commons.GenericJpaService;
import org.demo.persistence.impl.jpa.mapper.CountryJpaMapper ;
import org.demo.persistence.impl.jpa.record.CountryJpaRecord; // "JPA Record" class (with JPA mapping) 

/**
 * Country persistence service - JPA implementation 
 */
@Named("CountryPersistence")
public class CountryPersistenceJpa extends GenericJpaService<CountryJpaRecord, String> implements CountryPersistence {

	private final CountryJpaMapper mapper = new CountryJpaMapper();

	/**
	 * Constructor
	 */
	public CountryPersistenceJpa() {
		super(CountryJpaRecord.class);
	}

	@Override
	public CountryRecord findById( String code ) {
		CountryJpaRecord entity = super.find( code );
		return mapper.mapEntityToRecord(entity);	
	}

	@Override
	public List<CountryRecord> findAll() {
		List<CountryJpaRecord> entities = super.loadAll() ;
		List<CountryRecord> records = new java.util.LinkedList<CountryRecord>();
		for ( CountryJpaRecord entity : entities ) {
			records.add( mapper.mapEntityToRecord(entity) ) ;
		}
		return records ;
	}

	@Override
	public CountryRecord create(CountryRecord record) {
		CountryJpaRecord entity = mapper.mapRecordToEntity(record);
		super.persist(entity);
		return record ;
	}
	
	@Override
	public boolean update(CountryRecord record) {
		String pk = record.getCode() ;
		if ( super.find( pk ) != null ) {
			// Exists => 'merge' 
			CountryJpaRecord entity = mapper.mapRecordToEntity(record);
			super.merge(entity);
			return true ;
		}
		else {
			return false;
		}
	}

	@Override
	public CountryRecord save(CountryRecord record) {
		CountryJpaRecord entity = mapper.mapRecordToEntity(record);
		super.merge(entity);
		return record ;
	}

	@Override
	public boolean deleteById( String code ) {
		return super.remove( code );
	}

	@Override
	public boolean delete(CountryRecord record) {
		if ( record != null ) {
			return super.remove( record.getCode() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		Long count = (Long) super.execNamedQueryWithSingleResult( buildQueryName("countAll") ) ;
		return count.longValue();
	}

	public long countById(String code) {
		Long count = (Long) super.execNamedQueryWithSingleResult( buildQueryName("countById"), code ) ;
		return count.longValue();
	}
	
	@Override
	public boolean exists(String code) {
		long count = countById(code) ;
		return count > 0 ;
	}


	@Override
	public boolean exists(CountryRecord record) {
		if ( record != null ) {
			return exists( record.getCode() );
		}
		return false ;
	}

	@SuppressWarnings("unchecked")
	public List<CountryJpaRecord> queryExample() {
		List<?> list = super.execNamedQuery(buildQueryName("theNamedQueryToBeUsed")) ;
		return (List<CountryJpaRecord>) list ;
	}

}
