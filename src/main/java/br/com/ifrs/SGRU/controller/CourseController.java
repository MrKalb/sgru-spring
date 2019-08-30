package br.com.ifrs.SGRU.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifrs.SGRU.dto.CourseDTO;
import br.com.ifrs.SGRU.service.CourseService;

@RestController
public class CourseController {

	
	@Autowired
	private CourseService service; 
	
	@PostMapping("/course")
	@PreAuthorize("hasRole('ROLE_MANAGERS')")
	public ResponseEntity<?> createCourse(@RequestBody CourseDTO course) {
		return ResponseEntity.ok(service.createCourse(course));
	}
	
	@PutMapping("/course")
	@PreAuthorize("hasRole('ROLE_MANAGERS')")
	public ResponseEntity<?> updateCourse(@RequestBody CourseDTO course) {
		return ResponseEntity.ok(service.updateCourse(course));
	}
	
	@GetMapping("/course")
	@PreAuthorize("hasRole('ROLE_MANAGERS')")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	@GetMapping("/course/{id}")
	public ResponseEntity<?> findById(Integer id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
}
