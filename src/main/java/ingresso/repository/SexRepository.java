package ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.Sex;

@Repository
public interface SexRepository extends JpaRepository<Sex, Integer> {

}
