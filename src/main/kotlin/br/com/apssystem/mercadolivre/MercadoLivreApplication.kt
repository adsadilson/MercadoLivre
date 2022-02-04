package br.com.apssystem.mercadolivre

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class MercadoLivreApplication

fun main(args: Array<String>) {
	runApplication<MercadoLivreApplication>(*args)
}
