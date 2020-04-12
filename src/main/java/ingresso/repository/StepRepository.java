package ingresso.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.Step;

@Repository
public interface StepRepository extends JpaRepository<Step, Integer> {

	List<Step> findBySelectiveProcessId(Integer selectiveProcessId);

	List<Step> findByBeginBeforeAndEndAfter(LocalDateTime beginNow, LocalDateTime endNow);

}
