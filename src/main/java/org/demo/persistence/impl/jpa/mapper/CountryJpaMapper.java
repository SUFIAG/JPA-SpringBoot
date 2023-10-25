package org.demo.persistence.impl.jpa.mapper;

import org.demo.persistence.impl.jpa.commons.AbstractServiceMapper;

import org.demo.data.record.CountryRecord; // "Neutral Record" class 
import org.demo.persistence.impl.jpa.record.CountryJpaRecord; // "JPA Entity" class 

/**
 * Mapping between entity beans and display beans.
 */
public class CountryJpaMapper extends AbstractServiceMapper {

	/**
	 * Constructor.
	 */
	public CountryJpaMapper() {
		super();
	}

	/**
	 * Mapping from 'CountryJpaRecord' to 'CountryRecord'
	 * 
	 * @param entity
	 *            the mapping input
	 */
	public CountryRecord mapEntityToRecord(CountryJpaRecord entity) {
		if (entity == null) {
			return null;
		}

		// --- Generic mapping
		CountryRecord record = map(entity, CountryRecord.class);

		return record;
	}

	/**
	 * Mapping from 'CountryRecord' to 'CountryJpaRecord'
	 * 
	 * @param record
	 *            the mapping input
	 * @return
	 */
	public CountryJpaRecord mapRecordToEntity(CountryRecord record) {
		if (record == null) {
			return null;
		}
		return map(record, CountryJpaRecord.class);
	}

	/**
	 * Mapping from record 'CountryRecord' to entity 'CountryJpaRecord'
	 * 
	 * @param record
	 * @param entity
	 */
	public void mapRecordToEntity(CountryRecord record, CountryJpaRecord entity) {
		if (record == null) {
			return;
		}

		// --- Generic mapping
		map(record, entity);
	}

}