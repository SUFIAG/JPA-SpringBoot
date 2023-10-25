package org.demo.persistence.impl.jpa;


import java.util.List;
import javax.inject.Named;

import org.demo.data.record.CustomerRecord; // "Neutral Record" class 
import org.demo.persistence.CustomerPersistence; // Persistence service interface
import org.demo.persistence.impl.jpa.commons.GenericJpaService;
import org.demo.persistence.impl.jpa.mapper.CustomerJpaMapper ;
import org.demo.persistence.impl.jpa.record.CustomerJpaRecord; // "JPA Record" class (with JPA mapping) 

/**
 * Customer persistence service - JPA implementation 
 */
@Named("CustomerPersistence")
public class CustomerPersistenceJpa extends GenericJpaService<CustomerJpaRecord, String> implements CustomerPersistence {

	private final CustomerJpaMapper mapper = new CustomerJpaMapper();

	/**
	 * Constructor
	 */
	public CustomerPersistenceJpa() {
		super(CustomerJpaRecord.class);
	}

	@Override
	public CustomerRecord findById( String code ) {
		CustomerJpaRecord entity = super.find( code );
		return mapper.mapEntityToRecord(entity);	
	}

	@Override
	public List<CustomerRecord> findAll() {
		List<CustomerJpaRecord> entities = super.loadAll() ;
		List<CustomerRecord> records = new java.util.LinkedList<CustomerRecord>();
		for ( CustomerJpaRecord entity : entities ) {
			records.add( mapper.mapEntityToRecord(entity) ) ;
		}
		return records ;
	}

	@Override
	public CustomerRecord create(CustomerRecord record) {
		CustomerJpaRecord entity = mapper.mapRecordToEntity(record);
		super.persist(entity);
		return record ;
	}
	
	@Override
	public boolean update(CustomerRecord record) {
		String pk = record.getCode() ;
		if ( super.find( pk ) != null ) {
			// Exists => 'merge' 
			CustomerJpaRecord entity = mapper.mapRecordToEntity(record);
			super.merge(entity);
			return true ;
		}
		else {
			return false;
		}
	}

	@Override
	public CustomerRecord save(CustomerRecord record) {
		CustomerJpaRecord entity = mapper.mapRecordToEntity(record);
		super.merge(entity);
		return record ;
	}

	@Override
	public boolean deleteById( String code ) {
		return super.remove( code );
	}

	@Override
	public boolean delete(CustomerRecord record) {
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
	public boolean exists(CustomerRecord record) {
		if ( record != null ) {
			return exists( record.getCode() );
		}
		return false ;
	}

	@SuppressWarnings("unchecked")
	public List<CustomerJpaRecord> queryExample() {
		List<?> list = super.execNamedQuery(buildQueryName("theNamedQueryToBeUsed")) ;
		return (List<CustomerJpaRecord>) list ;
	}

}
