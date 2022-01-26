package br.com.apssystem.mercadolivre.repository;

import br.com.apssystem.mercadolivre.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Int> {

    fun findByNameContaining(name: String): List<Customer>
    fun existsByEmail(email: String): Boolean

}