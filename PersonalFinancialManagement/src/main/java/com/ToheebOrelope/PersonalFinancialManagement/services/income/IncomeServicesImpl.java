package com.ToheebOrelope.PersonalFinancialManagement.services.income;

import com.ToheebOrelope.PersonalFinancialManagement.dto.IncomeDTO;
import com.ToheebOrelope.PersonalFinancialManagement.enitymodel.Income;
import com.ToheebOrelope.PersonalFinancialManagement.repo.IncomeRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeServicesImpl implements IncomeServices {

    private final IncomeRepo incomeRepo;

    //Creating post expense API call in spring boot

    //This is a method to post data into the database
    public Income insertIncome(IncomeDTO incomeDTO){
        return insertOrUpdateIncome(new Income(), incomeDTO);
    }

    //Method to insert something in the database
    private Income insertOrUpdateIncome(Income income, IncomeDTO incomeDTO){
        income.setTitle(incomeDTO.getTitle());
        income.setDate(incomeDTO.getDate());
        income.setAmount(incomeDTO.getAmount());
        income.setCategory(incomeDTO.getCategory());
        income.setDescription(incomeDTO.getDescription());

        return incomeRepo.save(income);
    }

    //Method to update record in the database
    public Income updateIncome(IncomeDTO incomeDTO, Long id){
        Optional<Income> optionalIncome = incomeRepo.findById(id);
        if (optionalIncome.isPresent()){
            return insertOrUpdateIncome(optionalIncome.get(), incomeDTO);
        }else {
            throw new EntityNotFoundException("Income is not existing " + id);
        }
    }

    //Method to retrieve record from the database
    public List<IncomeDTO> getAllIncome(){
        return incomeRepo.findAll().stream()
                .sorted(Comparator.comparing(Income::getDate).reversed())
                .map(Income::getIncomeDTO)
                .collect(Collectors.toList());
    }

    //Method to retrieve record from the database by it id
    public IncomeDTO getIncomeById(Long id){
        Optional<Income> optionalIncome = incomeRepo.findById(id);
        if (optionalIncome.isPresent()){
            return optionalIncome.get().getIncomeDTO();
        }else {
            throw new EntityNotFoundException("Income is not existing " + id);
        }
    }


    //Method to delete record from the database
    public void deleteIncomeById(Long id){
        Optional<Income> optionalIncome = incomeRepo.findById(id);
        if (optionalIncome.isPresent()){
            incomeRepo.deleteById(id);
        }else {
            throw new EntityNotFoundException("Income is not existing " + id);
        }
    }
}
