package com.code.fiscalapi.service;

import com.code.fiscalapi.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FiscalCalculator {

    @Autowired
    private ReadPDFService readPDFService;
    @Autowired
    private NameCodeGenerator nameCodeGenerator;
    @Autowired
    private ChecksumGenerator checksumGenerator;
    @Autowired
    private BirthDateAndGenderCodeGenerator birthDateAndGenderCodeGenerater;

    private static String[][] pdfNameArray = {{"1.pdf", "false"}, {"2.pdf", "true"}};

    public String calculateFiscalCode(Person person) {

        String surnameCode = nameCodeGenerator.getSurNameCode(person.getSurname());
        String firstNameCode = nameCodeGenerator.getFirstNameCode(person.getFirstName());
        String birthDateAndGenderCode = birthDateAndGenderCodeGenerater.getBirthDateAndGenderCode(person.getBirthDate(), person.getGender());
        String placeOfBirthCode = getPlaceOfBirthCode(person.getPlaceOfBirth());
        String checkCharacter = checksumGenerator.getLastCharacterOfFiscalCode(surnameCode + firstNameCode + birthDateAndGenderCode + placeOfBirthCode);

        return surnameCode + firstNameCode + birthDateAndGenderCode + placeOfBirthCode + checkCharacter;
    }

    private String getPlaceOfBirthCode(String placeOfBirth) {
        for (String[] s : pdfNameArray) {
            String codeFromPDF = readPDFService.getCodeFromPDF(placeOfBirth, s[0], Boolean.valueOf(s[1]));
            if (codeFromPDF != null)
                return codeFromPDF;
        }
        throw new RuntimeException("Place of birth not exists");
    }
}
