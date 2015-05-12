package br.com.richard.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.richard.model.Address;
import br.com.richard.model.IAddress;

@RestController
@RequestMapping(value = "/address")
public interface IAddressCrudService {

	@RequestMapping(method = RequestMethod.POST)
	void save(@RequestBody Address address);

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	void delete(@PathVariable Long id);

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	void edit(@PathVariable Long id, @RequestBody Address address);

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	IAddress findById(@PathVariable Long id);

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	Iterable<Address> findAll();

}