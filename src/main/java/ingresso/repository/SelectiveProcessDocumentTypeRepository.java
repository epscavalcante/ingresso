package ingresso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.SelectiveProcess;
import ingresso.model.SelectiveProcessDocumentType;

@Repository
public interface SelectiveProcessDocumentTypeRepository extends JpaRepository<SelectiveProcessDocumentType, Integer> {

	List<SelectiveProcessDocumentType> findBySelectiveProcess(SelectiveProcess selectiveProcess);

}
