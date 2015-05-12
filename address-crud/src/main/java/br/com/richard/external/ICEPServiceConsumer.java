package br.com.richard.external;

import br.com.richard.external.model.AddressDTO;

public interface ICEPServiceConsumer {

	AddressDTO getAddressByCEP(String cep);

}