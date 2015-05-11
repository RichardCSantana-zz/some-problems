/**
 * 
 */
package br.com.richard.business;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.richard.external.IAddressFinder;
import br.com.richard.model.Address;

/**
 * @author richard
 *
 */
public class AddressFinderServiceTest {

	/**
	 * Test method for
	 * {@link br.com.richard.business.AddressFinderService#findByCEP(java.lang.String)}
	 * .
	 */
	@Test
	public void normalCase() {
		Address expected = new Address("rua", "bairro", "cidade", "estado",
				"01234567");
		IAddressFinder addressFinder = Mockito.mock(IAddressFinder.class);
		Mockito.when(addressFinder.getAddressByCEP("01234567")).thenReturn(
				expected);
		AddressFinderService afs = new AddressFinderService(addressFinder);
		Address actual = afs.findByCEP("01234567");
		Assert.assertEquals(expected, actual);
	}
}
