package ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.SuperiorCourse;

@Repository
public interface SuperiorCourseRepository extends JpaRepository<SuperiorCourse, Integer> {

}
