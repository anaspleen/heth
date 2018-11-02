/**
 * 
 */
package eu.heth.service;

import java.util.List;

import eu.heth.bean.Meal;
import eu.heth.exception.ApplicationException;
import eu.heth.exception.SystemException;

/**
 * To manage Meals
 * 
 * @author tomey
 *
 */
public interface MealService {

	/**
	 * To get all meals of cooker
	 * 
	 * @param cooker
	 *            the login cooker
	 * @return the meals
	 * @throws ApplicationException
	 *             applicative exception
	 * @throws SystemException
	 *             technical exception
	 */
	List<Meal> getMealsFromCooker(String cooker) throws ApplicationException, SystemException;

	/**
	 * To save a meal
	 * 
	 * @param name
	 *            the name of meal
	 * @param cooker
	 *            the cooker
	 * @return the id in database
	 * 
	 * @throws ApplicationException
	 *             applicative exception
	 * @throws SystemException
	 *             technical exception
	 */
	String saveMealsFromCooker(String name, String cooker) throws ApplicationException, SystemException;
}
