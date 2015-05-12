/**
 * 
 */
package br.com.richard.external.model;

import br.com.richard.model.IAddress;

/**
 * @author richard
 *
 */
public class AddressDTO implements IAddress {

	private String street;
	private String neighborhood;
	private String city;
	private String state;
	private String zipcode;

	public AddressDTO() {
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
