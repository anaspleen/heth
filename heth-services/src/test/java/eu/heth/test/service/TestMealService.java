/**
 * 
 */
package eu.heth.test.service;

import org.junit.Test;

import eu.heth.test.HethCommonTestCase;

/**
 * @author tomey
 *
 */
public class TestMealService extends HethCommonTestCase {

	public TestMealService() throws Exception {
		super();
	}

	@Test
	public void testInsertAndAddHistory() throws Exception {
		// TODO
		getMealService().getMealsFromCooker("testFFF");
	}
}
