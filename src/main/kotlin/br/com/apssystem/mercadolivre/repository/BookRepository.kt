package br.com.apssystem.mercadolivre.repository;

import br.com.apssystem.mercadolivre.enums.BookStatus
import br.com.apssystem.mercadolivre.model.Book
import br.com.apssystem.mercadolivre.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Int> {

    fun findByNameContaining(name: String): List<Book>
    fun findByStatus(status: BookStatus): List<Book>

}