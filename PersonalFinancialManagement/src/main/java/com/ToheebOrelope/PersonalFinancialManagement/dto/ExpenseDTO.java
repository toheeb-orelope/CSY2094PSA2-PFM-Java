package com.ToheebOrelope.PersonalFinancialManagement.dto;

//A data transfer object (DTO) is an object that
// carries data between processes.

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseDTO {

    //Properties
    private Long id;

    private String title;

    private String description;

    private String category;

    private LocalDate date;

    private Integer amount;
}
