package br.com.ifrs.SGRU.service;

import br.com.ifrs.SGRU.dto.ConsumptionDTO;
import br.com.ifrs.SGRU.entities.ConsumptionEntity;
import br.com.ifrs.SGRU.entities.PersonEntity;
import br.com.ifrs.SGRU.repository.ConsumptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ConsumptionService extends BaseService {

	@Autowired
	private ConsumptionRepository consumptionRepository;

	@Transactional
	public ConsumptionEntity createConsumption(ConsumptionDTO consumption) {
		ConsumptionEntity entity = new ConsumptionEntity();
		entity.setDate(consumption.getDate());
		entity.setShift(consumption.getShift());
		entity.setStatus(consumption.getStatus());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		Optional<PersonEntity> person = personRepository.findByRegistrationNumber(auth.getName());
		if(person.isPresent()) {			
			entity.setPerson(person.get());
			return consumptionRepository.save(entity);
		} else {
			log.error("createConsumption - person not found or not logged in, please verify, person name: {}",auth.getName());
			throw new EntityNotFoundException("Error trying to save consumption");
		}
	}
	
	public Optional<ConsumptionEntity> getById(Integer id) {
		return this.consumptionRepository.findById(id);
	}

	public void deleteConsumption(ConsumptionDTO consumption) {
		ConsumptionEntity entity = consumptionRepository.getOne(consumption.getId());
		consumptionRepository.delete(entity);
	}

	public ConsumptionEntity updateConsumption(ConsumptionDTO consumption) {
		ConsumptionEntity entity = consumptionRepository.getOne(consumption.getId());
		entity.setDate(consumption.getDate());
		entity.setShift(consumption.getShift());
		entity.setStatus(consumption.getStatus());
		return this.consumptionRepository.save(entity);
	}

	public List<ConsumptionEntity> findByPerson() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Optional<PersonEntity> person = personRepository.findByRegistrationNumber(auth.getName());
		if(person.isPresent()) {			
			List<ConsumptionEntity> consumption = consumptionRepository.findByPersonId(person.get().getId());
			if(!CollectionUtils.isEmpty(consumption)) {
				return consumption; 
			} else {
			    log.error("Consumption not found for personId: {}", person.get().getName());
				throw new EntityNotFoundException("Consumption not found");
			}
		} else {
		    log.error("findByPerson - person not found or not logged in, please verify, auth name: {}",auth.getName());
			throw new EntityNotFoundException("Person not found");
		}
	}

	public List<ConsumptionEntity> listByDate(LocalDateTime date) {
		return this.consumptionRepository.findByDate(date);
	}
	
	public List<ConsumptionEntity> listAll() {
		return consumptionRepository.findAll();
	}
	
}
