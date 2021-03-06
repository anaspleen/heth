/**
 * 
 */
package eu.heth.dao.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import eu.heth.entity.MealEntity;

/**
 * The meal repository
 * 
 * @see https://www.mkyong.com/spring-boot/spring-boot-spring-data-mongodb-example/
 * 
 *      No need implementation, just one interface, and you have CRUD, thanks
 *      Spring Data
 * 
 * @author tomey
 *
 */
@Repository
public interface MealEntityRepository extends MongoRepository<MealEntity, Long> {

	// long countByLastname(String lastname);

	MealEntity findFirstByName(String name);

	/**
	 * Find meals by cooker
	 * 
	 * @param cooker
	 *            the cooker
	 * @return the meals found
	 */
	List<MealEntity> findByCooker(String cooker);
}
