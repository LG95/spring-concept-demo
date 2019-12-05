package br.com.zup.injection;

import java.util.logging.Logger;

public class PersonRunner implements Runnable {
    private static final Logger LOGGER = Logger.getAnonymousLogger();

    private final PersonService service;

    public PersonRunner(PersonService service) {
        this.service = service;
    }

    @Override
    public void run() {
        LOGGER.info(() -> service.readPerson(12345678900L).toString());
        LOGGER.info(() -> String.valueOf(service.createPerson(new Person(12345678900L, "Alguém", 10L))));
        LOGGER.info(() -> service.readPerson(12345678900L).toString());
        LOGGER.info(() -> String.valueOf(service.updatePerson(new Person(12345678900L, "Alguém2", 11L))));
        LOGGER.info(() -> service.readPerson(12345678900L).toString());
        LOGGER.info(() -> String.valueOf(service.deletePerson(12345678900L)));
        LOGGER.info(() -> service.readPerson(123455678900L).toString());
    }
}
