/**
 * 
 */
package eu.heth.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
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
	private Long id;

	/** the name */
	private String name;

	/** the cooker */
	@Indexed(unique = true)
	private String cooker;

	/**
	 * Default const
	 */
	public MealEntity() {
		// NTD
	}

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
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
