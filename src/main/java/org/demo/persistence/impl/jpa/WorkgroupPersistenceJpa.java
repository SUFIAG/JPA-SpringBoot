package org.demo.persistence.impl.jpa;


import java.util.List;

import javax.inject.Named;

import org.demo.data.record.WorkgroupRecord; // "Neutral Record" class 
import org.demo.persistence.WorkgroupPersistence; // Persistence service interface
import org.demo.persistence.impl.jpa.commons.GenericJpaService;
import org.demo.persistence.impl.jpa.mapper.WorkgroupJpaMapper ;
import org.demo.persistence.impl.jpa.record.WorkgroupJpaRecord; // "JPA Record" class (with JPA mapping) 

/**
 * Workgroup persistence service - JPA implementation 
 */
@Named("WorkgroupPersistence")
public class WorkgroupPersistenceJpa extends GenericJpaService<WorkgroupJpaRecord, Short> implements WorkgroupPersistence {

	private final WorkgroupJpaMapper mapper = new WorkgroupJpaMapper();

	/**
	 * Constructor
	 */
	public WorkgroupPersistenceJpa() {
		super(WorkgroupJpaRecord.class);
	}

	@Override
	public WorkgroupRecord findById( Short id ) {
		WorkgroupJpaRecord entity = super.find( id );
		return mapper.mapEntityToRecord(entity);	
	}

	@Override
	public List<WorkgroupRecord> findAll() {
		List<WorkgroupJpaRecord> entities = super.loadAll() ;
		List<WorkgroupRecord> records = new java.util.LinkedList<WorkgroupRecord>();
		for ( WorkgroupJpaRecord entity : entities ) {
			records.add( mapper.mapEntityToRecord(entity) ) ;
		}
		return records ;
	}

	@Override
	public WorkgroupRecord create(WorkgroupRecord record) {
		WorkgroupJpaRecord entity = mapper.mapRecordToEntity(record);
		super.persist(entity);
		return record ;
	}
	
	@Override
	public boolean update(WorkgroupRecord record) {
		Short pk = record.getId() ;
		if ( super.find( pk ) != null ) {
			// Exists => 'merge' 
			WorkgroupJpaRecord entity = mapper.mapRecordToEntity(record);
			super.merge(entity);
			return true ;
		}
		else {
			return false;
		}
	}

	@Override
	public WorkgroupRecord save(WorkgroupRecord record) {
		WorkgroupJpaRecord entity = mapper.mapRecordToEntity(record);
		super.merge(entity);
		return record ;
	}

	@Override
	public boolean deleteById( Short id ) {
		return super.remove( id );
	}

	@Override
	public boolean delete(WorkgroupRecord record) {
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

	public long countById(Short id) {
		Long count = (Long) super.execNamedQueryWithSingleResult( buildQueryName("countById"), id ) ;
		return count.longValue();
	}
	
	@Override
	public boolean exists(Short id) {
		long count = countById(id) ;
		return count > 0 ;
	}


	@Override
	public boolean exists(WorkgroupRecord record) {
		if ( record != null ) {
			return exists( record.getId() );
		}
		return false ;
	}

	@SuppressWarnings("unchecked")
	public List<WorkgroupJpaRecord> queryExample() {
		List<?> list = super.execNamedQuery(buildQueryName("theNamedQueryToBeUsed")) ;
		return (List<WorkgroupJpaRecord>) list ;
	}

}
