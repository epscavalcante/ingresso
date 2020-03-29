package ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
