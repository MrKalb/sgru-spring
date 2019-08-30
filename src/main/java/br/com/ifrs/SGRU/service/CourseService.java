package br.com.ifrs.SGRU.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifrs.SGRU.dto.CourseDTO;
import br.com.ifrs.SGRU.entities.CourseEntity;
import br.com.ifrs.SGRU.entities.LevelEntity;
import br.com.ifrs.SGRU.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	public CourseRepository repository; 
	
	@Autowired
	public ModelMapper modelMapper; 
	
	public CourseEntity createCourse(CourseDTO course) {
		
		CourseEntity entity = modelMapper.map(course, CourseEntity.class);
		return repository.save(entity);
	}
	
	public void deleteCourse(CourseDTO course) {
		CourseEntity entity = repository.getOne(course.getId());
		repository.delete(entity);
	}
	
	
	public CourseEntity updateCourse(CourseDTO course) {
		CourseEntity entity = repository.getOne(course.getId());
		entity.setDescription(course.getDescription());
		entity.setShift(course.getShift());
		LevelEntity level = modelMapper.map(course.getLevel(), LevelEntity.class);
		entity.setLevel(level);
		
		return repository.save(entity);
		
	}

	public List<CourseEntity> findAll() {
		return this.repository.findAll();
	}

	public CourseEntity findById(Integer id) {
		Optional<CourseEntity> course = this.repository.findById(id);
		if(course.isPresent()) {
			return course.get(); 
		} else {
			throw new EntityNotFoundException();
		}
	}
	
	
}
