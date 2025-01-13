package com.ToheebOrelope.PersonalFinancialManagement.repo;

import com.ToheebOrelope.PersonalFinancialManagement.enitymodel.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IncomeRepo extends JpaRepository<Income, Long> {
    //This would create a new table in our database using
    // org.springframework.data.jpa.repository.JpaRepository;,
    // org.springframework.stereotype.Repository;,
    // and through our entity model provided


    //A custom method to get the list of income within two days
    List<Income> findByDateBetween(LocalDate startDate, LocalDate endDate);

    //Method to calculate the income by query the database
    @Query("SELECT SUM(i.amount) FROM Income i")
    Double calculateTotalAmount();

    //Method to find the income from the database by date and arrange in descending order
    Optional<Income> findFirstByOrderByDateDesc();
}
