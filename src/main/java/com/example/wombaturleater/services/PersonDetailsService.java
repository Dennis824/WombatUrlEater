package com.example.wombaturleater.services;

import com.example.wombaturleater.entities.Person;
import com.example.wombaturleater.repository.PeopleRepository;
import com.example.wombaturleater.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByPersonName(s);

        if (person.isEmpty())
            throw new UsernameNotFoundException("User not found!");

        return new PersonDetails(person.get());
    }
}
