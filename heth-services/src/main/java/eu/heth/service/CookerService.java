/**
 * 
 */
package eu.heth.service;

import java.util.List;

import eu.heth.bean.Cooker;
import eu.heth.exception.ApplicationException;
import eu.heth.exception.SystemException;

/**
 * To manage Cookers
 * 
 * @author tomey
 *
 */
public interface CookerService {

	/**
	 * To get the cooker by nickname
	 * 
	 * @param nickname
	 *            the nickname of cooker
	 * @return the cooker
	 * @throws ApplicationException
	 *             applicative exception
	 * @throws SystemException
	 *             technical exception
	 */
	Cooker getCookerByNickname(String nickname) throws ApplicationException, SystemException;

	/**
	 * To save a cooker
	 * 
	 * @param nickname
	 *            the nickname
	 * @param email
	 *            the email
	 * @return the id in database
	 * 
	 * @throws ApplicationException
	 *             applicative exception
	 * @throws SystemException
	 *             technical exception
	 */
	String saveCooker(String nickname, String email) throws ApplicationException, SystemException;

	/**
	 * To search cooker form geography
	 * 
	 * @param longitude
	 *            the X, example : 5.4
	 * @param latitude
	 *            the Y, example : 45.2
	 * @param radius
	 *            the radius in meter
	 * @return cookers found
	 * 
	 * @throws ApplicationException
	 *             applicative exception
	 * @throws SystemException
	 *             technical exception
	 */
	List<Cooker> searchCookers(int longitude, int latitude, int radius) throws ApplicationException, SystemException;
}
