/**
 * 
 */
package br.com.richard.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.richard.model.Address;

/**
 * @author vrx_rsantana
 *
 */
public interface AddressRepository extends CrudRepository<Address, Long> {

}
