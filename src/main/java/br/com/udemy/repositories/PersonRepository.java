package br.com.udemy.repositories;

import br.com.udemy.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//TODO JpaRepository: ele cria todas as operações crud para sua aplicação
public interface PersonRepository extends JpaRepository<Person, Long> {}
