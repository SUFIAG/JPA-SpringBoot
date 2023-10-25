package org.demo.persistence.impl.jpa.mapper;

import org.demo.persistence.impl.jpa.commons.AbstractServiceMapper;

import org.demo.data.record.AuthorRecord; // "Neutral Record" class 
import org.demo.persistence.impl.jpa.record.AuthorJpaRecord; // "JPA Entity" class 

/**
 * Mapping between entity beans and display beans.
 */
public class AuthorJpaMapper extends AbstractServiceMapper {

	/**
	 * Constructor.
	 */
	public AuthorJpaMapper() {
		super();
	}

	/**
	 * Mapping from 'AuthorJpaRecord' to 'AuthorRecord'
	 * 
	 * @param entity
	 *            the mapping input
	 */
	public AuthorRecord mapEntityToRecord(AuthorJpaRecord entity) {
		if (entity == null) {
			return null;
		}

		// --- Generic mapping
		AuthorRecord record = map(entity, AuthorRecord.class);

		return record;
	}

	/**
	 * Mapping from 'AuthorRecord' to 'AuthorJpaRecord'
	 * 
	 * @param record
	 *            the mapping input
	 * @return
	 */
	public AuthorJpaRecord mapRecordToEntity(AuthorRecord record) {
		if (record == null) {
			return null;
		}
		return map(record, AuthorJpaRecord.class);
	}

	/**
	 * Mapping from record 'AuthorRecord' to entity 'AuthorJpaRecord'
	 * 
	 * @param record
	 * @param entity
	 */
	public void mapRecordToEntity(AuthorRecord record, AuthorJpaRecord entity) {
		if (record == null) {
			return;
		}

		// --- Generic mapping
		map(record, entity);
	}

}