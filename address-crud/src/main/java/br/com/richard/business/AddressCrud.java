/**
 * 
 */
package br.com.richard.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.richard.external.ICEPServiceConsumer;
import br.com.richard.external.model.AddressDTO;
import br.com.richard.model.Address;
import br.com.richard.model.IAddress;
import br.com.richard.repository.IAddressRepository;
import br.com.richard.util.IAddressComparator;

/**
 * @author richard
 *
 */
@Component
public class AddressCrud implements IAddressCrud {

	private IAddressRepository repository;

	private ICEPServiceConsumer cepServiceConsumer;

	private IAddressComparator addressComparator;

	@Autowired
	public AddressCrud(IAddressRepository repository,
			ICEPServiceConsumer cepServiceConsumer,
			IAddressComparator addressComparator) {
		this.repository = repository;
		this.cepServiceConsumer = cepServiceConsumer;
		this.addressComparator = addressComparator;
	}

	@Override
	public void save(Address address) {
		AddressDTO addressByCEP = cepServiceConsumer.getAddressByCEP(address
				.getZipcode());
		boolean compare = addressComparator.compare(address, addressByCEP);
		if (!compare) {
			throw new IllegalArgumentException(
					"O endereço informado não corresponde ao CEP informado");
		}
		repository.save(address);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

	@Override
	public void edit(Long id, IAddress address) {
		Address result = repository.findOne(id);
		result.copyProperties(address);
		repository.save(result);
	}

	@Override
	public IAddress findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Iterable<Address> findAll() {
		return repository.findAll();
	}

}
