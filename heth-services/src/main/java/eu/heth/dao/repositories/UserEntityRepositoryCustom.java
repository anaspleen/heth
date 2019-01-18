/**
 * 
 */
package eu.heth.dao.repositories;

import java.util.List;

import eu.heth.entity.UserEntity;

/**
 * To add more queries, see :
 * 
 * @see https://www.mkyong.com/spring-boot/spring-boot-spring-data-mongodb-example/
 * 
 * @author tcaiati
 *
 */
public interface UserEntityRepositoryCustom {

	/**
	 * To get all cooker from a circle (point and radius)
	 * 
	 * @param circle
	 *            the circle
	 * @return cookers entities found
	 */
	List<UserEntity> getCustom(String distance);
}
