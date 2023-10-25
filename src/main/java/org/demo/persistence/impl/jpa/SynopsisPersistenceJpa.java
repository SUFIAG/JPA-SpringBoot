package org.demo.persistence.impl.jpa;


import java.util.List;

import javax.inject.Named;

import org.demo.data.record.SynopsisRecord; // "Neutral Record" class 
import org.demo.persistence.SynopsisPersistence; // Persistence service interface
import org.demo.persistence.impl.jpa.commons.GenericJpaService;
import org.demo.persistence.impl.jpa.mapper.SynopsisJpaMapper ;
import org.demo.persistence.impl.jpa.record.SynopsisJpaRecord; // "JPA Record" class (with JPA mapping) 

/**
 * Synopsis persistence service - JPA implementation 
 */
@Named("SynopsisPersistence")
public class SynopsisPersistenceJpa extends GenericJpaService<SynopsisJpaRecord, Integer> implements SynopsisPersistence {

	private final SynopsisJpaMapper mapper = new SynopsisJpaMapper();

	/**
	 * Constructor
	 */
	public SynopsisPersistenceJpa() {
		super(SynopsisJpaRecord.class);
	}

	@Override
	public SynopsisRecord findById( Integer bookId ) {
		SynopsisJpaRecord entity = super.find( bookId );
		return mapper.mapEntityToRecord(entity);	
	}

	@Override
	public List<SynopsisRecord> findAll() {
		List<SynopsisJpaRecord> entities = super.loadAll() ;
		List<SynopsisRecord> records = new java.util.LinkedList<SynopsisRecord>();
		for ( SynopsisJpaRecord entity : entities ) {
			records.add( mapper.mapEntityToRecord(entity) ) ;
		}
		return records ;
	}

	@Override
	public SynopsisRecord create(SynopsisRecord record) {
		SynopsisJpaRecord entity = mapper.mapRecordToEntity(record);
		super.persist(entity);
		return record ;
	}
	
	@Override
	public boolean update(SynopsisRecord record) {
		Integer pk = record.getBookId() ;
		if ( super.find( pk ) != null ) {
			// Exists => 'merge' 
			SynopsisJpaRecord entity = mapper.mapRecordToEntity(record);
			super.merge(entity);
			return true ;
		}
		else {
			return false;
		}
	}

	@Override
	public SynopsisRecord save(SynopsisRecord record) {
		SynopsisJpaRecord entity = mapper.mapRecordToEntity(record);
		super.merge(entity);
		return record ;
	}

	@Override
	public boolean deleteById( Integer bookId ) {
		return super.remove( bookId );
	}

	@Override
	public boolean delete(SynopsisRecord record) {
		if ( record != null ) {
			return super.remove( record.getBookId() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		Long count = (Long) super.execNamedQueryWithSingleResult( buildQueryName("countAll") ) ;
		return count.longValue();
	}

	public long countById(Integer bookId) {
		Long count = (Long) super.execNamedQueryWithSingleResult( buildQueryName("countById"), bookId ) ;
		return count.longValue();
	}
	
	@Override
	public boolean exists(Integer bookId) {
		long count = countById(bookId) ;
		return count > 0 ;
	}


	@Override
	public boolean exists(SynopsisRecord record) {
		if ( record != null ) {
			return exists( record.getBookId() );
		}
		return false ;
	}

	@SuppressWarnings("unchecked")
	public List<SynopsisJpaRecord> queryExample() {
		List<?> list = super.execNamedQuery(buildQueryName("theNamedQueryToBeUsed")) ;
		return (List<SynopsisJpaRecord>) list ;
	}

}
