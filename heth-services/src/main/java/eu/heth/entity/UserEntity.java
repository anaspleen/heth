/**
 * 
 */
package eu.heth.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import eu.heth.bean.UserRole;

/**
 * The user entity
 * 
 * @author tomey
 *
 */
@Document(collection = "user")
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** id in database */
	@Id
	private String id;

	/** the email */
	@Indexed(unique = true)
	private String email;

	/** the identification */
	@Indexed(unique = true)
	private String nickname;

	/** the name */
	private String firstname; // prénom
	private String lastname; // nom de famille

	/** the gps location */
	private GeoJsonPoint location;

	/** the gps radius */
	private int radius;

	/** the roles */
	private List<UserRole> roles;

	/**
	 * Default const
	 */
	public UserEntity() {
		// NTD
		this.roles = new ArrayList<UserRole>();
	}

	/**
	 * Const with datas
	 * 
	 * @param nickname
	 *            the nickname
	 * @param email
	 *            the email
	 */
	public UserEntity(String nickname, String email) {
		this.roles = new ArrayList<UserRole>();
		this.nickname = nickname;
		this.email = email;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
		return "MealEntity [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname
	 *            the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the roles
	 */
	public List<UserRole> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	/**
	 * @param role
	 *            the role to add
	 */
	public void addRole(UserRole role) {
		this.roles.add(role);
	}
}
