/**
 * 
 */
package br.com.richard.business;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	private static final Logger log = LogManager.getLogger(AddressCrud.class);

	@Autowired
	private IAddressRepository repository;

	@Autowired
	private ICEPServiceConsumer cepServiceConsumer;

	@Autowired
	private IAddressComparator addressComparator;

	@Override
	public void save(Address address) {
		log.info(String.format("ocorrencia=salvando-endereco,endereco=%s",
				address));
		validaCEP(address);
		repository.save(address);
	}

	@Override
	public void delete(Long id) {
		log.info(String.format("ocorrencia=salvando-endereco,id=%s", id));
		repository.delete(id);
	}

	@Override
	public void edit(Long id, Address address) {
		log.info(String.format(
				"ocorrencia=editando-endereco,id=%s,endereco-atualizado=%s",
				id, address));
		validaCEP(address);
		Address result = repository.findOne(id);
		result.copyProperties(address);
		repository.save(result);
	}

	@Override
	public IAddress findById(Long id) {
		log.info(String.format("ocorrencia=buscando-endereco,id=%s", id));
		return repository.findOne(id);
	}

	@Override
	public Iterable<Address> findAll() {
		log.info("ocorrencia=buscando-enderecos");
		return repository.findAll();
	}

	private void validaCEP(IAddress address) {
		AddressDTO addressByCEP = cepServiceConsumer.getAddressByCEP(address
				.getZipcode());
		boolean compare = addressComparator.compare(address, addressByCEP);
		if (!compare) {
			throw new IllegalArgumentException(
					"O endereço informado não corresponde ao CEP informado");
		}
	}

}
