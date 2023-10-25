package org.demo.persistence.impl.jpa;


import java.util.List;

import javax.inject.Named;

import org.demo.data.record.AuthorRecord; // "Neutral Record" class 
import org.demo.persistence.AuthorPersistence; // Persistence service interface
import org.demo.persistence.impl.jpa.commons.GenericJpaService;
import org.demo.persistence.impl.jpa.mapper.AuthorJpaMapper ;
import org.demo.persistence.impl.jpa.record.AuthorJpaRecord; // "JPA Record" class (with JPA mapping) 

/**
 * Author persistence service - JPA implementation 
 */
@Named("AuthorPersistence")
public class AuthorPersistenceJpa extends GenericJpaService<AuthorJpaRecord, Integer> implements AuthorPersistence {

	private final AuthorJpaMapper mapper = new AuthorJpaMapper();

	/**
	 * Constructor
	 */
	public AuthorPersistenceJpa() {
		super(AuthorJpaRecord.class);
	}

	@Override
	public AuthorRecord findById( Integer id ) {
		AuthorJpaRecord entity = super.find( id );
		return mapper.mapEntityToRecord(entity);	
	}

	@Override
	public List<AuthorRecord> findAll() {
		List<AuthorJpaRecord> entities = super.loadAll() ;
		List<AuthorRecord> records = new java.util.LinkedList<AuthorRecord>();
		for ( AuthorJpaRecord entity : entities ) {
			records.add( mapper.mapEntityToRecord(entity) ) ;
		}
		return records ;
	}

	@Override
	public AuthorRecord create(AuthorRecord record) {
		AuthorJpaRecord entity = mapper.mapRecordToEntity(record);
		super.persist(entity);
		return record ;
	}
	
	@Override
	public boolean update(AuthorRecord record) {
		Integer pk = record.getId() ;
		if ( super.find( pk ) != null ) {
			// Exists => 'merge' 
			AuthorJpaRecord entity = mapper.mapRecordToEntity(record);
			super.merge(entity);
			return true ;
		}
		else {
			return false;
		}
	}

	@Override
	public AuthorRecord save(AuthorRecord record) {
		AuthorJpaRecord entity = mapper.mapRecordToEntity(record);
		super.merge(entity);
		return record ;
	}

	@Override
	public boolean deleteById( Integer id ) {
		return super.remove( id );
	}

	@Override
	public boolean delete(AuthorRecord record) {
		if ( record != null ) {
			return super.remove( record.getId() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		Long count = (Long) super.execNamedQueryWithSingleResult( buildQueryName("countAll") ) ;
		return count.longValue();
	}

	public long countById(Integer id) {
		Long count = (Long) super.execNamedQueryWithSingleResult( buildQueryName("countById"), id ) ;
		return count.longValue();
	}
	
	@Override
	public boolean exists(Integer id) {
		long count = countById(id) ;
		return count > 0 ;
	}


	@Override
	public boolean exists(AuthorRecord record) {
		if ( record != null ) {
			return exists( record.getId() );
		}
		return false ;
	}

	@SuppressWarnings("unchecked")
	public List<AuthorJpaRecord> queryExample() {
		List<?> list = super.execNamedQuery(buildQueryName("theNamedQueryToBeUsed")) ;
		return (List<AuthorJpaRecord>) list ;
	}

}
