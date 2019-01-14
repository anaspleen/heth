/**
 * 
 */
package eu.heth.dao.repositories;

import java.util.List;

import eu.heth.entity.CookerEntity;

/**
 * To add more queries, see :
 * 
 * @see https://www.mkyong.com/spring-boot/spring-boot-spring-data-mongodb-example/
 * 
 * @author tcaiati
 *
 */
public interface CookerEntityRepositoryCustom {

	/**
	 * To get all cooker from a circle (point and radius)
	 * 
	 * @param circle
	 *            the circle
	 * @return cookers entities found
	 */
	List<CookerEntity> getCustom(String distance);
}
