package br.com.apssystem.mercadolivre.controller

import br.com.apssystem.mercadolivre.controller.input.BookInput
import br.com.apssystem.mercadolivre.controller.input.BookInputUpdate
import br.com.apssystem.mercadolivre.dto.toBookModel
import br.com.apssystem.mercadolivre.model.Book
import br.com.apssystem.mercadolivre.service.BookService
import br.com.apssystem.mercadolivre.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookController(
    val service: BookService,
    val customerService:  CustomerService
) {

    @GetMapping
    fun getListAll(@RequestParam name: String?): List<Book> {
        return service.getListAll(name)
    }

    @GetMapping("/active")
    fun getFindActive(): List<Book> {
        return service.getFindActive()
    }

    @GetMapping("/{id}")
    fun getFindByID(@PathVariable id: Int): Book {
        return service.getByID(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody book: BookInput) {
        val customer= customerService.getFindByID(book.customerId)
        service.create(book.toBookModel(customer))
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody book: BookInputUpdate) {
        val bookSaved = service.getByID(id)
        return service.update(book.toBookModel(bookSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        service.delete(id)
    }

}
