/**
 * 
 */
package br.com.richard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
	public void save(@RequestBody Address address) {
		addressCrud.save(address);
	}

	@Override
	public void delete(@PathVariable Long id) {
		addressCrud.delete(id);
	}

	@Override
	public void edit(@PathVariable Long id, @RequestBody Address address) {
		addressCrud.edit(id, address);
	}

	@Override
	public IAddress findById(@PathVariable Long id) {
		return addressCrud.findById(id);
	}

	@Override
	public Iterable<Address> findAll() {
		return addressCrud.findAll();
	}

}
