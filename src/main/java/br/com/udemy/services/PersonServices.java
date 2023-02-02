package br.com.udemy.services;

import br.com.udemy.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

//@Service é para o spring boot encare esse cara como o objeto,
// que vai ser injetado em um time em outras classes da aplicação

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){
        logger.info("Finding one person !");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Alexander");
        person.setLastName("Oliveira");
        person.setAddress("São Paulo - São Paulo - Brasil");
        person.setGender("Male");
        return person;
    }

    public List<Person>findAll(){
        logger.info("Finding all people !");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person create(Person person){
        logger.info("Creating a person !");
        return person;
    }

    public Person update(Person person){
        logger.info("Updating a person !");
        return person;
    }

    public void delete(String id){
        logger.info("Deleting a person !");
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("Some address in Brasil " + i);
        person.setGender("Male " + i);
        return person;
    }

}
