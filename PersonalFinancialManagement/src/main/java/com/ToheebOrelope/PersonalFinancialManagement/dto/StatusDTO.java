package com.ToheebOrelope.PersonalFinancialManagement.dto;


import com.ToheebOrelope.PersonalFinancialManagement.enitymodel.Expense;
import com.ToheebOrelope.PersonalFinancialManagement.enitymodel.Income;
import lombok.Data;

@Data
public class StatusDTO {

    private Double income;

    private Double expense;

    private Income latestIncome;

    private Expense latestExpense;

    private Double balance;

    private Double minIncome;

    private Double maxIncome;

    private Double minExpense;

    private Double maxExpense;
}
