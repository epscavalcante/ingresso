package ingresso.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ingresso.exception.ResourceNotFoundException;
import ingresso.model.Course;
import ingresso.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository repository;

	public Collection<Course> findAll() {
		return repository.findAll();
	}

	public Course findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@Transactional
	public Course create(Course entity) {
		return repository.save(entity);
	}

	@Transactional
	public Course update(Course entity, Integer id) {
		Course savedEntity = findById(id);
		BeanUtils.copyProperties(entity, savedEntity, "id");
		return repository.save(savedEntity);
	}

	@Transactional
	public void delete(Integer id) {
		repository.delete(findById(id));
	}
}
