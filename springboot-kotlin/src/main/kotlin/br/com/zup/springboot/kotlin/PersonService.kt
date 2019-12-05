package br.com.zup.springboot.kotlin

class PersonService(val repository: PersonRepository) {
    fun createPerson(person: Person) = repository.save(person)

    fun readPerson(cpf: Long) = repository.findOne(cpf)

    fun updatePerson(person: Person) = repository.save(person)

    fun deletePerson(cpf: Long) = repository.delete(cpf)
}
