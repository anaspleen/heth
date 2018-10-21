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
		// TODO Auto-generated constructor stub
	}

	
	@Test
	public void testInsertAndAddHistory() throws Exception {
		
		getMealService().getMealsFromCooker("test");
	}
}
