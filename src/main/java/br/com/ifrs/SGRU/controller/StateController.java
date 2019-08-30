package br.com.ifrs.SGRU.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifrs.SGRU.entities.StateEntity;
import br.com.ifrs.SGRU.repository.StateEntityRepository;

@RestController
public class StateController {

	
	@Autowired
	private StateEntityRepository stateRepository;
	
	@GetMapping("/state")
	@PreAuthorize("hasRole('ROLE_MANAGERS')")
	public List<StateEntity> getAll(){
		return this.stateRepository.findAll();
	}
}
