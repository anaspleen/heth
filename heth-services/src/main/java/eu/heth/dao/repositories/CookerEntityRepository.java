/**
 * 
 */
package eu.heth.dao.repositories;

import java.util.List;

import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import eu.heth.entity.CookerEntity;

/**
 * 
 * The cooker repository
 * 
 * @author tomey
 *
 */
@Repository
public interface CookerEntityRepository extends MongoRepository<CookerEntity, Long> {

	/**
	 * To get the cooker
	 * 
	 * @param nickname
	 *            the nickname
	 * @return the cooker
	 */
	CookerEntity findFirstByNickname(String nickname);

	/**
	 * To get all cooker from a circle (point and radius)
	 * 
	 * @param circle
	 *            the circle
	 * @return cookers entities found
	 */
	List<CookerEntity> findByLocationWithin(Circle circle);

	/**
	 * To get all cooker from a circle (point and radius)
	 * 
	 * @param circle
	 *            the circle
	 * @return cookers entities found
	 */
	List<CookerEntity> findByLocationNear(Point location, Distance distance);

	/**
	 * To get all cooker from a circle (point and radius)
	 *
	 * @param circle
	 *            the circle
	 * @return cookers entities found
	 */
	// @Query("{ location: { $geoWithin: { $centerSphere: [ [ ?0, ?1] , ?3
	// /3963.2 ] } } } ")
	// List<CookerEntity> findCustomByLocation(String longitude, String
	// latitude, String radius);
}
