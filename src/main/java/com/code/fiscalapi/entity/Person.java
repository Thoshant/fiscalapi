package com.code.fiscalapi.entity;

import java.util.Date;

public class Person {

    private String surname;
    private String firstName;
    private Date birthDate;
    private String gender;
    private String placeOfBirth;

    public Person(String surname, String firstName, Date birthDate, String gender, String placeOfBirth) {
        this.surname = surname;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.placeOfBirth = placeOfBirth;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }
}
