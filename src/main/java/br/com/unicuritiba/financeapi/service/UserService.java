package br.com.unicuritiba.financeapi.service;

import br.com.unicuritiba.financeapi.dto.InvestmentResponseDTO;
import br.com.unicuritiba.financeapi.dto.UserResponseDTO;
import br.com.unicuritiba.financeapi.model.Investment;
import br.com.unicuritiba.financeapi.model.User;
import br.com.unicuritiba.financeapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDTO getUserWithInvestments(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());

        List<InvestmentResponseDTO> investments = user.getInvestments()
                .stream()
                .map(this::mapToInvestmentDTO)
                .collect(Collectors.toList());

        dto.setInvestments(investments);

        return dto;
    }

    private InvestmentResponseDTO mapToInvestmentDTO(Investment inv) {
        InvestmentResponseDTO dto = new InvestmentResponseDTO();
        dto.setId(inv.getId());
        dto.setName(inv.getName());
        dto.setPeriodInMonths(inv.getPeriodInMonths());
        dto.setProfitability(inv.getProfitability());
        dto.setInitialAmount(inv.getInitialAmount());
        return dto;
    }
}
