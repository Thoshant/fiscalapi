package com.code.fiscalapi.controller;

import com.code.fiscalapi.entity.Person;
import com.code.fiscalapi.service.FiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/fiscal")
public class fiscalController {

    @Autowired
    private FiscalService fiscalService;

    @GetMapping("/calculate/{surname}/{firstName}/{dateOfBirth}/{gender}/{placeOfBirth}")
    public String calculateFiscalCode(
            @PathVariable String surname,
            @PathVariable String firstName,
            @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date dateOfBirth,
            @PathVariable String gender,
            @PathVariable String placeOfBirth) {
        return fiscalService.calculateFiscalCode(
                new Person(surname, firstName, dateOfBirth, gender, placeOfBirth));
    }
}
