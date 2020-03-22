package ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.Step;

@Repository
public interface StepRepository extends JpaRepository<Step, Integer> {

}
