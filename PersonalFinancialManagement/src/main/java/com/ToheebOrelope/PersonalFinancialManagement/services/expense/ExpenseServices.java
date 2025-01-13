package com.ToheebOrelope.PersonalFinancialManagement.services.expense;

import com.ToheebOrelope.PersonalFinancialManagement.dto.ExpenseDTO;
import com.ToheebOrelope.PersonalFinancialManagement.enitymodel.Expense;

import java.util.List;

//This is going to implement all method and data in out ServiceIml
public interface ExpenseServices {

    Expense insertExpense(ExpenseDTO expenseDTO);

    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    Expense updateExpense(ExpenseDTO expenseDTO, Long id);

    void deleteExpenseById(Long id);
}
