package br.com.ifrs.SGRU.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifrs.SGRU.dto.PersonDTO;
import br.com.ifrs.SGRU.entities.PersonEntity;
import br.com.ifrs.SGRU.repository.PersonRepository;
import br.com.ifrs.SGRU.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PersonService service;

	@GetMapping("/person/all")
	public ResponseEntity<List<PersonEntity>> getAllPerson() {
		return ResponseEntity.ok(personRepository.findAll());
	}

	@PreAuthorize("hasRole('ROLE_MANAGERS')")
	@GetMapping("/person/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(personRepository.findById(id));
	}

	@PreAuthorize("hasRole('ROLE_MANAGERS')")
	@GetMapping("/person")
	public ResponseEntity<PersonEntity> getPerson(@RequestParam(value="cpf",required=false) String cpf, 
			@RequestParam(value="registrationNumber",required=false) String registrationNumber) {
		if(!StringUtils.isEmpty(cpf)) {
			return ResponseEntity.ok(this.service.queryPersonByCpf(cpf));
		} else if(!StringUtils.isEmpty(registrationNumber)) {
			return ResponseEntity.ok(this.service.queryPersonByRegistration(registrationNumber));
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("/person")
	@PreAuthorize("hasRole('ROLE_MANAGERS')")
	public ResponseEntity<?> createPerson(@RequestBody PersonDTO person) {
		return ResponseEntity.ok(service.createPerson(person));
	}

	@PutMapping("/person")
	@PreAuthorize("hasRole('ROLE_MANAGERS')")
	public ResponseEntity<?> updatePerson(@RequestBody PersonDTO person) {
		return ResponseEntity.ok(service.updatePerson(person));
	}

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
	
	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
	public String logoutDo(HttpServletRequest request){
	HttpSession session= request.getSession(false);
	    SecurityContextHolder.clearContext();
	         session= request.getSession(false);
	        if(session != null) {
	            session.invalidate();
	        }
	        for(Cookie cookie : request.getCookies()) {
	            cookie.setMaxAge(0);
	        }

	    return "logout";
	}

}
