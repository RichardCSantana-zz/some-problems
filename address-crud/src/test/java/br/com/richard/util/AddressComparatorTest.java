package br.com.richard.util;

import org.junit.Assert;
import org.junit.Test;

import br.com.richard.model.Address;
import br.com.richard.model.IAddress;

/**
 * @Author richard
 */
public class AddressComparatorTest {

	@Test
	public void normalCase() {
		IAddress addressOne = new Address("Rua", "Bairro", "cidade", "estado",
				"01234567", "1", 2);
		IAddress addressTwo = new Address("Rua", "Bairro", "cidade", "estado",
				"01234567", null, 5);
		IAddressComparator addressComparator = new AddressComparator();
		boolean result = addressComparator.compare(addressOne, addressTwo);
		Assert.assertTrue(result);
	}

	@Test
	public void distinctAddressCase() {
		IAddress addressOne = new Address("Rua", "Bairro", "cidade", "estadio",
				"01234567", null, 3);
		IAddress addressTwo = new Address("Rua", "Bairro", "cidade", "estado",
				"01234567", "6", 10);
		IAddressComparator addressComparator = new AddressComparator();
		boolean result = addressComparator.compare(addressOne, addressTwo);
		Assert.assertFalse(result);
	}

	@Test
	public void nullAddressCase() {
		IAddress addressOne = new Address("Rua", "Bairro", "cidade", "estadio",
				"01234567", "2", 11);
		IAddressComparator addressComparator = new AddressComparator();
		boolean result = addressComparator.compare(addressOne, null);
		Assert.assertFalse(result);
	}

	@Test
	public void nullPropertyCase() {
		IAddress addressOne = new Address("Rua", "Bairro", "cidade", "estadio",
				"01234567", "3", 1);
		IAddress addressTwo = new Address("Rua", "Bairro", null, "estado",
				"01234567", "2", 1);
		IAddressComparator addressComparator = new AddressComparator();
		boolean result = addressComparator.compare(addressOne, addressTwo);
		Assert.assertFalse(result);
	}
}
