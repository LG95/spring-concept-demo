package br.com.zup.springboot.kotlin

import org.springframework.stereotype.Component

@Component
class PersonRepository(val people: MutableList<Person>) {
    fun save(person: Person) {
        val i = people.indexOf(person)

        if (i >= 0) {
            people[i] = person
        } else {
            people.add(person)
        }
    }

    fun findOne(cpf: Long) = people.find { it.cpf == cpf }

    fun delete(cpf: Long) = people.removeIf { it.cpf == cpf }
}
