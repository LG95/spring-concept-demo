package br.com.zup.spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Optional;

@Primary
@Component
public class PersonFileRepository implements PersonRepository {
    @Override
    public void save(Person person) throws IOException {
        try (FileOutputStream fileStream = new FileOutputStream(String.format("%d.obj", person.getCpf()));
             ObjectOutputStream objectStream = new ObjectOutputStream(fileStream)) {
            objectStream.writeObject(person);
        }
    }

    @Override
    public Optional<Person> findOne(Long cpf) throws IOException, ClassNotFoundException {
        try (FileInputStream fileStream = new FileInputStream(String.format("%d.obj", cpf));
             ObjectInputStream objectStream = new ObjectInputStream(fileStream)) {
            Object object = objectStream.readObject();
            return object instanceof Person ? Optional.of((Person) object) : Optional.empty();
        }
    }

    @Override
    public boolean delete(Long cpf) {
        File file = new File(String.format("%d.obj", cpf));

        if (file.exists()) {
            return file.delete();
        } else {
            return false;
        }
    }
}
