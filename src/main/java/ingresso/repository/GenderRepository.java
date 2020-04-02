package ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer> {

}
