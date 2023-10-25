package org.demo.persistence.impl.jpa;


import java.util.List;
import javax.inject.Named;

import org.demo.data.record.BookOrderRecord; // "Neutral Record" class 
import org.demo.persistence.BookOrderPersistence; // Persistence service interface
import org.demo.persistence.impl.jpa.commons.GenericJpaService;
import org.demo.persistence.impl.jpa.mapper.BookOrderJpaMapper ;
import org.demo.persistence.impl.jpa.record.BookOrderJpaRecord; // "JPA Record" class (with JPA mapping) 

/**
 * BookOrder persistence service - JPA implementation 
 *
 */
@Named("BookOrderPersistence")
public class BookOrderPersistenceJpa extends GenericJpaService<BookOrderJpaRecord, Integer> implements BookOrderPersistence {

	private final BookOrderJpaMapper mapper = new BookOrderJpaMapper();

	/**
	 * Constructor
	 */
	public BookOrderPersistenceJpa() {
		super(BookOrderJpaRecord.class);
	}

	@Override
	public BookOrderRecord findById( Integer id ) {
		BookOrderJpaRecord entity = super.find( id );
		return mapper.mapEntityToRecord(entity);	
	}

	@Override
	public List<BookOrderRecord> findAll() {
		List<BookOrderJpaRecord> entities = super.loadAll() ;
		List<BookOrderRecord> records = new java.util.LinkedList<BookOrderRecord>();
		for ( BookOrderJpaRecord entity : entities ) {
			records.add( mapper.mapEntityToRecord(entity) ) ;
		}
		return records ;
	}

	@Override
	public BookOrderRecord create(BookOrderRecord record) {
		BookOrderJpaRecord entity = mapper.mapRecordToEntity(record);
		super.persist(entity);
		return record ;
	}
	
	@Override
	public boolean update(BookOrderRecord record) {
		Integer pk = record.getId() ;
		if ( super.find( pk ) != null ) {
			// Exists => 'merge' 
			BookOrderJpaRecord entity = mapper.mapRecordToEntity(record);
			super.merge(entity);
			return true ;
		}
		else {
			return false;
		}
	}

	@Override
	public BookOrderRecord save(BookOrderRecord record) {
		BookOrderJpaRecord entity = mapper.mapRecordToEntity(record);
		super.merge(entity);
		return record ;
	}

	@Override
	public boolean deleteById( Integer id ) {
		return super.remove( id );
	}

	@Override
	public boolean delete(BookOrderRecord record) {
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
	public boolean exists(BookOrderRecord record) {
		if ( record != null ) {
			return exists( record.getId() );
		}
		return false ;
	}

	@SuppressWarnings("unchecked")
	public List<BookOrderJpaRecord> queryExample() {
		List<?> list = super.execNamedQuery(buildQueryName("theNamedQueryToBeUsed")) ;
		return (List<BookOrderJpaRecord>) list ;
	}

}
