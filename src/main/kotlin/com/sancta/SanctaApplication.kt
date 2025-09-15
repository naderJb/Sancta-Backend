package com.sancta

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SanctaApplication

fun main(args: Array<String>) {
	runApplication<SanctaApplication>(*args)
}
