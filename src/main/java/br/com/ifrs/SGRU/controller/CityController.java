package br.com.ifrs.SGRU.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifrs.SGRU.entities.CityEntity;
import br.com.ifrs.SGRU.repository.CityEntityRepository;

@RestController
public class CityController {

	@Autowired
	private CityEntityRepository cityRepository; 
	
	@GetMapping("/city")
	@PreAuthorize("hasRole('ROLE_MANAGERS')")
	public List<CityEntity> getAll() {
		return this.cityRepository.findAll();
	}
}
