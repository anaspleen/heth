/**
 * 
 */
package eu.heth.test.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import eu.heth.bean.Cooker;
import eu.heth.bean.UserRole;
import eu.heth.exception.ApplicationException;
import eu.heth.exception.SystemException;
import eu.heth.test.HethCommonTestCase;

/**
 * @author tomey
 *
 */
public class TestCookerService extends HethCommonTestCase {

	// Chemin de Provinière, 38470 Vinay, France
	private static final double longitudeX = 5.4;
	private static final double latitudeY = 45.2;
	// radius in meter
	private static final double radius = 1000;

	// Chemin de Pré Marot, 38470 Beaulieu (environ 300/400m l'un de l'autre)
	// 5.402140617370605 45.199495489950095
	private static final double preMarotLongitudeX = 5.402140617370605;
	private static final double preMarotLatitudeY = 45.199495489950095;

	public TestCookerService() throws Exception {
		super();

		// DB must have this index
		// db.user.createIndex({location:"2dsphere"})

		System.out.println("Drop cookers");
		getUserEntityRepository().deleteAll();
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
		Assert.assertEquals(1, cooker.getRoles().size());
		Assert.assertEquals(UserRole.cooker, cooker.getRoles().get(0));
		// TODO more checks

		// TODO modify it
	}

	@Test
	public void testFindByLocation() throws Exception {

		String nickname = "yoda";

		// insert meals
		for (int i = 0; i < 4; i++) {
			generateCookers(i, nickname);
		}

		// search them
		List<Cooker> cookersFound = getCookerService().searchCookersByLocation(longitudeX, latitudeY, radius);
		Assert.assertEquals(4, cookersFound.size());

		// all
		cookersFound = getCookerService().searchCookersByLocation(5.3999912, latitudeY, radius);
		Assert.assertEquals(4, cookersFound.size());

		// none of them because of 0
		cookersFound = getCookerService().searchCookersByLocation(5.3, latitudeY, 0);
		Assert.assertEquals(0, cookersFound.size());

		// paris : 48.862725 / 2.287592
		// none of them
		cookersFound = getCookerService().searchCookersByLocation(2.287592, 48.862725, radius);
		Assert.assertEquals(0, cookersFound.size());

		// near (300/400 m), so 1000m is good
		cookersFound = getCookerService().searchCookersByLocation(preMarotLongitudeX, preMarotLatitudeY, radius);
		Assert.assertEquals(4, cookersFound.size());

		// less than 100m
		cookersFound = getCookerService().searchCookersByLocation(preMarotLongitudeX, preMarotLatitudeY, 100);
		Assert.assertEquals(0, cookersFound.size());

		// less than 400m
		cookersFound = getCookerService().searchCookersByLocation(preMarotLongitudeX, preMarotLatitudeY, 400);
		Assert.assertEquals(4, cookersFound.size());
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
