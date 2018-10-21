/**
 * 
 */
package eu.heth.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import eu.heth.entity.MealEntity;

/**
 * https://www.mkyong.com/spring-boot/spring-boot-spring-data-mongodb-example/
 * 
 * @author tomey
 *
 */
// No need implementation, just one interface, and you have CRUD, thanks Spring
// Data
public interface MealEntityRepository extends MongoRepository<MealEntity, Long>, MealEntityRepositoryCustom {

	// long countByLastname(String lastname);

	MealEntity findFirstByName(String name);
}
