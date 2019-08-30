package br.com.ifrs.SGRU.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifrs.SGRU.dto.GroupDTO;
import br.com.ifrs.SGRU.entities.GroupEntity;
import br.com.ifrs.SGRU.repository.GroupRepository;
import br.com.ifrs.SGRU.service.GroupService;

@RestController
public class GroupController {

	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired
	private GroupService groupService; 
	 
	
	@GetMapping("/group")
	@PreAuthorize("hasRole('ROLE_MANAGERS')")
	public List<GroupEntity> listAll(@RequestParam(value="active", required=false) boolean active) {
		if(active) {
			return this.groupRepository.findByStatus("S");
		} else {			
			return this.groupRepository.findAll();
		}
	}
	
	@GetMapping("/group/{id}")
	@PreAuthorize("hasRole('ROLE_MANAGERS')")
	public ResponseEntity<?> listById(@PathVariable Integer id) {
		return ResponseEntity.ok(groupRepository.findById(id));
	}
		
	@PostMapping("/group")
	@PreAuthorize("hasRole('ROLE_MANAGERS')")
	public ResponseEntity<?> createGroup(@RequestBody GroupDTO group) {
			return ResponseEntity.ok(groupService.createGroup(group));
		
	}
	
	@PutMapping("/group")
	@PreAuthorize("hasRole('ROLE_MANAGERS')")
	public ResponseEntity<?> updateGroup(@RequestBody GroupDTO group) throws Exception {
		
		return ResponseEntity.ok(groupService.updateGroup(group));
	}

	
	
}
