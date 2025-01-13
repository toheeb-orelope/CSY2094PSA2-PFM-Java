package com.ToheebOrelope.PersonalFinancialManagement.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IncomeDTO {

    private Long id;

    private String title;

    private String category;

    private Integer amount;

    private LocalDate date;

    private String description;
}
