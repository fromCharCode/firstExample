package fcc.uebung.spring.firstExample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FirstExampleApplication

fun main(args: Array<String>) {
	println("Hello World")
	runApplication<FirstExampleApplication>(*args)
}
