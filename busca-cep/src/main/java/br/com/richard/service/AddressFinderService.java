/**
 * 
 */
package br.com.richard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

	@Autowired
	private IAddressFinder addressFinder;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.richard.service.IServiceAddressFinder#findByCEP(java.lang.String)
	 */
	@Override
	public Address findByCEP(String cep) {
		return addressFinder.findByCEP(cep);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody String handle(IllegalArgumentException ex) {
		return ex.getMessage();
	}

}
