package org.demo.persistence.impl.jpa;

import java.util.List;
import javax.inject.Named;

import org.demo.data.record.EmployeeGroupRecord; // "Neutral Record" class 
import org.demo.persistence.EmployeeGroupPersistence; // Persistence service interface
import org.demo.persistence.impl.jpa.commons.GenericJpaService;
import org.demo.persistence.impl.jpa.mapper.EmployeeGroupJpaMapper ;
import org.demo.persistence.impl.jpa.record.EmployeeGroupJpaRecord; // "JPA Record" class (with JPA mapping) 
import org.demo.persistence.impl.jpa.record.EmployeeGroupJpaRecordKey;

/**
 * EmployeeGroup persistence service - JPA implementation 
 */
@Named("EmployeeGroupPersistence")
public class EmployeeGroupPersistenceJpa extends GenericJpaService<EmployeeGroupJpaRecord, EmployeeGroupJpaRecordKey> implements EmployeeGroupPersistence {

	private final EmployeeGroupJpaMapper mapper = new EmployeeGroupJpaMapper();

	/**
	 * Constructor
	 */
	public EmployeeGroupPersistenceJpa() {
		super(EmployeeGroupJpaRecord.class);
	}

	@Override
	public EmployeeGroupRecord findById( String employeeCode, Short groupId ) {
		// Build the composite key
		EmployeeGroupJpaRecordKey key = new EmployeeGroupJpaRecordKey( employeeCode, groupId );
		EmployeeGroupJpaRecord entity = super.find( key );
		return mapper.mapEntityToRecord(entity);	
	}

	@Override
	public List<EmployeeGroupRecord> findAll() {
		List<EmployeeGroupJpaRecord> entities = super.loadAll() ;
		List<EmployeeGroupRecord> records = new java.util.LinkedList<EmployeeGroupRecord>();
		for ( EmployeeGroupJpaRecord entity : entities ) {
			records.add( mapper.mapEntityToRecord(entity) ) ;
		}
		return records ;
	}

	@Override
	public EmployeeGroupRecord create(EmployeeGroupRecord record) {
		EmployeeGroupJpaRecord entity = mapper.mapRecordToEntity(record);
		super.persist(entity);
		return record ;
	}
	
	@Override
	public boolean update(EmployeeGroupRecord record) {
		// Build the composite key
		EmployeeGroupJpaRecordKey pk = new EmployeeGroupJpaRecordKey( record.getEmployeeCode(), record.getGroupId() );
		if ( super.find( pk ) != null ) {
			// Exists => 'merge' 
			EmployeeGroupJpaRecord entity = mapper.mapRecordToEntity(record);
			super.merge(entity);
			return true ;
		}
		else {
			return false;
		}
	}

	@Override
	public EmployeeGroupRecord save(EmployeeGroupRecord record) {
		EmployeeGroupJpaRecord entity = mapper.mapRecordToEntity(record);
		super.merge(entity);
		return record ;
	}

	@Override
	public boolean deleteById( String employeeCode, Short groupId ) {
		// Build the composite key
		EmployeeGroupJpaRecordKey key = new EmployeeGroupJpaRecordKey( employeeCode, groupId );
		return super.remove( key );
	}

	@Override
	public boolean delete(EmployeeGroupRecord record) {
		if ( record != null ) {
			// Build the composite key
			EmployeeGroupJpaRecordKey key = new EmployeeGroupJpaRecordKey( record.getEmployeeCode(), record.getGroupId() );
			return super.remove( key );
		}
		return false ;
	}

	@Override
	public long countAll() {
		Long count = (Long) super.execNamedQueryWithSingleResult( buildQueryName("countAll") ) ;
		return count.longValue();
	}

	public long countById(String employeeCode, Short groupId) {
		Long count = (Long) super.execNamedQueryWithSingleResult( buildQueryName("countById"), employeeCode, groupId ) ;
		return count.longValue();
	}
	
	@Override
	public boolean exists(String employeeCode, Short groupId) {
		long count = countById(employeeCode, groupId) ;
		return count > 0 ;
	}


	@Override
	public boolean exists(EmployeeGroupRecord record) {
		if ( record != null ) {
			return exists( record.getEmployeeCode(), record.getGroupId() );
		}
		return false ;
	}

	@SuppressWarnings("unchecked")
	public List<EmployeeGroupJpaRecord> queryExample() {
		List<?> list = super.execNamedQuery(buildQueryName("theNamedQueryToBeUsed")) ;
		return (List<EmployeeGroupJpaRecord>) list ;
	}

}
