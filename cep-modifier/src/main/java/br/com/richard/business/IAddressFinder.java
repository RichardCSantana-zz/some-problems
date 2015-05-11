/**
 * 
 */
package br.com.richard.business;

import br.com.richard.model.Address;

/**
 * @author richard
 *
 */
public interface IAddressFinder {

	/**
	 * Método recebe um CEP e retorna um Endereço. Esse método possui uma
	 * peculiaridade, caso não exista um endereço correspondente ao CEP passado
	 * o método irá procurar um CEP semelhante que possua um endereço
	 * 
	 * @param cep
	 *            um CEP do qual se quer o endereço
	 * @return o endereço correpondente ao CEP ou a um CEP similar
	 */
	Address findByCEP(String cep);

}
