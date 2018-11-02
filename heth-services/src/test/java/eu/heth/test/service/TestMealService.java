/**
 * 
 */
package eu.heth.test.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import eu.heth.bean.Meal;
import eu.heth.exception.ApplicationException;
import eu.heth.exception.SystemException;
import eu.heth.test.HethCommonTestCase;

/**
 * @author tomey
 *
 */
public class TestMealService extends HethCommonTestCase {

	private static final String COOK_NAME_BEGIN = "cook";

	public TestMealService() throws Exception {
		super();

		System.out.println("Drop meals");
		getMealEntityRepository().deleteAll();
	}

	@Test
	public void testInsertAndAddHistory() throws Exception {
		// TODO
		getMealService().getMealsFromCooker("testFFF");
	}

	@Test
	public void testFindByCooker() throws Exception {

		String cooker = "testFFF";

		// insert meals
		for (int i = 0; i < 4; i++) {
			generateMeals(i, cooker);
		}

		// check
		List<Meal> meals = getMealService().getMealsFromCooker(cooker);
		System.out.println(meals);
		Assert.assertEquals(4, meals.size());

		// check it
		for (Meal meal : meals) {
			Assert.assertTrue(meal.getName().startsWith(COOK_NAME_BEGIN));
		}

		meals = getMealService().getMealsFromCooker("bid");
		System.out.println(meals);
		Assert.assertEquals(0, meals.size());
	}

	/**
	 * Generate meals
	 * 
	 * @param i
	 *            comp
	 * @param cooker
	 *            the cooker
	 */
	private void generateMeals(int i, String cooker) {
		try {
			getMealService().saveMealsFromCooker(COOK_NAME_BEGIN + i, cooker);
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}
}
