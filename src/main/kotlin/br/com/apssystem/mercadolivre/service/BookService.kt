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
    val repository: BookRepository
) {

    fun findListAll(name: String?, pageable: Pageable): Page<Book> {
        name?.let {
            return repository.findByNameContaining(name, pageable)
        }
        return repository.findAll(pageable);
    }

    fun findByID(id: Int): Book {
        return repository.findById(id).orElseThrow {
            NotFoundException(Errors.ML101.message.format(id), Errors.ML101.code)
        }
    }

    fun create(book: Book) {
        repository.save(book)
    }

    fun update(book: Book) {
        repository.save(book)
    }

    fun delete(id: Int) {
        val book = repository.getById(id)
        book.status = BookStatus.CANCELADO
        update(book)
    }

    fun idExists(id: Int): Boolean {
        if (!repository.existsById(id)) {
            throw Exception()
        }
        return true
    }

    fun findActive(pageable: Pageable): Page<Book> {
        return repository.findByStatus(BookStatus.ATIVO, pageable)
    }

    fun findAllByIds(bookIds: Set<Int>): List<Book> {
        return repository.findAllById(bookIds).toList();
    }

    fun purchase(books: MutableList<Book>) {
        books.map { it.status =BookStatus.VENDIDO }
        repository.saveAll(books)
    }

}



