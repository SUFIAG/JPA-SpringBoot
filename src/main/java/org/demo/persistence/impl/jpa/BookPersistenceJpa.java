package org.demo.persistence.impl.jpa;

import java.util.List;

import javax.inject.Named;

import org.demo.data.record.BookRecord; // "Neutral Record" class 
import org.demo.persistence.BookPersistence; // Persistence service interface
import org.demo.persistence.impl.jpa.commons.GenericJpaService;
import org.demo.persistence.impl.jpa.mapper.BookJpaMapper ;
import org.demo.persistence.impl.jpa.record.BookJpaRecord; // "JPA Record" class (with JPA mapping) 

/**
 * Book persistence service - JPA implementation 
 */
@Named("BookPersistence")
public class BookPersistenceJpa extends GenericJpaService<BookJpaRecord, Integer> implements BookPersistence {

	private final BookJpaMapper mapper = new BookJpaMapper();

	/**
	 * Constructor
	 */
	public BookPersistenceJpa() {
		super(BookJpaRecord.class);
	}

	@Override
	public BookRecord findById( Integer id ) {
		BookJpaRecord entity = super.find( id );
		return mapper.mapEntityToRecord(entity);	
	}

	@Override
	public List<BookRecord> findAll() {
		List<BookJpaRecord> entities = super.loadAll() ;
		List<BookRecord> records = new java.util.LinkedList<BookRecord>();
		for ( BookJpaRecord entity : entities ) {
			records.add( mapper.mapEntityToRecord(entity) ) ;
		}
		return records ;
	}

	@Override
	public BookRecord create(BookRecord record) {
		BookJpaRecord entity = mapper.mapRecordToEntity(record);
		super.persist(entity);
		return record ;
	}
	
	@Override
	public boolean update(BookRecord record) {
		Integer pk = record.getId() ;
		if ( super.find( pk ) != null ) {
			// Exists => 'merge' 
			BookJpaRecord entity = mapper.mapRecordToEntity(record);
			super.merge(entity);
			return true ;
		}
		else {
			return false;
		}
	}

	@Override
	public BookRecord save(BookRecord record) {
		BookJpaRecord entity = mapper.mapRecordToEntity(record);
		super.merge(entity);
		return record ;
	}

	@Override
	public boolean deleteById( Integer id ) {
		return super.remove( id );
	}

	@Override
	public boolean delete(BookRecord record) {
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
	public boolean exists(BookRecord record) {
		if ( record != null ) {
			return exists( record.getId() );
		}
		return false ;
	}

	@SuppressWarnings("unchecked")
	public List<BookJpaRecord> queryExample() {
		List<?> list = super.execNamedQuery(buildQueryName("theNamedQueryToBeUsed")) ;
		return (List<BookJpaRecord>) list ;
	}

}
