package org.demo.persistence;

import java.util.List;

import org.demo.data.record.BadgeRecord;

/**
 * Persistence Interface for BadgeRecord.
 */
public interface BadgePersistence {

	/**
	 * Tries to find an entity using its Id / Primary Key
	 * 
	 * @param badgeNumber
	 * @return entity
	 */
	BadgeRecord findById(Integer badgeNumber);

	/**
	 * Finds all entities.
	 * 
	 * @return all entities
	 */
	List<BadgeRecord> findAll();

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
	BadgeRecord save(BadgeRecord entity);

	/**
	 * Updates the given entity in the database
	 * 
	 * @param entity
	 * @return true if the entity has been updated, false if not found and not
	 *         updated
	 */
	boolean update(BadgeRecord entity);

	/**
	 * Creates the given entity in the database
	 * 
	 * @param entity
	 * @return
	 */
	BadgeRecord create(BadgeRecord entity);

	/**
	 * Deletes an entity using its Id / Primary Key
	 * 
	 * @param badgeNumber
	 * @return true if the entity has been deleted, false if not found and not
	 *         deleted
	 */
	boolean deleteById(Integer badgeNumber);

	/**
	 * Deletes an entity using the Id / Primary Key stored in the given object
	 * 
	 * @param the
	 *            entity to be deleted (supposed to have a valid Id/PK )
	 * @return true if the entity has been deleted, false if not found and not
	 *         deleted
	 */
	boolean delete(BadgeRecord entity);

	/**
	 * Returns true if an entity exists with the given Id / Primary Key
	 * 
	 * @param badgeNumber
	 * @return
	 */
	public boolean exists(Integer badgeNumber);

	/**
	 * Returns true if the given entity exists
	 * 
	 * @param entity
	 * @return
	 */
	public boolean exists(BadgeRecord entity);

}
