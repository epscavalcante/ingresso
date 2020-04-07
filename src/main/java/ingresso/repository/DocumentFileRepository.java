package ingresso.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.DocumentFile;

@Repository
public interface DocumentFileRepository extends JpaRepository<DocumentFile, Integer> {

	Optional<DocumentFile> findByFilename(String filename);
}
