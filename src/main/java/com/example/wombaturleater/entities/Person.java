package com.example.wombaturleater.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "The name should not be empty")
    @Size(min = 2, max = 100, message = "The name must be between 2 and 100 characters long")
    @Column(name = "person_name")
    private String personName;

    @Min(value = 1900, message = "The year of birth must be greater than 1900")
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @Column(name = "password")
    private String password;

    @Column(name= "role")
    private String role;

    public Person(String personName, int yearOfBirth) {
        this.personName = personName;
        this.yearOfBirth = yearOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Person() {
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}