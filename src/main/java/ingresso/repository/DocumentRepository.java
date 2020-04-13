package ingresso.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.Candidate;
import ingresso.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

	List<Document> findByCandidate(Candidate candidate);

	Optional<Document> findByFileFilename(String filename);

}
