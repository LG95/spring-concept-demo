package br.com.zup.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class PersonRunner implements CommandLineRunner {
    private static final Logger LOGGER = Logger.getAnonymousLogger();

    private final PersonService service;

    public PersonRunner(PersonService service) {
        this.service = service;
    }

    @Override
    public void run(String[] args) {
        LOGGER.info(() -> service.readPerson(12345678900L).toString());
        LOGGER.info(() -> String.valueOf(service.createPerson(new Person(12345678900L, "Alguém", 10L))));
        LOGGER.info(() -> service.readPerson(12345678900L).toString());
        LOGGER.info(() -> String.valueOf(service.updatePerson(new Person(12345678900L, "Alguém2", 11L))));
        LOGGER.info(() -> service.readPerson(12345678900L).toString());
    }
}
