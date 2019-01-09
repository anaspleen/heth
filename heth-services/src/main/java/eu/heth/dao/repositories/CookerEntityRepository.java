/**
 * 
 */
package eu.heth.dao.repositories;

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
}
