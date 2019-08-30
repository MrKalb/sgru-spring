package br.com.ifrs.SGRU.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifrs.SGRU.entities.ConsumptionEntity;

public interface ConsumptionRepository extends JpaRepository<ConsumptionEntity, Integer> {
	
	List<ConsumptionEntity> findByDateAndPersonId(LocalDateTime date,Integer id);
	
	List<ConsumptionEntity> findByShiftAndPersonId(String shift,Integer id);
	
	List<ConsumptionEntity> findByPersonId(Integer id);
	
	List<ConsumptionEntity> findByDate(LocalDateTime date); 
	
}
