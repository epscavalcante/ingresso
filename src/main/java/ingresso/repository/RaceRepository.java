package ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.Race;

@Repository
public interface RaceRepository extends JpaRepository<Race, Integer> {

}
