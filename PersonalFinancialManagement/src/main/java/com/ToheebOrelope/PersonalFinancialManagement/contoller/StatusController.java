package com.ToheebOrelope.PersonalFinancialManagement.contoller;


import com.ToheebOrelope.PersonalFinancialManagement.dto.GraphDTO;
import com.ToheebOrelope.PersonalFinancialManagement.services.status.StatusServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/status")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StatusController {

    private final StatusServices statusServices;

    //This is the endpoint to make a request from our
    // database to retrieve both expense and income from our database
    @GetMapping("/chart")
    public ResponseEntity<GraphDTO> getChartDetails() {
        return ResponseEntity.ok(statusServices.getChartData());
    }

    //This is the endpoint to make a request from our
    // database to retrieve both expense and income from
    // our database for calculation
    @GetMapping()
    public ResponseEntity<?> getStatus() {
        return ResponseEntity.ok(statusServices.getStatus());
    }
}
