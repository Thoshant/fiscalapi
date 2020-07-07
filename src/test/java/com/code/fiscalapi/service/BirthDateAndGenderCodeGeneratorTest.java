package com.code.fiscalapi.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BirthDateAndGenderCodeGeneratorTest {

    private BirthDateAndGenderCodeGenerator birthDateAndGenderCodeGenerator;

    @Before
    public void beforeTest(){
        birthDateAndGenderCodeGenerator = new BirthDateAndGenderCodeGenerator();
    }

    @Test
    public void testGetBirthDateAndGenderCode_whenHavingValidBirthdayAndGender_thenShouldReturnFiscalCode() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date birthDay = sdf.parse("25-07-1986");
        String gender = "Male";

        String result = birthDateAndGenderCodeGenerator.getBirthDateAndGenderCode(birthDay, gender);
        Assert.assertEquals("86L25",result);
    }
}
