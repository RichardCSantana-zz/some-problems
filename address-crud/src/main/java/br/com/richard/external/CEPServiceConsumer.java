/**
 * 
 */
package br.com.richard.external;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.richard.external.model.AddressDTO;

/**
 * @author richard
 *
 */
@Component
public class CEPServiceConsumer implements ICEPServiceConsumer {

	private static final Logger log = LogManager
			.getLogger(CEPServiceConsumer.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.richard.external.ICEPServiceConsumer#getAddressByCEP(java.lang
	 * .String)
	 */
	@Override
	public AddressDTO getAddressByCEP(String cep) {
		log.info("ocorrencia=buscando-servico-validacao-cep");
		RestTemplate restTemplate = new RestTemplate();
		// TODO: adicionar configuração externa para guardar o endereço
		AddressDTO address = restTemplate.postForObject(
				"http://localhost:9000/buscacep", cep, AddressDTO.class);
		return address;
	}
}
