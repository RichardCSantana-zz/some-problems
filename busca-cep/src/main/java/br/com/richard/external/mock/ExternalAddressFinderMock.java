/**
 * 
 */
package br.com.richard.external.mock;

import java.util.HashMap;
import java.util.Map;

import br.com.richard.external.IExternalAddressFinder;
import br.com.richard.model.Address;

/**
 * 
 * Classe criada para o mock do IExternalAddressFinder em tempo de execução
 * 
 * @author richard
 *
 */
public class ExternalAddressFinderMock implements IExternalAddressFinder {

	private Map<String, Address> ceps;

	public ExternalAddressFinderMock() {
		ceps = new HashMap<>();
		ceps.put("03573120", new Address("Rua entre-folhas",
				"Jardim Arize", "São Paulo", "SP", "03573120"));
		ceps.put("69093310", new Address("Rua São Lucas",
				"Colônia Santo Antônio", "Manaus", "AM", "69093310"));
		ceps.put("93537050", new Address(
				"Rua Vereador Carlos Emílio Kolling", "São Jorge",
				"Novo Hamburgo", "RS", "93537050"));
		ceps.put("24743590", new Address("Rua Alberto Nemer",
				"Jóquei Clube", "São Gonçalo", "RJ", "24743590"));
		ceps.put("68901500", new Address("Avenida dos Navegantes",
				"Santa Inês", "Macapá", "AP", "68901500"));
		ceps.put("17022480", new Address("Rua dos Mecânicos",
				"Núcleo Residencial Edison Bastos Gasparini", "Bauru", "SP",
				"17022480"));
		ceps.put("68925973", new Address(
				"Vila do Portuário do Igarapé da Fortaleza, s/n", "Central",
				"Santana", "AP", "68925973"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.richard.external.IExternalAddressFinder#getAddressByCEP(java.lang
	 * .String)
	 */
	@Override
	public Address getAddressByCEP(String cep) {
		return ceps.get(cep);
	}

}
