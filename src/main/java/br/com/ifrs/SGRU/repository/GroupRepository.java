package br.com.ifrs.SGRU.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifrs.SGRU.entities.GroupEntity;

@Transactional
@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, Integer> {

	Optional<GroupEntity> findById(Integer id);
	
	List<GroupEntity> findByStatus(String status);
	
}
