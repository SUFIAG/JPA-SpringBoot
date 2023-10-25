package org.demo.persistence.impl.jpa;


import java.util.List;
import javax.inject.Named;

import org.demo.data.record.ReviewRecord; // "Neutral Record" class 
import org.demo.persistence.ReviewPersistence; // Persistence service interface
import org.demo.persistence.impl.jpa.commons.GenericJpaService;
import org.demo.persistence.impl.jpa.mapper.ReviewJpaMapper ;
import org.demo.persistence.impl.jpa.record.ReviewJpaRecord; // "JPA Record" class (with JPA mapping) 
import org.demo.persistence.impl.jpa.record.ReviewJpaRecordKey;

/**
 * Review persistence service - JPA implementation 
 */
@Named("ReviewPersistence")
public class ReviewPersistenceJpa extends GenericJpaService<ReviewJpaRecord, ReviewJpaRecordKey> implements ReviewPersistence {

	private final ReviewJpaMapper mapper = new ReviewJpaMapper();

	/**
	 * Constructor
	 */
	public ReviewPersistenceJpa() {
		super(ReviewJpaRecord.class);
	}

	@Override
	public ReviewRecord findById( String customerCode, Integer bookId ) {
		// Build the composite key
		ReviewJpaRecordKey key = new ReviewJpaRecordKey( customerCode, bookId );
		ReviewJpaRecord entity = super.find( key );
		return mapper.mapEntityToRecord(entity);	
	}

	@Override
	public List<ReviewRecord> findAll() {
		List<ReviewJpaRecord> entities = super.loadAll() ;
		List<ReviewRecord> records = new java.util.LinkedList<ReviewRecord>();
		for ( ReviewJpaRecord entity : entities ) {
			records.add( mapper.mapEntityToRecord(entity) ) ;
		}
		return records ;
	}

	@Override
	public ReviewRecord create(ReviewRecord record) {
		ReviewJpaRecord entity = mapper.mapRecordToEntity(record);
		super.persist(entity);
		return record ;
	}
	
	@Override
	public boolean update(ReviewRecord record) {
		// Build the composite key
		ReviewJpaRecordKey pk = new ReviewJpaRecordKey( record.getCustomerCode(), record.getBookId() );
		if ( super.find( pk ) != null ) {
			// Exists => 'merge' 
			ReviewJpaRecord entity = mapper.mapRecordToEntity(record);
			super.merge(entity);
			return true ;
		}
		else {
			return false;
		}
	}

	@Override
	public ReviewRecord save(ReviewRecord record) {
		ReviewJpaRecord entity = mapper.mapRecordToEntity(record);
		super.merge(entity);
		return record ;
	}

	@Override
	public boolean deleteById( String customerCode, Integer bookId ) {
		// Build the composite key
		ReviewJpaRecordKey key = new ReviewJpaRecordKey( customerCode, bookId );
		return super.remove( key );
	}

	@Override
	public boolean delete(ReviewRecord record) {
		if ( record != null ) {
			// Build the composite key
			ReviewJpaRecordKey key = new ReviewJpaRecordKey( record.getCustomerCode(), record.getBookId() );
			return super.remove( key );
		}
		return false ;
	}

	@Override
	public long countAll() {
		Long count = (Long) super.execNamedQueryWithSingleResult( buildQueryName("countAll") ) ;
		return count.longValue();
	}

	public long countById(String customerCode, Integer bookId) {
		Long count = (Long) super.execNamedQueryWithSingleResult( buildQueryName("countById"), customerCode, bookId ) ;
		return count.longValue();
	}
	
	@Override
	public boolean exists(String customerCode, Integer bookId) {
		long count = countById(customerCode, bookId) ;
		return count > 0 ;
	}


	@Override
	public boolean exists(ReviewRecord record) {
		if ( record != null ) {
			return exists( record.getCustomerCode(), record.getBookId() );
		}
		return false ;
	}

	@SuppressWarnings("unchecked")
	public List<ReviewJpaRecord> queryExample() {
		List<?> list = super.execNamedQuery(buildQueryName("theNamedQueryToBeUsed")) ;
		return (List<ReviewJpaRecord>) list ;
	}

}
