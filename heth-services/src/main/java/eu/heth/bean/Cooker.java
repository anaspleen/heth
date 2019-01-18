/**
 * 
 */
package eu.heth.bean;

import java.util.List;

/**
 * Represent a Cooker
 * 
 * @author tcaiati
 *
 */
public interface Cooker extends User {

	/**
	 * 
	 * @return all meals for this cooker
	 */
	List<Meal> getMeals();
}
