package com.ToheebOrelope.PersonalFinancialManagement.contoller;


import com.ToheebOrelope.PersonalFinancialManagement.dto.ExpenseDTO;
import com.ToheebOrelope.PersonalFinancialManagement.enitymodel.Expense;
import com.ToheebOrelope.PersonalFinancialManagement.services.expense.ExpenseServices;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExpenseController {

    private final ExpenseServices expenseServices;

    //This is the endpoint to make a request from our
    // database which working with inserting data into the database
    @PostMapping
    public ResponseEntity<?> insertExpense(@RequestBody ExpenseDTO dto) {
        Expense createdExpense = expenseServices.insertExpense(dto);
        if (createdExpense != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdExpense);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //This is the endpoint to make a request from our
    // database which working with retrieving data from the database
    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllExpenses() {
        return ResponseEntity.ok(expenseServices.getAllExpenses());
    }

    //This is the endpoint to make a request from our
    // database which working with retrieving data by it id from the database
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getExpenseById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(expenseServices.getExpenseById(id));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to connect to the server");
        }
    }

    //This is the endpoint to make a request from our
    // database which working with updating data into the database
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateExpense(@RequestBody ExpenseDTO dto, @PathVariable Long id) {
        try {
            return ResponseEntity.ok(expenseServices.updateExpense(dto, id));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to connect to the server");
        }
    }

    //This is the endpoint to make a request from our
    // database which working with deleting data from the database
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteExpenseById(@PathVariable Long id) {
        try {
            expenseServices.deleteExpenseById(id);
            return null;
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to connect to the server");
        }
    }

}
