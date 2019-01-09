/**
 * 
 */
package eu.heth.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The meal entity
 * 
 * @author tomey
 *
 */
@Document(collection = "meal")
public class MealEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** id in database */
	@Id
	private String id;

	/** the name */
	@Indexed(unique = true)
	private String name;

	/** the cooker */
	private String cooker;

	/** the gps location */
	private GeoJsonPoint location;

	/** the gps radius */
	private int radius;

	/**
	 * Default const
	 */
	public MealEntity() {
		// NTD
	}

	/**
	 * Const with datas
	 * 
	 * @param name
	 *            the name
	 * @param cooker
	 *            the login cooker
	 */
	public MealEntity(String name, String cooker) {
		// super();
		this.name = name;
		this.cooker = cooker;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the cooker
	 */
	public String getCooker() {
		return cooker;
	}

	/**
	 * @param cooker
	 *            the cooker to set
	 */
	public void setCooker(String cooker) {
		this.cooker = cooker;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the location
	 */
	public GeoJsonPoint getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(GeoJsonPoint location) {
		this.location = location;
	}

	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * @param radius
	 *            the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MealEntity [id=" + id + ", name=" + name + ", cooker=" + cooker + "]";
	}
}
