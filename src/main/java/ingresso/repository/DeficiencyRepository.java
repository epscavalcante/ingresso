package ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.Deficiency;

@Repository
public interface DeficiencyRepository extends JpaRepository<Deficiency, Integer> {

}
