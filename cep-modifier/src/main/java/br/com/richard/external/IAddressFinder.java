/**
 * 
 */
package br.com.richard.external;

import br.com.richard.model.Address;

/**
 * @author richard
 *
 */
public interface IAddressFinder {

	Address getAddressByCEP(String cep);

}
