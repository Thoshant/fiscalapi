package com.code.fiscalapi.service;

import com.code.fiscalapi.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FiscalService {

    @Autowired
    private FiscalCalculator fiscalCalculator;

    public String calculateFiscalCode(Person person){
        return fiscalCalculator.calculateFiscalCode(person);
    }
}
