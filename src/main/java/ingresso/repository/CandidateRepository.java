package ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

}
