package br.com.udemy.services;

import br.com.udemy.exceptions.ResourceNotFoundException;
import br.com.udemy.model.Person;
import br.com.udemy.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

//@Service é para o spring boot encare esse cara como o objeto,
// que vai ser injetado em um time em outras classes da aplicação

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public Person findById(Long id){
        logger.info("Finding one person !");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("No records found for this ID")));
    }

    public List<Person>findAll(){
        logger.info("Finding all people !");

        return repository.findAll();
    }

    public Person create(Person person){
        logger.info("Creating a person !");
        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating a person !");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException(("No records found for this ID")));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAdress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id){
        logger.info("Deleting a person !");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("No records found for this ID")));
        repository.delete(entity);
    }

}
