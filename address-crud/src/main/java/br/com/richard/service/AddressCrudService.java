/**
 * 
 */
package br.com.richard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.richard.business.IAddressCrud;
import br.com.richard.model.Address;
import br.com.richard.model.IAddress;

/**
 * @author richard
 *
 */
@Component
public class AddressCrudService implements IAddressCrudService {

	@Autowired
	private IAddressCrud addressCrud;

	@Override
	public void save(Address address) {
		addressCrud.save(address);
	}

	@Override
	public void delete(Long id) {
		addressCrud.delete(id);
	}

	@Override
	public void edit(Long id, Address address) {
		addressCrud.save(address);
	}

	@Override
	public IAddress findById(Long id) {
		return addressCrud.findById(id);
	}

	@Override
	public Iterable<Address> findAll() {
		return addressCrud.findAll();
	}

}
