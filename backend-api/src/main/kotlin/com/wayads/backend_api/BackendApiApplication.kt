package com.wayads.backend_api

import com.wayads.presentation.controller.GastronomiaController
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BackendApiApplication

fun main(args: Array<String>) {
	runApplication<BackendApiApplication>(*args)
}
