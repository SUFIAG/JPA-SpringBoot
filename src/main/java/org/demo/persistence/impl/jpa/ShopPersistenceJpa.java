package org.demo.persistence.impl.jpa;


import java.util.List;

import javax.inject.Named;

import org.demo.data.record.ShopRecord; // "Neutral Record" class 
import org.demo.persistence.ShopPersistence; // Persistence service interface
import org.demo.persistence.impl.jpa.commons.GenericJpaService;
import org.demo.persistence.impl.jpa.mapper.ShopJpaMapper ;
import org.demo.persistence.impl.jpa.record.ShopJpaRecord; // "JPA Record" class (with JPA mapping) 

/**
 * Shop persistence service - JPA implementation 
 */
@Named("ShopPersistence")
public class ShopPersistenceJpa extends GenericJpaService<ShopJpaRecord, String> implements ShopPersistence {

	private final ShopJpaMapper mapper = new ShopJpaMapper();

	/**
	 * Constructor
	 */
	public ShopPersistenceJpa() {
		super(ShopJpaRecord.class);
	}

	@Override
	public ShopRecord findById( String code ) {
		ShopJpaRecord entity = super.find( code );
		return mapper.mapEntityToRecord(entity);	
	}

	@Override
	public List<ShopRecord> findAll() {
		List<ShopJpaRecord> entities = super.loadAll() ;
		List<ShopRecord> records = new java.util.LinkedList<ShopRecord>();
		for ( ShopJpaRecord entity : entities ) {
			records.add( mapper.mapEntityToRecord(entity) ) ;
		}
		return records ;
	}

	@Override
	public ShopRecord create(ShopRecord record) {
		ShopJpaRecord entity = mapper.mapRecordToEntity(record);
		super.persist(entity);
		return record ;
	}
	
	@Override
	public boolean update(ShopRecord record) {
		String pk = record.getCode() ;
		if ( super.find( pk ) != null ) {
			// Exists => 'merge' 
			ShopJpaRecord entity = mapper.mapRecordToEntity(record);
			super.merge(entity);
			return true ;
		}
		else {
			return false;
		}
	}

	@Override
	public ShopRecord save(ShopRecord record) {
		ShopJpaRecord entity = mapper.mapRecordToEntity(record);
		super.merge(entity);
		return record ;
	}

	@Override
	public boolean deleteById( String code ) {
		return super.remove( code );
	}

	@Override
	public boolean delete(ShopRecord record) {
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
	public boolean exists(ShopRecord record) {
		if ( record != null ) {
			return exists( record.getCode() );
		}
		return false ;
	}

	@SuppressWarnings("unchecked")
	public List<ShopJpaRecord> queryExample() {
		List<?> list = super.execNamedQuery(buildQueryName("theNamedQueryToBeUsed")) ;
		return (List<ShopJpaRecord>) list ;
	}

}
