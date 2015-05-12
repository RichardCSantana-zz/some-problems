/**
 * 
 */
package br.com.richard.business;

import br.com.richard.model.Address;
import br.com.richard.model.IAddress;

/**
 * @author richard
 *
 */
public interface IAddressCrud {

	void save(Address address);

	void delete(Long id);

	void edit(Long id, IAddress address);

	IAddress findById(Long id);

	Iterable<Address> findAll();

}
