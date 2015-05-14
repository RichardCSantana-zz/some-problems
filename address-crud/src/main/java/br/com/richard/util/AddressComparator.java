package br.com.richard.util;

import org.springframework.stereotype.Component;

import br.com.richard.model.Address;
import br.com.richard.model.IAddress;

/**
 * Classe criada para evitar sobreescrever o método equals do {@link Address}
 * por se tratar de uma entity
 * 
 * @author vrx_rsantana
 *
 */
@Component
public class AddressComparator implements IAddressComparator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.richard.util.IAddressComparator#compare(br.com.richard.model.IAddress
	 * , br.com.richard.model.IAddress)
	 */
	@Override
	public boolean compare(IAddress first, IAddress second) {
		if (first == null || second == null) {
			return false;
		}
		return compareNormalizedStrings(first.getCity(), second.getCity())
				&& compareNormalizedStrings(first.getState(), second.getState())
				&& compareNormalizedStrings(first.getStreet(),
						second.getStreet());
	}

	private boolean compareNormalizedStrings(String first, String second) {
		if (first == null || second == null) {
			return false;
		}
		return first.trim().equalsIgnoreCase(second.trim());
	}

}
