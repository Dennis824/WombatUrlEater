package com.example.wombaturleater.services;

import com.example.wombaturleater.entities.Link;
import com.example.wombaturleater.entities.Person;
import com.example.wombaturleater.repository.PeopleRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findOne(int id) {
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElse(null);
    }

    public Optional<Person> getPersonByUsername(String username) {
        return peopleRepository.findByUsername(username);
    }

    @Transactional
    public void save(Person person) {
        peopleRepository.save(person);
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }


    public List<Link> getLinksByPersonId(int id) {
        Optional<Person> person = peopleRepository.findById(id);

        if (person.isPresent()) {
            Hibernate.initialize(person.get().getLinks());
//todo
//             expiration link time
//            // check time of link assignment
//            person.get().getLinks().forEach(link -> {
//                long diffInMillies = Math.abs(link.getCreatedDate().getTime() - new Date().getTime());
//                // 864000000 mlsec = 240 hours
//                if (diffInMillies > 864000000)
//                    link.setExpired(true); // link time expired
//            });

            return person.get().getLinks();
        }
        else {
            return Collections.emptyList();
        }
    }
}
