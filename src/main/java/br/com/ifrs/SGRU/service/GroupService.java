package br.com.ifrs.SGRU.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifrs.SGRU.dto.GroupDTO;
import br.com.ifrs.SGRU.entities.GroupEntity;
import br.com.ifrs.SGRU.repository.GroupRepository;

@Service
public class GroupService {

	@Autowired
	private GroupRepository groupRepository; 
	
	@Autowired
	private ModelMapper modelMapper; 
	
	public GroupEntity createGroup(GroupDTO group) {
		GroupEntity groupEntity = modelMapper.map(group, GroupEntity.class);
		
		return groupRepository.save(groupEntity);
	}

	public GroupEntity updateGroup(GroupDTO group) throws Exception {
		GroupEntity groupEntity = groupRepository.getOne(group.getId());
		groupEntity.setDescription(group.getDescription());
		groupEntity.setValue(group.getValue());
		groupEntity.setStatus(group.getStatus());
		return groupRepository.save(groupEntity);
		
	}
	
	public List<GroupEntity> getAll() {
		return groupRepository.findAll();
	}
	
}
