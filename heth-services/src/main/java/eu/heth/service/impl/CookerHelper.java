/**
 * 
 */
package eu.heth.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import eu.heth.bean.CookerBean;
import eu.heth.entity.UserEntity;

/**
 * Utils class to manage group beans / entities
 * 
 * @author tomey
 *
 */
public final class CookerHelper {

	/** logger */
	private static final Logger LOG = LoggerFactory.getLogger(CookerHelper.class);

	/**
	 * Default const
	 */
	private CookerHelper() {
		// RAF
	}

	/**
	 * To transform entity to bean
	 * 
	 * @param entity
	 *            entity
	 * @return bean
	 */
	public static CookerBean toBean(UserEntity entity) {

		CookerBean bean = null;

		if (entity != null) {
			try {
				bean = new CookerBean();
				BeanUtils.copyProperties(entity, bean);

				// TODO all or not meals

			} catch (Exception e) {
				LOG.error("Error on creating cooker bean", e);
			}
		}

		return bean;
	}
}
