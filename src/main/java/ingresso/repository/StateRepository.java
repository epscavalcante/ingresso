package ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
