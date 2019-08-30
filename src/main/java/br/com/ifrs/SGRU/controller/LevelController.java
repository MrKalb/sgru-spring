package br.com.ifrs.SGRU.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifrs.SGRU.entities.LevelEntity;
import br.com.ifrs.SGRU.repository.LevelRepository;

@RestController
public class LevelController {

	@Autowired
	private LevelRepository levelRepository; 
	
	
	@GetMapping("/level")
	public ResponseEntity<List<LevelEntity>> getLevels() {
		return ResponseEntity.ok(this.levelRepository.findAll());
	}
	
	
}
