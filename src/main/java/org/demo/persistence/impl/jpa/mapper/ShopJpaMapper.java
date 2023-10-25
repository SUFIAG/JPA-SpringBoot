package org.demo.persistence.impl.jpa.mapper;

import org.demo.persistence.impl.jpa.commons.AbstractServiceMapper;

import org.demo.data.record.ShopRecord; // "Neutral Record" class 
import org.demo.persistence.impl.jpa.record.ShopJpaRecord; // "JPA Entity" class 

/**
 * Mapping between entity beans and display beans.
 */
public class ShopJpaMapper extends AbstractServiceMapper {

	/**
	 * Constructor.
	 */
	public ShopJpaMapper() {
		super();
	}

	/**
	 * Mapping from 'ShopJpaRecord' to 'ShopRecord'
	 * 
	 * @param entity
	 *            the mapping input
	 */
	public ShopRecord mapEntityToRecord(ShopJpaRecord entity) {
		if (entity == null) {
			return null;
		}

		// --- Generic mapping
		ShopRecord record = map(entity, ShopRecord.class);

		return record;
	}

	/**
	 * Mapping from 'ShopRecord' to 'ShopJpaRecord'
	 * 
	 * @param record
	 *            the mapping input
	 * @return
	 */
	public ShopJpaRecord mapRecordToEntity(ShopRecord record) {
		if (record == null) {
			return null;
		}
		return map(record, ShopJpaRecord.class);
	}

	/**
	 * Mapping from record 'ShopRecord' to entity 'ShopJpaRecord'
	 * 
	 * @param record
	 * @param entity
	 */
	public void mapRecordToEntity(ShopRecord record, ShopJpaRecord entity) {
		if (record == null) {
			return;
		}

		// --- Generic mapping
		map(record, entity);
	}

}