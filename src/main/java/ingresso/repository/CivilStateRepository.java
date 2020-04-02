package ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.CivilState;

@Repository
public interface CivilStateRepository extends JpaRepository<CivilState, Integer> {

}
