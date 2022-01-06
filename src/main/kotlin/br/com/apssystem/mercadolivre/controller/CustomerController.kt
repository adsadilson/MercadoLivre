package br.com.apssystem.mercadolivre.controller

import br.com.apssystem.mercadolivre.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController {

    @GetMapping
    fun getCustomer(): CustomerModel{
        return CustomerModel("1", "Adilson", "ads@yahoo.com.br")
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: CustomerModel){
        println(customer)
    }
}