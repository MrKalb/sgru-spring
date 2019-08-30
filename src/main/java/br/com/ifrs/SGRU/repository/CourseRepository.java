package br.com.ifrs.SGRU.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifrs.SGRU.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {

	Optional<CourseEntity> findById(Integer id);
}
