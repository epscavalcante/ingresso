package ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.SelectiveProcessType;

@Repository
public interface SelectiveProcessTypeRepository extends JpaRepository<SelectiveProcessType, Integer> {

}
