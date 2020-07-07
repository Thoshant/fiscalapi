package com.code.fiscalapi.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class NameCodeGenerator {

    public String getSurNameCode(String surname) {
        Map<String, String> wordMap = extractConsonantAndVowel(surname);
        String consonant = wordMap.get("consonent");
        String vowel = wordMap.get("vowel");
        String surnameFiscalCode = "";

        surnameFiscalCode = getFiscalCodeOfName(consonant, vowel, surnameFiscalCode);

        return surnameFiscalCode;
    }

    public String getFirstNameCode(String firstName) {

        Map<String, String> wordMap = extractConsonantAndVowel(firstName);
        String consonant = wordMap.get("consonent");
        String vowel = wordMap.get("vowel");
        String firstNameFiscalCode = "";

        if (3 < consonant.length()) {
            firstNameFiscalCode += consonant.substring(0, 1);
            firstNameFiscalCode += consonant.substring(2, 4);
        } else {
            firstNameFiscalCode = getFiscalCodeOfName(consonant, vowel, firstNameFiscalCode);
        }

        return firstNameFiscalCode;
    }

    private String getFiscalCodeOfName(String consonant, String vowel, String nameFiscalCode) {
        if (3 <= consonant.length()) {
            nameFiscalCode = consonant.substring(0, 3);
        } else if (consonant.length() == 2 && vowel.length() > 0) {
            nameFiscalCode += consonant;
            nameFiscalCode += vowel.substring(0, 1);
        } else if (consonant.length() == 2 && vowel.length() == 0) {
            nameFiscalCode += consonant;
            nameFiscalCode += "X";
        } else if (consonant.length() == 1 && vowel.length() > 1) {
            nameFiscalCode += consonant;
            nameFiscalCode += vowel.substring(0, 2);
        } else if (consonant.length() == 1 && vowel.length() == 1) {
            nameFiscalCode += consonant;
            nameFiscalCode += vowel;
            nameFiscalCode += "X";
        } else if (consonant.length() == 1 && vowel.length() == 0) {
            nameFiscalCode += consonant;
            nameFiscalCode += "XX";
        } else if (consonant.length() == 0 && vowel.length() > 2) {
            nameFiscalCode += vowel.substring(0, 3);
        } else if (consonant.length() == 0 && vowel.length() == 2) {
            nameFiscalCode += vowel.substring(0, 2);
            nameFiscalCode += "X";
        } else if (consonant.length() == 0 && vowel.length() == 1) {
            nameFiscalCode += vowel;
            nameFiscalCode += "XX";
        } else if (consonant.length() == 0 && vowel.length() == 0) {
            nameFiscalCode += "XXX";
        }
        return nameFiscalCode;
    }

    private boolean isCharacterVowel(char charAt) {
        return (charAt == 'A' || charAt == 'E' || charAt == 'I' || charAt == 'O' || charAt == 'U');
    }

    private Map<String, String> extractConsonantAndVowel(String word) {
        String consonant = "";
        String vowel = "";
        String wordUpperCase = word.toUpperCase();
        Map<String, String> wordMap = new HashMap<>();

        for (int i = 0; i < wordUpperCase.length(); i++) {
            if (isCharacterVowel(wordUpperCase.charAt(i))) {
                vowel += wordUpperCase.charAt(i);
            } else {
                consonant += wordUpperCase.charAt(i);
            }
        }

        wordMap.put("consonent", consonant);
        wordMap.put("vowel", vowel);

        return wordMap;
    }


}
