package br.com.apssystem.mercadolivre.controller

import br.com.apssystem.mercadolivre.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController {

    val customers = mutableListOf<CustomerModel>()

    @GetMapping
    fun getCustomer(): List<CustomerModel>{
        return customers;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: CustomerModel){
        val id = if (customers.isEmpty()){
            1
        }else{
            customers.last().id.toInt() + 1
        }.toString()

        CustomerModel(id, customer.name, customer.email)
        println(custom)
    }
}