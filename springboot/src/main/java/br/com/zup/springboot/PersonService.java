package br.com.zup.springboot;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class PersonService {
    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public boolean createPerson(Person person) {
        try {
            repository.save(person);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public Optional<Person> readPerson(Long cpf) {
        try {
            return repository.findOne(cpf);
        } catch (IOException | ClassNotFoundException e) {
            return Optional.empty();
        }
    }

    public boolean deletePerson(Long cpf) {
        return repository.delete(cpf);
    }

    public boolean updatePerson(Person person) {
        try {
            repository.save(person);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
