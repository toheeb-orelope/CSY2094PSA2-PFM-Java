package com.ToheebOrelope.PersonalFinancialManagement.contoller;

import com.ToheebOrelope.PersonalFinancialManagement.dto.IncomeDTO;
import com.ToheebOrelope.PersonalFinancialManagement.enitymodel.Income;
import com.ToheebOrelope.PersonalFinancialManagement.services.income.IncomeServices;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/income")
@RequiredArgsConstructor
@CrossOrigin("*")
public class IncomeController {

    private final IncomeServices incomeServices;

    //This is the endpoint to make a request from our
    // database which working with inserting data into the database
    @PostMapping
    public ResponseEntity<?> insertIncome(@RequestBody IncomeDTO dto) {
        Income createdIncome = incomeServices.insertIncome(dto);
        if (createdIncome != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdIncome);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //This is the endpoint to make a request from our
    // database which working with updating data into the database
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateIncome(@RequestBody IncomeDTO dto, @PathVariable Long id) {
        try {
            return ResponseEntity.ok(incomeServices.updateIncome(dto, id));
        } catch (EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to connect to the server");
        }
    }

    //This is the endpoint to make a request from our
    // database which working with retrieving data from the database
    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllIncome() {
        return ResponseEntity.ok(incomeServices.getAllIncome());
    }


    //This is the endpoint to make a request from our
    // database which working with retrieving data from the database by it id
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getIncomeById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(incomeServices.getIncomeById(id));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to connect to the server");
        }
    }

    //This is the endpoint to make a request from our
    // database which working with deleting data from the database by it id
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteIncomeById(@PathVariable Long id) {
        try {
            incomeServices.deleteIncomeById(id);
            return null;
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to connect to the server");
        }
    }

}
