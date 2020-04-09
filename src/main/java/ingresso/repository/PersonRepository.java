package ingresso.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	Optional<Person> findByCpfAndEmail(String cpf, String email);

	Optional<Person> findByCpf(String cpf);

}
