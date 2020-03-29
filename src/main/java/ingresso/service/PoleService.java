package ingresso.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ingresso.exception.ResourceNotFoundException;
import ingresso.model.Pole;
import ingresso.repository.PoleRepository;

@Service
public class PoleService {

	@Autowired
	private PoleRepository repository;

	public Collection<Pole> findAll() {
		return repository.findAll();
	}

	public Pole findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@Transactional
	public Pole create(Pole entity) {
		return repository.save(entity);
	}

	@Transactional
	public Pole update(Pole entity, Integer id) {
		Pole savedEntity = findById(id);
		BeanUtils.copyProperties(entity, savedEntity, "id");
		return repository.save(savedEntity);
	}

	@Transactional
	public void delete(Integer id) {
		repository.delete(findById(id));
	}
}
