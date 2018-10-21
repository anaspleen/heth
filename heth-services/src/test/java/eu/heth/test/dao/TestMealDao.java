/**
 * 
 */
package eu.heth.test.dao;

import org.junit.Test;

import eu.heth.entity.MealEntity;
import eu.heth.test.HethCommonTestCase;

/**
 * test of dao.
 *
 * @author thomas
 */
public class TestMealDao extends HethCommonTestCase {

	/**
	 * Instantiates a new test search service.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public TestMealDao() throws Exception {
		super();
	}

	@Test
	public void testInsertAndAddHistory() throws Exception {
		MealEntity meal = createMeal();
		String uid = getMealDao().saveOneDocument(meal);
		System.out.println(uid);

		// get it
		// Log log = getLogDao().findById(uid);
		// Assert.assertNotNull(log);
		// System.out.println(log.toJSONObject());
		// // no history
		// Assert.assertEquals(0, log.getHistories().size());
		//
		// Document added = new Document();
		// added.append("test", 1);
		//
		// // add one
		// Bson up = Updates.addToSet("histories", added);
		// getLogDao().update(log.getId().toString(), up);
		//
		// // get log
		// Log logE = getLogDao().findById(uid);
		// Assert.assertEquals(uid, logE.getId());
		// System.out.println(logE.toJSONObject());
		// Assert.assertNotNull(logE.getEquipmentIp());
		// Assert.assertNotNull(logE.getTimeStamp());
		// // history
		// Assert.assertEquals(1, logE.getHistories().size());
	}

	private MealEntity createMeal() {
		MealEntity meal = new MealEntity();

		meal.setCooker("tdurand");
		meal.setName("Gigot d'agneau");

		return meal;
	}
}
