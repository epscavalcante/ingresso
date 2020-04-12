package ingresso.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.Candidate;
import ingresso.model.Person;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

	Optional<Candidate> findByPersonAndSelectiveProcessId(Person person, Integer selectiveProcessId);

	Optional<Candidate> findBySelectiveProcessId(Integer selectiveProcessId);

}
