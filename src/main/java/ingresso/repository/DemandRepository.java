package ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.Demand;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Integer> {

}
