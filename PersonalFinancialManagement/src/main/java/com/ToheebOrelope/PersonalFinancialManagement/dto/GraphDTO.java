package com.ToheebOrelope.PersonalFinancialManagement.dto;

import com.ToheebOrelope.PersonalFinancialManagement.enitymodel.Expense;
import com.ToheebOrelope.PersonalFinancialManagement.enitymodel.Income;
import lombok.Data;

import java.util.List;

@Data
public class GraphDTO {

    //Properties
    private List<Expense> expenses;

    private List<Income> incomes;
}
