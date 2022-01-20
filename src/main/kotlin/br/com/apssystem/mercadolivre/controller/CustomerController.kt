package br.com.apssystem.mercadolivre.controller

import br.com.apssystem.mercadolivre.controller.input.CustomerInput
import br.com.apssystem.mercadolivre.dto.toCustomerModel
import br.com.apssystem.mercadolivre.model.Customer
import br.com.apssystem.mercadolivre.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController(
    val service: CustomerService
) {

    @GetMapping
    fun getListAll(@RequestParam name: String?): List<Customer> {
        return service.getListAll(name)
    }

    @GetMapping("/{id}")
    fun getFindByID(@PathVariable id: Int): Customer {
        return service.getFindByID(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: CustomerInput) {
        service.create(customer.toCustomerModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: CustomerInput) {
        return service.update(id, customer.toCustomerModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        service.delete(id)
    }

}
