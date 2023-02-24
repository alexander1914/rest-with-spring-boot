package br.com.udemy.services;

import br.com.udemy.data.vo.PersonVO;
import br.com.udemy.data.vo.PersonVOV2;
import br.com.udemy.exceptions.ResourceNotFoundException;
import br.com.udemy.mapper.DozerMapper;
import br.com.udemy.mapper.custom.PersonMapper;
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
    @Autowired
    PersonMapper personMapper;

    public PersonVOV2 findById(Long id){
        logger.info("Finding one person !");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("No records found for this ID")));
        return DozerMapper.parseObject(entity, PersonVOV2.class);
    }

    public List<PersonVO>findAll(){
        logger.info("Finding all people !");
        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO create(PersonVO person){
        logger.info("Creating a person !");
        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVOV2 createV2(PersonVOV2 person){
        logger.info("Creating a person !");
        var entity = personMapper.convertVoToEntity(person);
        var vo = personMapper.convertEntityToVo(repository.save(entity));
        return vo;
    }

    public PersonVO update(PersonVO person){
        logger.info("Updating a person !");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException(("No records found for this ID")));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAdress());
        entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id){
        logger.info("Deleting a person !");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("No records found for this ID")));
        repository.delete(entity);
    }

}
