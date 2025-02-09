package com.ToheebOrelope.PersonalFinancialManagement.enitymodel;

import com.ToheebOrelope.PersonalFinancialManagement.dto.IncomeDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Income {

    //This is to identify primary key from our database and make it
    // auto increment anytime new data is being added
    //Properties
    //Id as a primary key and auto increment from the database,
    // we need to annotate it with @Id and @GeneratedValue(strategy = GenerationType.IDENTITY)
    //This is our entity model with our class properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String category;

    private Integer amount;

    private LocalDate date;

    private String description;

    //This is mapping method to convert income entity to income dto
    public IncomeDTO getIncomeDTO(){

        IncomeDTO incomeDTO = new IncomeDTO();

        incomeDTO.setId(id);
        incomeDTO.setTitle(title);
        incomeDTO.setCategory(category);
        incomeDTO.setAmount(amount);
        incomeDTO.setDate(date);
        incomeDTO.setDescription(description);

        return incomeDTO;
    }

}
