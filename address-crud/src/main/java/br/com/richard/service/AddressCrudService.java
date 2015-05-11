/**
 * 
 */
package br.com.richard.service;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.richard.repository.AddressRepository;

/**
 * @author vrx_rsantana
 *
 */
@Component
public class AddressCrudService implements IAddressService {

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
	public void edit(Address address) {
		repository.merge(address);
	}

	@Override
	public void findById(Long id) {
		repository.findById(id);
	}

}
