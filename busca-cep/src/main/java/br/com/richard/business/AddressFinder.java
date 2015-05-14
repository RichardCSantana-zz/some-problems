/**
 * 
 */
package br.com.richard.business;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import br.com.richard.external.IExternalAddressFinder;
import br.com.richard.external.mock.ExternalAddressFinderMock;
import br.com.richard.model.Address;

/**
 * @author richard
 *
 */
@Component
public class AddressFinder implements IAddressFinder {

	private static final Logger log = LogManager.getLogger(AddressFinder.class);

	private IExternalAddressFinder addressFinder;

	public AddressFinder(IExternalAddressFinder addressFinder) {
		this.addressFinder = addressFinder;
	}

	public AddressFinder() {
		this.addressFinder = new ExternalAddressFinderMock();
	}

	@Override
	public Address findByCEP(String cep) {
		if (!isValid(cep)) {
			log.error(String.format("ocorrencia=cep-invalido,cep=", cep));
			throw new IllegalArgumentException("CEP inválido");
		}
		Address result = null;
		Integer iteration = 0;
		do {
			result = addressFinder.getAddressByCEP(cep);
			if (result == null) {
				iteration++;
				cep = reviseCEP(cep, iteration);
			}
			if (iteration == 8) {
				throw new IllegalArgumentException(
						"Nenhum endereço com esse cep foi encontrado");
			}
		} while (result == null);
		log.info(String.format(
				"ocorrencia=encontrado-endereco,cep=%s,endereco=%s", cep,
				result));
		return result;
	}

	private boolean isValid(String cep) {
		if (cep == null || cep.length() != 8) {
			return false;
		} else {
			Pattern pattern = Pattern.compile("\\d{8}");
			Matcher matcher = pattern.matcher(cep);
			return matcher.find();
		}
	}

	private String reviseCEP(String cep, Integer iteration) {
		char[] cepCharArray = cep.toCharArray();
		int length = cepCharArray.length;
		cepCharArray[length - iteration] = '0';
		String result = new String(cepCharArray);
		return result;
	}
}
