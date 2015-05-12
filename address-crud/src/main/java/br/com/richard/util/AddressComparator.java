package br.com.richard.util;

import org.springframework.stereotype.Component;

import br.com.richard.model.IAddress;

@Component
public class AddressComparator implements IAddressComparator {

	/* (non-Javadoc)
	 * @see br.com.richard.util.IAddressComparator#compare(br.com.richard.model.IAddress, br.com.richard.model.IAddress)
	 */
	@Override
	public boolean compare(IAddress first, IAddress second) {
		return compareNormalizedStrings(first.getCity(), second.getCity())
				&& compareNormalizedStrings(first.getNeighborhood(),
						second.getNeighborhood())
				&& compareNormalizedStrings(first.getState(), second.getState())
				&& compareNormalizedStrings(first.getStreet(),
						second.getStreet());
	}

	private boolean compareNormalizedStrings(String first, String second) {
		return first.trim().equalsIgnoreCase(second.trim());
	}

}
