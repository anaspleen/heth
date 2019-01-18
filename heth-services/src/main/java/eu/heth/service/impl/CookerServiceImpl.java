/**
 * 
 */
package eu.heth.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

import eu.heth.bean.Cooker;
import eu.heth.bean.UserRole;
import eu.heth.dao.repositories.UserEntityRepository;
import eu.heth.entity.UserEntity;
import eu.heth.exception.ApplicationException;
import eu.heth.exception.IdentifiedError;
import eu.heth.exception.SystemException;
import eu.heth.service.CookerService;

/**
 * Impl of service
 * 
 * @author tomey
 *
 */
@Service("cookerService")
public class CookerServiceImpl implements CookerService {

	/** logger */
	private static final Logger LOG = LoggerFactory.getLogger(CookerServiceImpl.class);

	/** the user */
	@Autowired
	private UserEntityRepository userEntityRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.service.CookerService#getCookerByNickname(java.lang.String)
	 */
	@Override
	public Cooker getCookerByNickname(String nickname) throws ApplicationException, SystemException {
		if (StringUtils.isEmpty(nickname)) {
			throw new SystemException("cooker.nickname.mandatory");
		}

		Cooker cooker = null;

		UserEntity entity = getUserEntityRepository().findFirstByNickname(nickname);
		if (entity != null) {
			cooker = CookerHelper.toBean(entity);
		}

		return cooker;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.service.CookerService#saveCooker(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public String saveCooker(String nickname, String email) throws ApplicationException, SystemException {
		LOG.debug("In saveCooker");

		// TODO check if nickname and email exists yet !

		UserEntity entityToSave = new UserEntity(nickname, email);
		GeoJsonPoint point = new GeoJsonPoint(5.4, 45.2);
		entityToSave.setLocation(point);
		entityToSave.setRadius(1000);
		entityToSave.addRole(UserRole.cooker);

		UserEntity entity = getUserEntityRepository().save(entityToSave);
		return entity.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.service.CookerService#searchCookersByLocation(double,
	 * double, double)
	 */
	@Override
	public List<Cooker> searchCookersByLocation(double longitude, double latitude, double radius)
			throws ApplicationException, SystemException {

		List<IdentifiedError> errors = new ArrayList<IdentifiedError>();

		// if (StringUtils.isEmpty(cooker)) {
		// errors.add(new IdentifiedError("error.meal.find.cooker.empty"));
		// }

		// if error, throw it
		if (errors.size() > 0) {
			throw new ApplicationException(Arrays.asList(errors));
		}

		List<Cooker> cookers = new ArrayList<Cooker>();

		// search cookers from radius in meter (so radius/1000) !
		// List<UserEntity> entities =
		// getUserEntityRepository().findByLocationNear(new Point(longitude,
		// latitude),
		// new Distance(radius / 1000, Metrics.KILOMETERS));
		List<UserEntity> entities = getUserEntityRepository().findByLocationNearAndRoles(new Point(longitude, latitude),
				new Distance(radius / 1000, Metrics.KILOMETERS), UserRole.cooker);

		if (entities != null && entities.size() > 0) {
			for (UserEntity entity : entities) {
				cookers.add(CookerHelper.toBean(entity));
			}
		}

		return cookers;
	}

	/**
	 * @return the cookerEntityRepository
	 */
	public UserEntityRepository getUserEntityRepository() {
		return userEntityRepository;
	}

	/**
	 * @param cookerEntityRepository
	 *            the cookerEntityRepository to set
	 */
	public void setUserEntityRepository(UserEntityRepository cookerEntityRepository) {
		this.userEntityRepository = cookerEntityRepository;
	}
}
