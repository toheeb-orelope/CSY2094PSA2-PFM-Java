package com.ToheebOrelope.PersonalFinancialManagement.services.expense;


import com.ToheebOrelope.PersonalFinancialManagement.dto.ExpenseDTO;
import com.ToheebOrelope.PersonalFinancialManagement.enitymodel.Expense;
import com.ToheebOrelope.PersonalFinancialManagement.repo.ExpenseRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseServicesImpl implements ExpenseServices {

    //Creating post expense API call in spring boot

    private final ExpenseRepo expenseRepo;

    //This is a method to post data into the database
    public Expense insertExpense(ExpenseDTO expenseDTO) {
        return insertOrUpdateExpense(new Expense(), expenseDTO);
    }


    //Method to insert something in the database
    private Expense insertOrUpdateExpense(Expense expense, ExpenseDTO expenseDTO) {
        expense.setTitle(expenseDTO.getTitle());
        expense.setDate(expenseDTO.getDate());
        expense.setAmount(expenseDTO.getAmount());
        expense.setCategory(expenseDTO.getCategory());
        expense.setDescription(expenseDTO.getDescription());
        return expenseRepo.save(expense);
    }

    //Method to update record in our database database
    public Expense updateExpense(ExpenseDTO expenseDTO, Long id) {
        Optional<Expense> optionalExpense = expenseRepo.findById(id);
        if (optionalExpense.isPresent()) {
            return insertOrUpdateExpense(optionalExpense.get(), expenseDTO);
        }else {
            throw new EntityNotFoundException("Expense is not existing " + id);
        }
    }

    //Method to retrieve data from the database into a java list
    public List<Expense> getAllExpenses() {
        return expenseRepo.findAll().stream()
                .sorted(Comparator.comparing(Expense::getDate).reversed())
                .collect(Collectors.toList());
    }

    //Method to retrieve data from the database by it id into a java list
    public Expense getExpenseById(Long id) {
        Optional<Expense> optionalExpense = expenseRepo.findById(id);
        //This would check if the id is existing, then return the id if not return to else condition
        if (optionalExpense.isPresent()) {
            return optionalExpense.get();
        }else {
            throw new EntityNotFoundException("Expense is not existing " + id);
        }
    }

    //Method to delete data from the database by it id
    public void deleteExpenseById(Long id){
        Optional<Expense> optionalExpense = expenseRepo.findById(id);
        if (optionalExpense.isPresent()) {
            expenseRepo.delete(optionalExpense.get());
        }else {
            throw new EntityNotFoundException("Expense is not existing " + id);
        }
    }
}
