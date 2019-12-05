package br.com.zup.injection;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class Person implements Serializable {
    private static final long serialVersionUID = -5858892462454778627L;

    private final Long cpf;
    private final String name;
    private final Long age;

    public Person(Long cpf, String name, Long age) {
        this.cpf = cpf;
        this.name = name;
        this.age = age;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public Long getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(cpf, person.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, name, age);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "(", ")")
                .add("cpf=" + cpf)
                .add("name='" + name + "'")
                .add("age=" + age)
                .toString();
    }
}
