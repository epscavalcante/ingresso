package ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.Pole;

@Repository
public interface PoleRepository extends JpaRepository<Pole, Integer> {

}
