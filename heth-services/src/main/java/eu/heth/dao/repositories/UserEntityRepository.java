/**
 * 
 */
package eu.heth.dao.repositories;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import eu.heth.bean.UserRole;
import eu.heth.entity.UserEntity;

/**
 * 
 * The cooker repository
 * 
 * @author tomey
 *
 */
@Repository
public interface UserEntityRepository extends MongoRepository<UserEntity, Long> {

	/**
	 * To get the cooker
	 * 
	 * @param nickname
	 *            the nickname
	 * @return the user
	 */
	UserEntity findFirstByNickname(String nickname);

	/**
	 * To get all cooker from a circle (point and radius)
	 * 
	 * @param circle
	 *            the circle
	 * @return users entities found
	 */
	List<UserEntity> findByLocationNear(Point location, Distance distance);

	/**
	 * To get all cooker from a circle (point and radius) with a role
	 * 
	 * @param location
	 *            the point
	 * @param distance
	 *            the distance in meter
	 * @param role
	 *            the role to find
	 * @return users entities found
	 */
	List<UserEntity> findByLocationNearAndRoles(Point location, Distance distance, UserRole role);

	/**
	 * To get all cooker from a circle (point and radius)
	 *
	 * @param circle
	 *            the circle
	 * @return users entities found
	 */
	// @Query("{ location: { $geoWithin: { $centerSphere: [ [ ?0, ?1] , ?3
	// /3963.2 ] } } } ")
	// List<CookerEntity> findCustomByLocation(String longitude, String
	// latitude, String radius);
}
