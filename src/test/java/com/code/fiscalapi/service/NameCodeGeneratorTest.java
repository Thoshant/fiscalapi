package com.code.fiscalapi.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NameCodeGeneratorTest {

    private NameCodeGenerator nameCodeGenerator;

    @Before
    public void beforeTest(){
        nameCodeGenerator = new NameCodeGenerator();
    }

    @Test
    public void testGetSurNameCode_whenInputSurname_thenShouldReturnSurnameFiscalCode(){
        String surname = "Miller";

        String result = nameCodeGenerator.getSurNameCode(surname);
        Assert.assertEquals("MLL", result);
    }
}
