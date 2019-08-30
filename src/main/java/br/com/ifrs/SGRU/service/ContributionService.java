package br.com.ifrs.SGRU.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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
public class ContributionService {

	@Autowired
	private ContributionRepository repository;
	
	@Autowired
	private PersonRepository personRepository; 
	
	@Autowired
	private ModelMapper mapper; 
	
	public ContributionEntity createContribution(ContributionsDTO contribution) {
		ContributionEntity entity = new ContributionEntity();
		entity.setDate(contribution.getDate());
		entity.setGru(contribution.getGru());
		entity.setValue(contribution.getValue());
		entity.setPaymentStatus(contribution.getPaymentStatus());
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		Optional<PersonEntity> person = personRepository.findByRegistrationNumber(auth.getName());
		*/
		PersonEntity person = mapper.map(contribution.getPerson(), PersonEntity.class);
		entity.setPerson(person);
		
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
		Optional<PersonEntity> person = null; 
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
				throw new EntityNotFoundException();
			}
		}else {
			throw new EntityNotFoundException();
		}
	}
	public List<ContributionEntity> getAll(String paid) {
		return this.repository.findByPaymentStatus(paid);
	}
	
}
