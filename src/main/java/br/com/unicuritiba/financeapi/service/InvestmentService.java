package br.com.unicuritiba.financeapi.service;

import br.com.unicuritiba.financeapi.dto.InvestmentDTO;
import br.com.unicuritiba.financeapi.model.Investment;
import br.com.unicuritiba.financeapi.model.User;
import br.com.unicuritiba.financeapi.repository.InvestmentRepository;
import br.com.unicuritiba.financeapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvestmentService {

    private final InvestmentRepository investmentRepository;
    private final UserRepository userRepository;

    public List<Investment> listByUser(Long userId) {
        return investmentRepository.findByUserId(userId);
    }

    public Investment create(Long userId, InvestmentDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Investment investment = new Investment();
        investment.setName(dto.getName());
        investment.setPeriodInMonths(dto.getPeriodInMonths());
        investment.setProfitability(dto.getProfitability());
        investment.setInitialAmount(dto.getInitialAmount());
        investment.setUser(user);

        return investmentRepository.save(investment);
    }

    public Investment update(Long investmentId, InvestmentDTO dto) {
        Investment investment = investmentRepository.findById(investmentId)
                .orElseThrow(() -> new RuntimeException("Investment not found"));

        investment.setName(dto.getName());
        investment.setPeriodInMonths(dto.getPeriodInMonths());
        investment.setProfitability(dto.getProfitability());
        investment.setInitialAmount(dto.getInitialAmount());

        return investmentRepository.save(investment);
    }

    public void delete(Long investmentId) {
        investmentRepository.deleteById(investmentId);
    }
}