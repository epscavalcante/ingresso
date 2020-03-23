package ingresso.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ingresso.exception.ResourceNotFoundException;
import ingresso.model.SelectiveProcess;
import ingresso.repository.SelectiveProcessRepository;

@Service
public class SelectiveProcessService {

	@Autowired
	private SelectiveProcessRepository repository;

	public Collection<SelectiveProcess> findAll() {
		return repository.findAll();
	}

	public SelectiveProcess findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@Transactional
	public SelectiveProcess create(SelectiveProcess entity) {
		return repository.save(entity);
	}

	@Transactional
	public SelectiveProcess update(SelectiveProcess entity, Integer id) {
		SelectiveProcess savedEntity = findById(id);
		BeanUtils.copyProperties(entity, savedEntity, "id");
		return repository.save(savedEntity);
	}

	@Transactional
	public void delete(Integer id) {
		repository.delete(findById(id));
	}
}
