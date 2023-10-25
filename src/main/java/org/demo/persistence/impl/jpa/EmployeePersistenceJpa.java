package org.demo.persistence.impl.jpa;


import java.util.List;

import javax.inject.Named;

import org.demo.data.record.EmployeeRecord; // "Neutral Record" class 
import org.demo.persistence.EmployeePersistence; // Persistence service interface
import org.demo.persistence.impl.jpa.commons.GenericJpaService;
import org.demo.persistence.impl.jpa.mapper.EmployeeJpaMapper ;
import org.demo.persistence.impl.jpa.record.EmployeeJpaRecord; // "JPA Record" class (with JPA mapping) 

/**
 * Employee persistence service - JPA implementation 
 */
@Named("EmployeePersistence")
public class EmployeePersistenceJpa extends GenericJpaService<EmployeeJpaRecord, String> implements EmployeePersistence {

	private final EmployeeJpaMapper mapper = new EmployeeJpaMapper();

	/**
	 * Constructor
	 */
	public EmployeePersistenceJpa() {
		super(EmployeeJpaRecord.class);
	}

	@Override
	public EmployeeRecord findById( String code ) {
		EmployeeJpaRecord entity = super.find( code );
		return mapper.mapEntityToRecord(entity);	
	}

	@Override
	public List<EmployeeRecord> findAll() {
		List<EmployeeJpaRecord> entities = super.loadAll() ;
		List<EmployeeRecord> records = new java.util.LinkedList<EmployeeRecord>();
		for ( EmployeeJpaRecord entity : entities ) {
			records.add( mapper.mapEntityToRecord(entity) ) ;
		}
		return records ;
	}

	@Override
	public EmployeeRecord create(EmployeeRecord record) {
		EmployeeJpaRecord entity = mapper.mapRecordToEntity(record);
		super.persist(entity);
		return record ;
	}
	
	@Override
	public boolean update(EmployeeRecord record) {
		String pk = record.getCode() ;
		if ( super.find( pk ) != null ) {
			// Exists => 'merge' 
			EmployeeJpaRecord entity = mapper.mapRecordToEntity(record);
			super.merge(entity);
			return true ;
		}
		else {
			return false;
		}
	}

	@Override
	public EmployeeRecord save(EmployeeRecord record) {
		EmployeeJpaRecord entity = mapper.mapRecordToEntity(record);
		super.merge(entity);
		return record ;
	}

	@Override
	public boolean deleteById( String code ) {
		return super.remove( code );
	}

	@Override
	public boolean delete(EmployeeRecord record) {
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
	public boolean exists(EmployeeRecord record) {
		if ( record != null ) {
			return exists( record.getCode() );
		}
		return false ;
	}

	@SuppressWarnings("unchecked")
	public List<EmployeeJpaRecord> queryExample() {
		List<?> list = super.execNamedQuery(buildQueryName("theNamedQueryToBeUsed")) ;
		return (List<EmployeeJpaRecord>) list ;
	}

}
