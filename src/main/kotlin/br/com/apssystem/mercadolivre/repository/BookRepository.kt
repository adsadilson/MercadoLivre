package br.com.apssystem.mercadolivre.repository;

import br.com.apssystem.mercadolivre.enums.BookStatus
import br.com.apssystem.mercadolivre.model.Book
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository


interface BookRepository : JpaRepository<Book, Int> {

    fun findByNameContaining(name: String,pageable: Pageable): Page<Book>
    fun findByStatus(status: BookStatus, pageable: Pageable): Page<Book>

}