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
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

import eu.heth.bean.Cooker;
import eu.heth.dao.repositories.CookerEntityRepository;
import eu.heth.entity.CookerEntity;
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

	/** the cooker */
	@Autowired
	private CookerEntityRepository cookerEntityRepository;

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

		CookerEntity entity = getCookerEntityRepository().findFirstByNickname(nickname);
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

		CookerEntity entityToSave = new CookerEntity(nickname, email);
		GeoJsonPoint point = new GeoJsonPoint(5.4, 45.2);
		entityToSave.setLocation(point);
		entityToSave.setRadius(1000);

		CookerEntity entity = getCookerEntityRepository().save(entityToSave);
		return entity.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.service.CookerService#searchCookers(int, int, int)
	 */
	@Override
	public List<Cooker> searchCookers(int longitude, int latitude, int radius)
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

		// TODO
		// List<CookerEntity> entities =
		// mealEntityRepository.findByCooker(cooker);
		//
		// if (entities != null && entities.size() > 0) {
		// for (CookerEntity entity : entities) {
		// cookers.add(CookerHelper.toBean(entity));
		// }
		// }

		return cookers;
	}

	/**
	 * @return the cookerEntityRepository
	 */
	public CookerEntityRepository getCookerEntityRepository() {
		return cookerEntityRepository;
	}

	/**
	 * @param cookerEntityRepository
	 *            the cookerEntityRepository to set
	 */
	public void setCookerEntityRepository(CookerEntityRepository cookerEntityRepository) {
		this.cookerEntityRepository = cookerEntityRepository;
	}
}
