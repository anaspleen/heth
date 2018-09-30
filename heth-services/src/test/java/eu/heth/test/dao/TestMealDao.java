/**
 * 
 */
package eu.heth.test.dao;

import org.bson.Document;
import org.junit.Test;

/**
 * test of dao.
 *
 * @author thomas
 */
public class TestMealDao extends CapCommonTestCase {

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
		Document doc = createMeal();
		String uid = getMealDao().saveOneDocument(doc);
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

	private Document createMeal() {
		Document doc = new Document();

		doc.append("cooker", "tdurand");
		doc.append("meal", "gigot d'agneau");

		return doc;
	}
}
