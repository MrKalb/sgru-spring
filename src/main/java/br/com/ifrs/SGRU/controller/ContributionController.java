package br.com.ifrs.SGRU.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifrs.SGRU.dto.ContributionsDTO;
import br.com.ifrs.SGRU.service.ContributionService;

@RestController
public class ContributionController {

	@Autowired
	private ContributionService service; 
	
	@PostMapping("/contribution")
	@PreAuthorize("hasRole('ROLE_MANAGERS')")
	public ResponseEntity<?> createContribution(@RequestBody ContributionsDTO contribution) {
		return ResponseEntity.ok(service.createContribution(contribution));
	}
	
	@GetMapping("/contribution")
	@PreAuthorize("hasRole('ROLE_MANAGERS')")
	public ResponseEntity<?> listContribution(@RequestParam(value="cpf",required=false) String cpf, @RequestParam(value="registration",required=false) String registration) {
		return ResponseEntity.ok(service.listContribution(cpf,registration));	
	}
	
	@PutMapping("/contribution")
	@PreAuthorize("hasRole('ROLE_MANAGERS')")
	public ResponseEntity<?> updateContribution(@RequestBody ContributionsDTO contribution) {
		return ResponseEntity.ok(service.updateContribution(contribution));
	}
	
	@GetMapping("/query/contribution")
	public ResponseEntity<?> getAll(@RequestParam(value="paid",required=false) String paid) {
		return ResponseEntity.ok(service.getAll(paid));
	}
	
	
	
	
}
