package ingresso.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ingresso.exception.ResourceNotFoundException;
import ingresso.model.Demand;
import ingresso.repository.DemandRepository;

@Service
public class DemandService {

	@Autowired
	private DemandRepository repository;

	public Collection<Demand> findAll() {
		return repository.findAll();
	}

	public Demand findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@Transactional
	public Demand create(Demand entity) {
		return repository.save(entity);
	}

	@Transactional
	public Demand update(Demand entity, Integer id) {
		Demand savedEntity = findById(id);
		BeanUtils.copyProperties(entity, savedEntity, "id");
		return repository.save(savedEntity);
	}

	@Transactional
	public void delete(Integer id) {
		repository.delete(findById(id));
	}
}
