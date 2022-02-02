package br.com.apssystem.mercadolivre.service

import br.com.apssystem.mercadolivre.enums.BookStatus
import br.com.apssystem.mercadolivre.enums.Errors
import br.com.apssystem.mercadolivre.exceptions.NotFoundException
import br.com.apssystem.mercadolivre.model.Book
import br.com.apssystem.mercadolivre.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
class BookService(
    val bookRepository: BookRepository
) {

    fun findListAll(name: String?, pageable: Pageable): Page<Book> {
        name?.let {
            return bookRepository.findByNameContaining(name, pageable)
        }
        return bookRepository.findAll(pageable);
    }

    fun findByID(id: Int): Book {
        return bookRepository.findById(id).orElseThrow {
            NotFoundException(Errors.ML101.message.format(id), Errors.ML101.code)
        }
    }

    fun create(book: Book) {
        bookRepository.save(book)
    }

    fun update(book: Book) {
        bookRepository.save(book)
    }

    fun delete(id: Int) {
        val book = bookRepository.getById(id)
        book.status = BookStatus.CANCELADO
        update(book)
    }

    fun idExists(id: Int): Boolean {
        if (!bookRepository.existsById(id!!)) {
            throw Exception()
        }
        return true
    }

    fun findActive(pageable: Pageable): Page<Book> {
        return bookRepository.findByStatus(BookStatus.ATIVO, pageable)
    }

    fun findAllByIds(bookIds: Set<Int>): List<Book> {
        return bookRepository.findAllById(bookIds).toList();
    }

}



