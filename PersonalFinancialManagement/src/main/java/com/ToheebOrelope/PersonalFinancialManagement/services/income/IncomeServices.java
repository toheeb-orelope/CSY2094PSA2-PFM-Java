package com.ToheebOrelope.PersonalFinancialManagement.services.income;

import com.ToheebOrelope.PersonalFinancialManagement.dto.IncomeDTO;
import com.ToheebOrelope.PersonalFinancialManagement.enitymodel.Income;

import java.util.List;

//This is going to implement all methods and data in out ServiceIml
public interface IncomeServices {

    Income insertIncome(IncomeDTO incomeDTO);

    List<IncomeDTO> getAllIncome();

    Income updateIncome(IncomeDTO incomeDTO, Long id);

    IncomeDTO getIncomeById(Long id);

    void deleteIncomeById(Long id);
}
