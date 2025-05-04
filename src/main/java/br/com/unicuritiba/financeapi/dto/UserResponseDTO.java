package br.com.unicuritiba.financeapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private List<InvestmentResponseDTO> investments;
}
