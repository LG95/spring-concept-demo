package br.com.zup.injection;

import java.util.ArrayList;

public class Dependency {
    public static void main(String[] args) {
        new PersonRunner(new PersonService(new PersonListRepository(new ArrayList<>()))).run();
    }
}
