/**
 * 
 */
package br.com.richard.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author richard
 *
 */
@Entity
public class Address implements IAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String street;
	private String neighborhood;
	private String city;
	private String state;
	private String zipcode;

	public Address() {

	}

	public Address(String street, String neighborhood, String city,
			String state, String zipcode) {
		this.street = street;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.richard.model.IAddress#getStreet()
	 */
	@Override
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.richard.model.IAddress#getNeighborhood()
	 */
	@Override
	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.richard.model.IAddress#getCity()
	 */
	@Override
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.richard.model.IAddress#getState()
	 */
	@Override
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.richard.model.IAddress#getZipcode()
	 */
	@Override
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void copyProperties(IAddress address) {
		this.setCity(address.getCity());
		this.setNeighborhood(address.getNeighborhood());
		this.setState(address.getState());
		this.setStreet(address.getStreet());
		this.setZipcode(address.getZipcode());
	}
}
