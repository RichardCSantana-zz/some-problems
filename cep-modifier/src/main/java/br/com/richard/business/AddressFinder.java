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
		Address result = null;
		Integer iteration = 1;
		do {
			result = addressFinder.getAddressByCEP(cep);
			if (result == null) {
				cep = reviseCEP(cep, iteration);
				iteration++;
			}
		} while (result == null);
		return result;
	}

	private String reviseCEP(String cep, Integer iteration) {
		char[] cepCharArray = cep.toCharArray();
		int length = cepCharArray.length;
		cepCharArray[length - iteration] = '0';
		String result = new String(cepCharArray);
		return result;
	}
}
