package ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.Modality;

@Repository
public interface ModalityRepository extends JpaRepository<Modality, Integer> {

}
