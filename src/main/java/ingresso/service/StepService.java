package ingresso.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ingresso.exception.ResourceNotFoundException;
import ingresso.model.Step;
import ingresso.repository.StepRepository;

@Service
public class StepService {

	@Autowired
	private StepRepository repository;

	public Collection<Step> findAll() {
		return repository.findAll();
	}

	public Step findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@Transactional
	public Step create(Step entity) {
		return repository.save(entity);
	}

	@Transactional
	public Step update(Step entity, Integer id) {
		Step savedEntity = findById(id);
		BeanUtils.copyProperties(entity, savedEntity, "id");
		return repository.save(savedEntity);
	}

	@Transactional
	public void delete(Integer id) {
		repository.delete(findById(id));
	}
}
