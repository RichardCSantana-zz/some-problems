package br.com.richard.service;

import org.springframework.web.bind.annotation.RestController;

import br.com.richard.model.Address;

@RestController
public interface IAddressService {

	public abstract void save(Address address);

	public abstract void delete(Long id);

	public abstract void edit(Address address);

	public abstract void findById(Long id);

}