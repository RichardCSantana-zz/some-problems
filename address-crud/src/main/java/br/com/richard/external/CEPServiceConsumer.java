/**
 * 
 */
package br.com.richard.external;

import org.hibernate.mapping.Map;
import org.springframework.web.client.RestTemplate;

import br.com.richard.model.AddressConsumed;

/**
 * @author vrx_rsantana
 *
 */
public class CEPServiceConsumer {

	public AddressConsumed getAddressByCEP(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> cep = new HashMap<>();
		cep.put("cep", cep);
		AddressConsumed address = restTemplate.postForObject(
				"http://localhost:8080/buscacep", AddressConsumed.class, cep);
		return address;
	}
}
