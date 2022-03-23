package br.com.apssystem.mercadolivre.controller

import br.com.apssystem.mercadolivre.controller.request.CustomerRequest
import br.com.apssystem.mercadolivre.controller.response.CustomerResponse
import br.com.apssystem.mercadolivre.dto.toModel
import br.com.apssystem.mercadolivre.dto.toResponse
import br.com.apssystem.mercadolivre.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/customers")
class booktroller(
    val service: CustomerService
) {

    @GetMapping
    fun findAll(@RequestParam name: String?): List<CustomerResponse> {
        return service.findAll(name).map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun findByID(@PathVariable id: Int): CustomerResponse {
        return service.findByID(id).toResponse()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid customer: CustomerRequest) {
        service.create(customer.toModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: CustomerRequest) {
        return service.update(id, customer.toModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        service.delete(id)
    }

}
