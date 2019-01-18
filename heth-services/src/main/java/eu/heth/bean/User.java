/**
 * 
 */
package eu.heth.bean;

import java.util.List;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

/**
 * Represents a cooker
 * 
 * @author tomey
 *
 */
public interface User {

	/**
	 * 
	 * @return nickname of cooker
	 */
	String getNickname();

	/**
	 * 
	 * @return email of cooker
	 */
	String getEmail();

	/**
	 * 
	 * @return the firstname of cooker
	 */
	String getFirstname();

	/**
	 * 
	 * @return the lastname of cooker
	 */
	String getLastname();

	/**
	 * 
	 * @return the location
	 */
	GeoJsonPoint getLocation();

	/**
	 * 
	 * @return the radius of location
	 */
	int getRadius();

	/**
	 * 
	 * @return the roles
	 */
	List<UserRole> getRoles();
}
