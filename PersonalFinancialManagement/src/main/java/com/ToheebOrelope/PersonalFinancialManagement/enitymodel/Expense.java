package com.ToheebOrelope.PersonalFinancialManagement.enitymodel;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

//Annotating as Entity and Data
@Entity
@Data
public class Expense {

    //This is to identify primary key from our database and make it
    // auto increment anytime new data is being added
    //Properties
    //Id as a primary key and auto increment from the database,
    // we need to annotate it with @Id and @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String category;

    private LocalDate date;

    private Integer amount;

    //This is our entity model with our class properties
}
