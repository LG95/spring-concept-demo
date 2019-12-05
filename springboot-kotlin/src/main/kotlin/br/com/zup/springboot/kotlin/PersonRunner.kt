package br.com.zup.springboot.kotlin

import org.springframework.boot.CommandLineRunner
import java.util.logging.Logger

class PersonRunner(val service: PersonService) : CommandLineRunner {
    val LOGGER = Logger.getAnonymousLogger()

    override fun run(vararg args: String?) {
        LOGGER.info { service.readPerson(12345678900)?.toString() ?: "NOT FOUND!!!" }
        service.createPerson(Person(12345678900, "Alguém", 10))
        LOGGER.info { service.readPerson(12345678900)?.toString() ?: "NOT FOUND!!!" }
        service.updatePerson(Person(12345678900, "Alguém 2", 12))
        LOGGER.info { service.readPerson(12345678900)?.toString() ?: "NOT FOUND!!!" }
        LOGGER.info { service.deletePerson(12345678900).toString() }
        LOGGER.info { service.readPerson(12345678900)?.toString() ?: "NOT FOUND!!!" }
    }
}
