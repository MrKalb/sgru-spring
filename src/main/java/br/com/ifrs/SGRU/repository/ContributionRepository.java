package br.com.ifrs.SGRU.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifrs.SGRU.entities.ContributionEntity;

public interface ContributionRepository extends JpaRepository<ContributionEntity, Integer> {

	List<ContributionEntity> findByPersonId(Integer id);
	
	List<ContributionEntity> findByPaymentStatus(String status);
}
