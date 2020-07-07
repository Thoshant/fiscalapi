package com.code.fiscalapi.service;

import com.code.fiscalapi.enums.Month;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class BirthDateAndGenderCodeGenerator {

    public String getBirthDateAndGenderCode(Date birthDate, String gender) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthDate);
        String year = Integer.toString(calendar.get(Calendar.YEAR));
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String lastTwoDigitsOfYear = year.substring(year.length()-2);
        String monthCharacter = Month.values()[calendar.get(Calendar.MONTH)].getCharacter();
        String dayAndGender = gender.equalsIgnoreCase("Male") ? Integer.toString(day) : Integer.toString(day+40);
        return lastTwoDigitsOfYear + monthCharacter +dayAndGender;
    }
}
