package br.com.apssystem.mercadolivre.controller

import br.com.apssystem.mercadolivre.controller.input.BookInput
import br.com.apssystem.mercadolivre.controller.input.BookInputUpdate
import br.com.apssystem.mercadolivre.controller.response.BookResponse
import br.com.apssystem.mercadolivre.dto.toModel
import br.com.apssystem.mercadolivre.dto.toResponse
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
    fun listAll(@RequestParam name: String?): List<BookResponse> {
        return service.findListAll(name).map { it.toResponse() }
    }

    @GetMapping("/active")
    fun findActive(): List<BookResponse> {
        return service.findActive().map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun findByID(@PathVariable id: Int): BookResponse {
        return service.findByID(id).toResponse()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody book: BookInput) {
        val customer= customerService.getFindByID(book.customerId)
        service.create(book.toModel(customer))
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody book: BookInputUpdate) {
        val bookSaved = service.findByID(id)
        return service.update(book.toModel(bookSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        service.delete(id)
    }

}
