/**
 * 
 */
package br.com.richard.business;

import br.com.richard.external.IExternalAddressFinder;
import br.com.richard.model.Address;

/**
 * @author richard
 *
 */
public class AddressFinder implements IAddressFinder {

	private IExternalAddressFinder addressFinder;

	public AddressFinder(IExternalAddressFinder addressFinder) {
		this.addressFinder = addressFinder;
	}

	public AddressFinder() {
	}

	@Override
	public Address findByCEP(String cep) {
		Address result = addressFinder.getAddressByCEP(cep);
		return result;
	}

}
