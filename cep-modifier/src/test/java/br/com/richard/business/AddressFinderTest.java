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
		final String cep = "01234567";
		final Address expected = new Address("rua", "bairro", "cidade",
				"estado", cep);
		IExternalAddressFinder addressFinder = Mockito
				.mock(IExternalAddressFinder.class);
		Mockito.when(addressFinder.getAddressByCEP(cep)).thenReturn(expected);
		IAddressFinder afs = new AddressFinder(addressFinder);
		Address actual = afs.findByCEP(cep);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void oneTurnCase() {
		final String cep = "01234560";
		final Address expected = new Address("rua", "bairro", "cidade",
				"estado", cep);
		IExternalAddressFinder addressFinder = Mockito
				.mock(IExternalAddressFinder.class);
		Mockito.when(addressFinder.getAddressByCEP(cep)).thenReturn(expected);
		IAddressFinder afs = new AddressFinder(addressFinder);
		Address actual = afs.findByCEP("01234567");
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void sixTurnsCase() {
		final String cep = "01000000";
		final Address expected = new Address("rua", "bairro", "cidade",
				"estado", cep);
		IExternalAddressFinder addressFinder = Mockito
				.mock(IExternalAddressFinder.class);
		Mockito.when(addressFinder.getAddressByCEP(cep)).thenReturn(expected);
		IAddressFinder afs = new AddressFinder(addressFinder);
		Address actual = afs.findByCEP("01234567");
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void noAddressFindCase() {
		IExternalAddressFinder addressFinder = Mockito
				.mock(IExternalAddressFinder.class);
		IAddressFinder afs = new AddressFinder(addressFinder);
		try {
			Address actual = afs.findByCEP("01234567");
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("Nenhum endereço com esse cep foi encontrado",
					e.getMessage());
			throw e;
		}
	}
}
