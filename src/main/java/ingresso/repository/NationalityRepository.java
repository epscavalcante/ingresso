package ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.Nationality;

@Repository
public interface NationalityRepository extends JpaRepository<Nationality, Integer> {

}
