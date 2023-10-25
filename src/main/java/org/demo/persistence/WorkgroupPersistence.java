package org.demo.persistence;

import java.util.List;

import org.demo.data.record.WorkgroupRecord;

/**
 * Persistence Interface for WorkgroupRecord.
 */
public interface WorkgroupPersistence {

	/**
	 * Tries to find an entity using its Id / Primary Key
	 * 
	 * @param id
	 * @return entity
	 */
	WorkgroupRecord findById(Short id);

	/**
	 * Finds all entities.
	 * 
	 * @return all entities
	 */
	List<WorkgroupRecord> findAll();

	/**
	 * Counts all the records present in the database
	 * 
	 * @return
	 */
	public long countAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * 
	 * @param entity
	 * @return entity
	 */
	WorkgroupRecord save(WorkgroupRecord entity);

	/**
	 * Updates the given entity in the database
	 * 
	 * @param entity
	 * @return true if the entity has been updated, false if not found and not
	 *         updated
	 */
	boolean update(WorkgroupRecord entity);

	/**
	 * Creates the given entity in the database
	 * 
	 * @param entity
	 * @return
	 */
	WorkgroupRecord create(WorkgroupRecord entity);

	/**
	 * Deletes an entity using its Id / Primary Key
	 * 
	 * @param id
	 * @return true if the entity has been deleted, false if not found and not
	 *         deleted
	 */
	boolean deleteById(Short id);

	/**
	 * Deletes an entity using the Id / Primary Key stored in the given object
	 * 
	 * @param the
	 *            entity to be deleted (supposed to have a valid Id/PK )
	 * @return true if the entity has been deleted, false if not found and not
	 *         deleted
	 */
	boolean delete(WorkgroupRecord entity);

	/**
	 * Returns true if an entity exists with the given Id / Primary Key
	 * 
	 * @param id
	 * @return
	 */
	public boolean exists(Short id);

	/**
	 * Returns true if the given entity exists
	 * 
	 * @param entity
	 * @return
	 */
	public boolean exists(WorkgroupRecord entity);

}
