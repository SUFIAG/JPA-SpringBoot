package org.demo.persistence.impl.jpa;


import java.util.List;

import javax.inject.Named;

import org.demo.data.record.PublisherRecord; // "Neutral Record" class 
import org.demo.persistence.PublisherPersistence; // Persistence service interface
import org.demo.persistence.impl.jpa.commons.GenericJpaService;
import org.demo.persistence.impl.jpa.mapper.PublisherJpaMapper ;
import org.demo.persistence.impl.jpa.record.PublisherJpaRecord; // "JPA Record" class (with JPA mapping) 

/**
 * Publisher persistence service - JPA implementation 
 */
@Named("PublisherPersistence")
public class PublisherPersistenceJpa extends GenericJpaService<PublisherJpaRecord, Integer> implements PublisherPersistence {

	private final PublisherJpaMapper mapper = new PublisherJpaMapper();

	/**
	 * Constructor
	 */
	public PublisherPersistenceJpa() {
		super(PublisherJpaRecord.class);
	}

	@Override
	public PublisherRecord findById( Integer code ) {
		PublisherJpaRecord entity = super.find( code );
		return mapper.mapEntityToRecord(entity);	
	}

	@Override
	public List<PublisherRecord> findAll() {
		List<PublisherJpaRecord> entities = super.loadAll() ;
		List<PublisherRecord> records = new java.util.LinkedList<PublisherRecord>();
		for ( PublisherJpaRecord entity : entities ) {
			records.add( mapper.mapEntityToRecord(entity) ) ;
		}
		return records ;
	}

	@Override
	public PublisherRecord create(PublisherRecord record) {
		PublisherJpaRecord entity = mapper.mapRecordToEntity(record);
		super.persist(entity);
		return record ;
	}
	
	@Override
	public boolean update(PublisherRecord record) {
		Integer pk = record.getCode() ;
		if ( super.find( pk ) != null ) {
			// Exists => 'merge' 
			PublisherJpaRecord entity = mapper.mapRecordToEntity(record);
			super.merge(entity);
			return true ;
		}
		else {
			return false;
		}
	}

	@Override
	public PublisherRecord save(PublisherRecord record) {
		PublisherJpaRecord entity = mapper.mapRecordToEntity(record);
		super.merge(entity);
		return record ;
	}

	@Override
	public boolean deleteById( Integer code ) {
		return super.remove( code );
	}

	@Override
	public boolean delete(PublisherRecord record) {
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

	public long countById(Integer code) {
		Long count = (Long) super.execNamedQueryWithSingleResult( buildQueryName("countById"), code ) ;
		return count.longValue();
	}
	
	@Override
	public boolean exists(Integer code) {
		long count = countById(code) ;
		return count > 0 ;
	}


	@Override
	public boolean exists(PublisherRecord record) {
		if ( record != null ) {
			return exists( record.getCode() );
		}
		return false ;
	}

	@SuppressWarnings("unchecked")
	public List<PublisherJpaRecord> queryExample() {
		List<?> list = super.execNamedQuery(buildQueryName("theNamedQueryToBeUsed")) ;
		return (List<PublisherJpaRecord>) list ;
	}

}
