package br.com.ifrs.SGRU.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import br.com.ifrs.SGRU.dto.ContributionsDTO;
import br.com.ifrs.SGRU.entities.ContributionEntity;
import br.com.ifrs.SGRU.entities.PersonEntity;
import br.com.ifrs.SGRU.repository.ContributionRepository;
import br.com.ifrs.SGRU.repository.PersonRepository;

@Service
@Slf4j
public class ContributionService extends BaseService {

	@Autowired
	private ContributionRepository repository;

	public ContributionEntity createContribution(ContributionsDTO contribution) {
		ContributionEntity entity = new ContributionEntity();
		entity.setDate(contribution.getDate());
		entity.setGru(contribution.getGru());
		entity.setValue(contribution.getValue());
		entity.setPaymentStatus(contribution.getPaymentStatus());
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		Optional<PersonEntity> person = personRepository.findByRegistrationNumber(auth.getName());
		*/
		PersonEntity person = modelMapper.map(contribution.getPerson(), PersonEntity.class);
		entity.setPerson(person);
		log.info("createContribution - add new contribution for person : {}", person.getName());
		return repository.save(entity);
		
	}
	public ContributionEntity updateContribution(ContributionsDTO contribution) {
		ContributionEntity entity = repository.getOne(contribution.getId());
		entity.setPaymentStatus(contribution.getPaymentStatus());
		entity.setGru(contribution.getGru());
		return repository.save(entity);
	}
	
	public List<ContributionEntity> listContribution(String cpf, String matricula) {
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Optional<PersonEntity> person = Optional.empty();
		if(!StringUtils.isEmpty(cpf)) {
			person = personRepository.findByCpf(cpf);
		} else if (!StringUtils.isEmpty(matricula)) {			
			person = personRepository.findByRegistrationNumber(matricula);
		}
		if(person.isPresent()) {
			List<ContributionEntity> contribution = this.repository.findByPersonId(person.get().getId());
			if(!CollectionUtils.isEmpty(contribution)) {
				return contribution; 
			} else {
				log.error("listContribution - Contribution not found for person: {}", person.get().getName());
				throw new EntityNotFoundException("Contribution not found");
			}
		}else {
			log.error("listContribution - Person not found for cpf :{}, please verify", cpf);
			throw new EntityNotFoundException("Person not found");
		}
	}
	public List<ContributionEntity> getAll(String paid) {
		return this.repository.findByPaymentStatus(paid);
	}
	
}
