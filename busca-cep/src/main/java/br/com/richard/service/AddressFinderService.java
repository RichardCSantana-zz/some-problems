/**
 * 
 */
package br.com.richard.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.richard.business.IAddressFinder;
import br.com.richard.model.Address;

/**
 * @author richard
 *
 */
@Component
public class AddressFinderService implements IAddressFinderService {

	private static final Logger log = LogManager
			.getLogger(AddressFinderService.class);

	@Autowired
	private IAddressFinder addressFinder;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.richard.service.IServiceAddressFinder#findByCEP(java.lang.String)
	 */
	@Override
	public @ResponseBody Address findByCEP(@RequestBody String cep) {
		log.info(String.format("acao=procurar-cep,cep=%s", cep));
		return addressFinder.findByCEP(cep);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody String handle(IllegalArgumentException ex) {
		log.error(String.format("erro=procurar-cep,mensagem=%s", ex
				.getStackTrace().toString()));
		return ex.getMessage();
	}
}
