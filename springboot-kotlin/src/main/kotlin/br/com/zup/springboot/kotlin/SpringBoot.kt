package br.com.zup.springboot.kotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class SpringBoot

fun main() {
    SpringApplication.run(SpringBoot::class.java)
}
