/**
 * 
 */
package br.com.richard.external;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.richard.external.model.AddressDTO;

/**
 * @author richard
 *
 */
@Component
public class CEPServiceConsumer implements ICEPServiceConsumer {

	/* (non-Javadoc)
	 * @see br.com.richard.external.ICEPServiceConsumer#getAddressByCEP(java.lang.String)
	 */
	@Override
	public AddressDTO getAddressByCEP(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		AddressDTO address = restTemplate.postForObject(
				"http://localhost:8080/buscacep", cep, AddressDTO.class);
		return address;
	}
}
