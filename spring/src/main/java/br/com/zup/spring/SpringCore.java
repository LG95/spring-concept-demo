package br.com.zup.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCore {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("br.com.zup.spring");
        context.getBean(PersonRunner.class).run();
    }
}
