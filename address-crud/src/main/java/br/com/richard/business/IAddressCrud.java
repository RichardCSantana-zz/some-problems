/**
 * 
 */
package br.com.richard.business;

import org.springframework.stereotype.Component;

import br.com.richard.model.Address;
import br.com.richard.model.IAddress;

/**
 * @author richard
 *
 */
@Component
public interface IAddressCrud {

	void save(Address address);

	void delete(Long id);

	void edit(Long id, Address address);

	IAddress findById(Long id);

	Iterable<Address> findAll();

}
