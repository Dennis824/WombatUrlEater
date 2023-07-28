package com.example.wombaturleater.util;

import com.example.wombaturleater.entities.Person;
import com.example.wombaturleater.services.PeopleService;
import com.example.wombaturleater.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PeopleService peopleService;
    private final PersonDetailsService personDetailsService;

    @Autowired
    public PersonValidator(PeopleService peopleService, PersonDetailsService personDetailsService) {
        this.peopleService = peopleService;
        this.personDetailsService = personDetailsService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        try {
            //TODO rework this block
            personDetailsService.loadUserByUsername(person.getUsername());

        } catch (UsernameNotFoundException ignored) {
            return;
        }
        errors.rejectValue("username", "", "Person with this name already exists");
    }
}
