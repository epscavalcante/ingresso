package ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.InstitutionType;

@Repository
public interface InstitutionTypeRepository extends JpaRepository<InstitutionType, Integer> {

}
