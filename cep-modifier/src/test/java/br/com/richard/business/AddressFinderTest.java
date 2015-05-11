/**
 * 
 */
package br.com.richard.business;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.richard.external.IExternalAddressFinder;
import br.com.richard.model.Address;

/**
 * @author richard
 *
 */
public class AddressFinderTest {

	/**
	 * Test method for
	 * {@link br.com.richard.business.AddressFinder#findByCEP(java.lang.String)}
	 * .
	 */
	@Test
	public void normalCase() {
		Address expected = new Address("rua", "bairro", "cidade", "estado",
				"01234567");
		IExternalAddressFinder addressFinder = Mockito
				.mock(IExternalAddressFinder.class);
		Mockito.when(addressFinder.getAddressByCEP("01234567")).thenReturn(
				expected);
		IAddressFinder afs = new AddressFinder(addressFinder);
		Address actual = afs.findByCEP("01234567");
		Assert.assertEquals(expected, actual);
	}
}
