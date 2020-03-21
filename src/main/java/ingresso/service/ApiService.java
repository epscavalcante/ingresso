package ingresso.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ingresso.exception.ResourceNotFoundException;

@Service
public class ApiService<R, ID> {

	@Autowired
	private JpaRepository<R, ID> repository;

	public Collection<R> findAll() {
		return repository.findAll();
	}

	public R findById(ID id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Recurso %s não encontrado!", id)));
	}

	@Transactional
	public R create(R entity) {
		return repository.save(entity);
	}

	@Transactional
	public R update(R entity, ID id) {
		R savedEntity = findById(id);
		BeanUtils.copyProperties(entity, savedEntity, "id");
		return repository.save(savedEntity);
	}

	@Transactional
	public void delete(ID id) {
		repository.delete(findById(id));
	}
}
