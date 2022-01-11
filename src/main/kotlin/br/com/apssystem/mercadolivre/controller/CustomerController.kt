package br.com.apssystem.mercadolivre.controller

import br.com.apssystem.mercadolivre.controller.input.CustomerInput
import br.com.apssystem.mercadolivre.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController {

    val customers = mutableListOf<CustomerModel>()

    @GetMapping
    fun getListAll(): List<CustomerModel>{
        return customers;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: CustomerInput){
        val id = if (customers.isEmpty()){
            1
        }else{
            customers.last().id.toInt() + 1
        }.toString()

        customers.add(CustomerModel(id, customer.name, customer.email))
    }

    @GetMapping("/{idCustomer}")
    fun getCustomer(@PathVariable idCustomer: String ): CustomerModel {
        return customers.filter { it.id == idCustomer }.first()
    }

    @PutMapping("{/idCustomer}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable idCustomer: String, @RequestBody customer: CustomerInput){
        customers.first { it.id == idCustomer }.let {
            it.name = customer.name
            it.email = customer.email
        }
    }

}
