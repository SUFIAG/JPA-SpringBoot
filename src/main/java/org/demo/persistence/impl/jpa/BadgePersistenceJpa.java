package org.demo.persistence.impl.jpa;

import java.util.List;
import javax.inject.Named;

import org.demo.data.record.BadgeRecord; // "Neutral Record" class 
import org.demo.persistence.BadgePersistence; // Persistence service interface
import org.demo.persistence.impl.jpa.commons.GenericJpaService;
import org.demo.persistence.impl.jpa.mapper.BadgeJpaMapper ;
import org.demo.persistence.impl.jpa.record.BadgeJpaRecord; // "JPA Record" class (with JPA mapping) 

/**
 * Badge persistence service - JPA implementation 
 */
@Named("BadgePersistence")
public class BadgePersistenceJpa extends GenericJpaService<BadgeJpaRecord, Integer> implements BadgePersistence {

	private final BadgeJpaMapper mapper = new BadgeJpaMapper();

	/**
	 * Constructor
	 */
	public BadgePersistenceJpa() {
		super(BadgeJpaRecord.class);
	}

	@Override
	public BadgeRecord findById( Integer badgeNumber ) {
		BadgeJpaRecord entity = super.find( badgeNumber );
		return mapper.mapEntityToRecord(entity);	
	}

	@Override
	public List<BadgeRecord> findAll() {
		List<BadgeJpaRecord> entities = super.loadAll() ;
		List<BadgeRecord> records = new java.util.LinkedList<BadgeRecord>();
		for ( BadgeJpaRecord entity : entities ) {
			records.add( mapper.mapEntityToRecord(entity) ) ;
		}
		return records ;
	}

	@Override
	public BadgeRecord create(BadgeRecord record) {
		BadgeJpaRecord entity = mapper.mapRecordToEntity(record);
		super.persist(entity);
		return record ;
	}
	
	@Override
	public boolean update(BadgeRecord record) {
		Integer pk = record.getBadgeNumber() ;
		if ( super.find( pk ) != null ) {
			// Exists => 'merge' 
			BadgeJpaRecord entity = mapper.mapRecordToEntity(record);
			super.merge(entity);
			return true ;
		}
		else {
			return false;
		}
	}

	@Override
	public BadgeRecord save(BadgeRecord record) {
		BadgeJpaRecord entity = mapper.mapRecordToEntity(record);
		super.merge(entity);
		return record ;
	}

	@Override
	public boolean deleteById( Integer badgeNumber ) {
		return super.remove( badgeNumber );
	}

	@Override
	public boolean delete(BadgeRecord record) {
		if ( record != null ) {
			return super.remove( record.getBadgeNumber() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		Long count = (Long) super.execNamedQueryWithSingleResult( buildQueryName("countAll") ) ;
		return count.longValue();
	}

	public long countById(Integer badgeNumber) {
		Long count = (Long) super.execNamedQueryWithSingleResult( buildQueryName("countById"), badgeNumber ) ;
		return count.longValue();
	}
	
	@Override
	public boolean exists(Integer badgeNumber) {
		long count = countById(badgeNumber) ;
		return count > 0 ;
	}


	@Override
	public boolean exists(BadgeRecord record) {
		if ( record != null ) {
			return exists( record.getBadgeNumber() );
		}
		return false ;
	}

	@SuppressWarnings("unchecked")
	public List<BadgeJpaRecord> queryExample() {
		List<?> list = super.execNamedQuery(buildQueryName("theNamedQueryToBeUsed")) ;
		return (List<BadgeJpaRecord>) list ;
	}

}
