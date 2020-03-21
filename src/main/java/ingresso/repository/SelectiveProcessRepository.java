package ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.SelectiveProcess;

@Repository
public interface SelectiveProcessRepository extends JpaRepository<SelectiveProcess, Integer> {

}
