package br.com.zup.spring;

import java.io.IOException;
import java.util.Optional;

public interface PersonRepository {
    void save(Person person) throws IOException;

    Optional<Person> findOne(Long cpf) throws IOException, ClassNotFoundException;

    boolean delete(Long cpf);
}
