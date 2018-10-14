/**
 * 
 */
package eu.heth.dao;

import java.util.List;

import eu.heth.entity.MealEntity;

/**
 * @author tomey
 *
 */
public interface MealRepository extends CrudRepository<MealEntity, Long> {

	long countByLastname(String lastname);
	
	List<MealEntity> findByName(String name);
}
