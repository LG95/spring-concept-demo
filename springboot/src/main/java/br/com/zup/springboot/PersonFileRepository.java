package br.com.zup.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Optional;

@Primary
@Component
public class PersonFileRepository implements PersonRepository {
    private final String directory;

    public PersonFileRepository(@Value("${person.repository.directory}") String directory) {
        this.directory = directory;
    }

    @Override
    public void save(Person person) throws IOException {
        try (FileOutputStream fileStream = new FileOutputStream(String.format("%s\\%d.obj", directory, person.getCpf()));
             ObjectOutputStream objectStream = new ObjectOutputStream(fileStream)) {
            objectStream.writeObject(person);
        }
    }

    @Override
    public Optional<Person> findOne(Long cpf) throws IOException, ClassNotFoundException {
        try (FileInputStream fileStream = new FileInputStream(String.format("%s\\%d.obj", directory, cpf));
             ObjectInputStream objectStream = new ObjectInputStream(fileStream)) {
            Object object = objectStream.readObject();
            return object instanceof Person ? Optional.of((Person) object) : Optional.empty();
        }
    }

    @Override
    public boolean delete(Long cpf) {
        File file = new File(String.format("%s\\%d.obj", directory, cpf));

        if (file.exists()) {
            return file.delete();
        } else {
            return false;
        }
    }
}
