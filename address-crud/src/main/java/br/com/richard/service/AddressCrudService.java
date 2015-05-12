/**
 * 
 */
package br.com.richard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.richard.model.Address;
import br.com.richard.repository.AddressRepository;

/**
 * @author richard
 *
 */
@Component
public class AddressCrudService implements IAddressCrudService {

	@Autowired
	private AddressRepository repository;

	@Override
	public void save(Address address) {
		repository.save(address);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

	@Override
	public void edit(Long id, Address address) {
		repository.save(address);
	}

	@Override
	public Address findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Iterable<Address> findAll() {
		return repository.findAll();
	}

}
