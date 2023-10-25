package org.demo.persistence.impl.jpa;

import java.util.List;
import javax.inject.Named;

import org.demo.data.record.BookOrderItemRecord; // "Neutral Record" class 
import org.demo.persistence.BookOrderItemPersistence; // Persistence service interface
import org.demo.persistence.impl.jpa.commons.GenericJpaService;
import org.demo.persistence.impl.jpa.mapper.BookOrderItemJpaMapper ;
import org.demo.persistence.impl.jpa.record.BookOrderItemJpaRecord; // "JPA Record" class (with JPA mapping) 
import org.demo.persistence.impl.jpa.record.BookOrderItemJpaRecordKey;

/**
 * BookOrderItem persistence service - JPA implementation 
 *
 */
@Named("BookOrderItemPersistence")
public class BookOrderItemPersistenceJpa extends GenericJpaService<BookOrderItemJpaRecord, BookOrderItemJpaRecordKey> implements BookOrderItemPersistence {

	private final BookOrderItemJpaMapper mapper = new BookOrderItemJpaMapper();

	/**
	 * Constructor
	 */
	public BookOrderItemPersistenceJpa() {
		super(BookOrderItemJpaRecord.class);
	}

	@Override
	public BookOrderItemRecord findById( Integer bookOrderId, Integer bookId ) {
		// Build the composite key
		BookOrderItemJpaRecordKey key = new BookOrderItemJpaRecordKey( bookOrderId, bookId );
		BookOrderItemJpaRecord entity = super.find( key );
		return mapper.mapEntityToRecord(entity);	
	}

	@Override
	public List<BookOrderItemRecord> findAll() {
		List<BookOrderItemJpaRecord> entities = super.loadAll() ;
		List<BookOrderItemRecord> records = new java.util.LinkedList<BookOrderItemRecord>();
		for ( BookOrderItemJpaRecord entity : entities ) {
			records.add( mapper.mapEntityToRecord(entity) ) ;
		}
		return records ;
	}

	@Override
	public BookOrderItemRecord create(BookOrderItemRecord record) {
		BookOrderItemJpaRecord entity = mapper.mapRecordToEntity(record);
		super.persist(entity);
		return record ;
	}
	
	@Override
	public boolean update(BookOrderItemRecord record) {
		// Build the composite key
		BookOrderItemJpaRecordKey pk = new BookOrderItemJpaRecordKey( record.getBookOrderId(), record.getBookId() );
		if ( super.find( pk ) != null ) {
			// Exists => 'merge' 
			BookOrderItemJpaRecord entity = mapper.mapRecordToEntity(record);
			super.merge(entity);
			return true ;
		}
		else {
			return false;
		}
	}

	@Override
	public BookOrderItemRecord save(BookOrderItemRecord record) {
		BookOrderItemJpaRecord entity = mapper.mapRecordToEntity(record);
		super.merge(entity);
		return record ;
	}

	@Override
	public boolean deleteById( Integer bookOrderId, Integer bookId ) {
		// Build the composite key
		BookOrderItemJpaRecordKey key = new BookOrderItemJpaRecordKey( bookOrderId, bookId );
		return super.remove( key );
	}

	@Override
	public boolean delete(BookOrderItemRecord record) {
		if ( record != null ) {
			// Build the composite key
			BookOrderItemJpaRecordKey key = new BookOrderItemJpaRecordKey( record.getBookOrderId(), record.getBookId() );
			return super.remove( key );
		}
		return false ;
	}

	@Override
	public long countAll() {
		Long count = (Long) super.execNamedQueryWithSingleResult( buildQueryName("countAll") ) ;
		return count.longValue();
	}

	public long countById(Integer bookOrderId, Integer bookId) {
		Long count = (Long) super.execNamedQueryWithSingleResult( buildQueryName("countById"), bookOrderId, bookId ) ;
		return count.longValue();
	}
	
	@Override
	public boolean exists(Integer bookOrderId, Integer bookId) {
		long count = countById(bookOrderId, bookId) ;
		return count > 0 ;
	}


	@Override
	public boolean exists(BookOrderItemRecord record) {
		if ( record != null ) {
			return exists( record.getBookOrderId(), record.getBookId() );
		}
		return false ;
	}

	@SuppressWarnings("unchecked")
	public List<BookOrderItemJpaRecord> queryExample() {
		List<?> list = super.execNamedQuery(buildQueryName("theNamedQueryToBeUsed")) ;
		return (List<BookOrderItemJpaRecord>) list ;
	}

}
