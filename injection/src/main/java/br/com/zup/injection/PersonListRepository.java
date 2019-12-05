package br.com.zup.injection;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class PersonListRepository implements PersonRepository {
    private final List<Person> people;

    public PersonListRepository(List<Person> people) {
        this.people = people;
    }

    @Override
    public void save(Person person) throws IOException {
        int i = people.indexOf(person);

        if (i >= 0) {
            people.set(i, person);
        } else if (!people.add(person)) {
            throw new IOException();
        }
    }

    @Override
    public Optional<Person> findOne(Long cpf) throws IOException, ClassNotFoundException {
        return people.stream().filter(person -> cpf.equals(person.getCpf())).findAny();
    }

    @Override
    public boolean delete(Long cpf) {
        return people.removeIf(person -> cpf.equals(person.getCpf()));
    }
}
