package ingresso.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingresso.model.SuperiorCourse;
import ingresso.repository.SuperiorCourseRepository;

@RestController
@RequestMapping("/superior-courses")
public class SuperiorCourseResource {

	@Autowired
	private SuperiorCourseRepository repository;

	@GetMapping
	public Collection<SuperiorCourse> findAll() {
		return repository.findAll();
	}

}
