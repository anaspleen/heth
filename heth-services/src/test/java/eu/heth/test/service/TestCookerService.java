/**
 * 
 */
package eu.heth.test.service;

import org.junit.Assert;
import org.junit.Test;

import eu.heth.bean.Cooker;
import eu.heth.exception.ApplicationException;
import eu.heth.exception.SystemException;
import eu.heth.test.HethCommonTestCase;

/**
 * @author tomey
 *
 */
public class TestCookerService extends HethCommonTestCase {

	private static final String COOK_NAME_BEGIN = "cook";

	public TestCookerService() throws Exception {
		super();

		System.out.println("Drop cookers");
		getCookerEntityRepository().deleteAll();
	}

	@Test
	public void testFindByNickname() throws Exception {

		String nickname = "yoda";

		// insert meals
		for (int i = 0; i < 4; i++) {
			generateCookers(i, nickname);
		}

		// check
		Cooker cooker = getCookerService().getCookerByNickname(nickname);
		Assert.assertNull(cooker);
		cooker = getCookerService().getCookerByNickname(nickname + "1");
		Assert.assertNotNull(cooker);

		// TODO more checks
	}

	/**
	 * Generate meals
	 * 
	 * @param i
	 *            comp
	 * @param cooker
	 *            the cooker
	 */
	private void generateCookers(int i, String nickname) {
		try {
			String nick = nickname + i;
			getCookerService().saveCooker(nick, nick + "@heth.eu");
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}
}
