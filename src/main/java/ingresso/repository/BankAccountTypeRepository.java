package ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ingresso.model.BankAccountType;

@Repository
public interface BankAccountTypeRepository extends JpaRepository<BankAccountType, Integer> {

}
