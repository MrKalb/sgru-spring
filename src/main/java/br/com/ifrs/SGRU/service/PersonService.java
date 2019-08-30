package br.com.ifrs.SGRU.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifrs.SGRU.dto.PersonDTO;
import br.com.ifrs.SGRU.entities.CityEntity;
import br.com.ifrs.SGRU.entities.GroupEntity;
import br.com.ifrs.SGRU.entities.PersonEntity;
import br.com.ifrs.SGRU.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository; 

	@Autowired
	private ModelMapper modelMapper; 
	
	public PersonEntity createPerson(PersonDTO person) {
		PersonEntity personEntity = this.modelMapper.map(person, PersonEntity.class);
		return this.personRepository.save(personEntity);
	}
	
	public PersonEntity queryPersonByCpf(String param) {
		Optional<PersonEntity> person = this.personRepository.findByCpf(param);
		if(person.isPresent()) {
			return person.get();
		} else {
			throw new EntityNotFoundException();
		}
		
	}
	
	public PersonEntity queryPersonByRegistration(String param) {
		Optional<PersonEntity> person =  this.personRepository.findByRegistrationNumber(param);
		if(person.isPresent()) {
			return person.get(); 
		} else {
			throw new EntityNotFoundException();
		}
	}
	
	
	public PersonEntity updatePerson(PersonDTO person) {
		PersonEntity entity = personRepository.getOne(person.getId());
		entity.setBirthday(LocalDateTime.parse(person.getBirthday()));
		entity.setCpf(person.getCpf());
		entity.setEmail(person.getEmail());
		entity.setName(person.getName());
		entity.setPhone(person.getPhone());
		entity.setRegistrationNumber(person.getRegistrationNumber());
		entity.setStatus(person.getStatus());

		updateGroup(entity,person);
		updateCity(entity,person);
		
		return this.personRepository.save(entity);
		
	}

	private void updateCity(PersonEntity entity, PersonDTO person) {
		CityEntity city = modelMapper.map(person.getCity(), CityEntity.class);
		entity.setCity(city);
		
	}

	private void updateGroup(PersonEntity entity, PersonDTO person) {
		GroupEntity group = modelMapper.map(person.getGroup(), GroupEntity.class);
		entity.setGroup(group);
	}



}
