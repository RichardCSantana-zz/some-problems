package br.com.richard.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.richard.model.Address;

/**
 * @author richard
 *
 */
@RestController
public interface IAddressFinderService {

	@RequestMapping("/buscacep")
	@ResponseBody
	Address findByCEP(@RequestParam(value = "cep") String cep);

}
