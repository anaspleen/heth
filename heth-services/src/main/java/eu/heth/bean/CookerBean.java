/**
 * 
 */
package eu.heth.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Impl of Cooker
 * 
 * @author tomey
 *
 */
public class CookerBean extends UserBean implements Cooker {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** the meals */
	private List<Meal> meals;

	/**
	 * Default const
	 */
	public CookerBean() {
		super();
		this.meals = new ArrayList<Meal>();
	}

	/**
	 * Default const
	 * 
	 * @param nickname
	 *            the nickname
	 * @param email
	 *            the email
	 */
	public CookerBean(String nickname, String email) {
		super(nickname, email);
		this.meals = new ArrayList<Meal>();
	}

	/**
	 * @return the meals
	 */
	public List<Meal> getMeals() {
		return meals;
	}

	/**
	 * @param meals
	 *            the meals to set
	 */
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	/**
	 * @param meal
	 *            the meal to add
	 */
	public void addMeal(Meal meal) {
		this.meals.add(meal);
	}
}
