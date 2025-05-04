package br.com.unicuritiba.financeapi.dto;

import lombok.Data;

@Data
public class InvestmentDTO {
    private String name;
    private int periodInMonths;
    private double profitability;
    private double initialAmount;
}
