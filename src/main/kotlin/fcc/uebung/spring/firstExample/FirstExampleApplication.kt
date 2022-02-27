package fcc.uebung.spring.firstExample

import fcc.uebung.spring.firstExample.bootstrap.BootstrapData
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class FirstExampleApplication

fun main(args: Array<String>) {
	println("Hello World")
	runApplication<FirstExampleApplication>(*args)
}
