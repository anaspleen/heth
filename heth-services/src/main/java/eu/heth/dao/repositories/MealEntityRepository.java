/**
 * 
 */
package eu.heth.dao.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import eu.heth.entity.MealEntity;

/**
 * https://www.mkyong.com/spring-boot/spring-boot-spring-data-mongodb-example/
 * 
 * @author tomey
 *
 */
// No need implementation, just one interface, and you have CRUD, thanks Spring
// Data
@Repository
public interface MealEntityRepository extends MongoRepository<MealEntity, Long> {

	// long countByLastname(String lastname);

	MealEntity findFirstByName(String name);
}
