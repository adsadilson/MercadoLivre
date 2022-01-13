package br.com.apssystem.mercadolivre.controller

import br.com.apssystem.mercadolivre.controller.input.CustomerInput
import br.com.apssystem.mercadolivre.dto.toCustomerModel
import br.com.apssystem.mercadolivre.model.CustomerModel
import br.com.apssystem.mercadolivre.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController(
    val service: CustomerService
) {

    @GetMapping
    fun getListAll(@RequestParam name: String?): List<CustomerModel> {
        return service.getListAll(name)
    }

    @GetMapping("/{id}")
    fun getFindByID(@PathVariable id: String): CustomerModel {
        return service.getFindByID(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: CustomerInput) {
        service.create(customer.toCustomerModel())
    }

    @PutMapping("{/idCustomer}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @RequestBody customer: CustomerInput) {
        return service.update(id, customer.toCustomerModel(id))
    }

    @DeleteMapping("{/idCustomer}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        service.delete(id)
    }

}
