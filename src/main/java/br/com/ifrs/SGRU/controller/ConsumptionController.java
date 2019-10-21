package br.com.ifrs.SGRU.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifrs.SGRU.dto.ConsumptionDTO;
import br.com.ifrs.SGRU.entities.ConsumptionEntity;
import br.com.ifrs.SGRU.service.ConsumptionService;

@RestController
public class ConsumptionController {
	
	@Autowired
	private ConsumptionService service;
	
	@PostMapping("/consumption")
	@PreAuthorize("hasRole('ROLE_DEVELOPERS')")
	public ResponseEntity<?> createConsumption(@RequestBody ConsumptionDTO consumption) {
		return ResponseEntity.ok(this.service.createConsumption(consumption));
	}
	
	@PutMapping("/consumption")
	@PreAuthorize("hasRole('ROLE_DEVELOPERS')")
	public ResponseEntity<?> updateConsumption(@RequestBody ConsumptionDTO consumption) {	
		return ResponseEntity.ok(this.service.updateConsumption(consumption));
	}
	
	@GetMapping("/consumption")
	public ResponseEntity<?> listByPerson() {
		return ResponseEntity.ok(this.service.findByPerson()); 
	}
	
	@PreAuthorize("hasRole('ROLE_DEVELOPERS')")
	@GetMapping("/consumption/{id}")
	public ResponseEntity<?> listByConsumptionId(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(this.service.getById(id));
	}
	
	@GetMapping("/consumption/all")
	@PreAuthorize("hasRole('ROLE_MANAGERS')")
	public ResponseEntity<?> listAll() {
		return ResponseEntity.ok(this.service.listAll());
	}
	
	@GetMapping("/consumption/day")
	public ResponseEntity<List<ConsumptionEntity>> getConsumptionByDay(@RequestParam(value = "data") String data ){
		LocalDateTime newDate = LocalDateTime.parse(data);
		return ResponseEntity.ok(this.service.listByDate(newDate)); 
	}
	
	@DeleteMapping("/consumption")
	@PreAuthorize("hasRole('ROLE_DEVELOPERS')")
	public ResponseEntity<?> deleteConsumption(@RequestBody ConsumptionDTO consumption) {
		this.service.deleteConsumption(consumption);
		return ResponseEntity.ok().build();
	}
	
	
	
	
}
