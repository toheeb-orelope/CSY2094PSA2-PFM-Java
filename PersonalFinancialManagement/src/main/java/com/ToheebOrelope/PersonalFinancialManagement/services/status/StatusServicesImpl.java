package com.ToheebOrelope.PersonalFinancialManagement.services.status;

import com.ToheebOrelope.PersonalFinancialManagement.dto.GraphDTO;
import com.ToheebOrelope.PersonalFinancialManagement.dto.StatusDTO;
import com.ToheebOrelope.PersonalFinancialManagement.enitymodel.Expense;
import com.ToheebOrelope.PersonalFinancialManagement.enitymodel.Income;
import com.ToheebOrelope.PersonalFinancialManagement.repo.ExpenseRepo;
import com.ToheebOrelope.PersonalFinancialManagement.repo.IncomeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

@Service
@RequiredArgsConstructor
public class StatusServicesImpl implements StatusServices{

    private final IncomeRepo incomeRepo;

    private final ExpenseRepo expenseRepo;

    //This is a method to retrieve the date for the chart from the expense and income
    public GraphDTO getChartData(){

        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(27);

        GraphDTO graphDTO = new GraphDTO();
        graphDTO.setExpenses(expenseRepo.findByDateBetween(startDate, endDate));
        graphDTO.setIncomes(incomeRepo.findByDateBetween(startDate, endDate));

        return graphDTO;
    }

    //Implementing the method to find the total expenses and income
    public StatusDTO getStatus(){
        Double totalIncome = incomeRepo.calculateTotalAmount();
        Double totalExpense = expenseRepo.calculateTotalAmount();

        Optional<Income> optionalIncome = incomeRepo.findFirstByOrderByDateDesc();
        Optional<Expense> optionalExpense = expenseRepo.findFirstByOrderByDateDesc();

        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setExpense(totalExpense);
        statusDTO.setIncome(totalIncome);

        //This ifPresent would check for the existence instead of using if statement
        optionalIncome.ifPresent(statusDTO::setLatestIncome);
        optionalExpense.ifPresent(statusDTO::setLatestExpense);

        //Calculate the balance
        statusDTO.setBalance(totalIncome - totalExpense);

        List<Income> incomeList = incomeRepo.findAll();
        List<Expense> expenseList = expenseRepo.findAll();

        //Methods to calculate the maximum and minimum income
        OptionalDouble minIncome = incomeList.stream().mapToDouble(Income::getAmount).min();
        OptionalDouble maxIncome = incomeList.stream().mapToDouble(Income::getAmount).max();

        //Methods to calculate the maximum and minimum expense
        OptionalDouble minExpense = expenseList.stream().mapToDouble(Expense::getAmount).min();
        OptionalDouble maxExpense = expenseList.stream().mapToDouble(Expense::getAmount).max();

        statusDTO.setMaxExpense(maxExpense.isPresent() ? maxExpense.getAsDouble() : null);
        statusDTO.setMinExpense(minExpense.isPresent() ? minExpense.getAsDouble() : null);

        statusDTO.setMaxIncome(maxIncome.isPresent() ? maxIncome.getAsDouble() : null);
        statusDTO.setMinIncome(minIncome.isPresent() ? minIncome.getAsDouble() : null);


        return statusDTO;
    }
}
