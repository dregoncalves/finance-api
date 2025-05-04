package br.com.unicuritiba.financeapi.repository;

import br.com.unicuritiba.financeapi.model.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {
    List<Investment> findByUserId(Long userId);
}
