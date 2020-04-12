package ingresso.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ingresso.exception.ResourceNotFoundException;
import ingresso.model.SelectiveProcess;
import ingresso.model.Step;
import ingresso.repository.SelectiveProcessRepository;
import ingresso.repository.StepRepository;

@Service
public class SelectiveProcessService {

	@Autowired
	private SelectiveProcessRepository repository;

	@Autowired
	private StepRepository stepRepository;

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

	public Collection<SelectiveProcess> findOpen() {
		LocalDateTime now = LocalDateTime.now();
		List<Step> steps = stepRepository.findByBeginBeforeAndEndAfter(now, now);
		return steps.stream().filter(distinctByKey(s -> s.getSelectiveProcess().getId()))
				.map(s -> s.getSelectiveProcess()).collect(Collectors.toList());
	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

}
