package br.com.ifrs.SGRU.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifrs.SGRU.entities.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

	List<PersonEntity> findByname(String name);
	
	Optional<PersonEntity> findByCpf(String cpf);
	
	Optional<PersonEntity> findByRegistrationNumber(String registrationNumber);	
}
