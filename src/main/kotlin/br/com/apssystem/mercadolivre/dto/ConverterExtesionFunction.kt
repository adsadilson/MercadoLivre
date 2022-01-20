package br.com.apssystem.mercadolivre.dto

import br.com.apssystem.mercadolivre.controller.input.CustomerInput
import br.com.apssystem.mercadolivre.model.Customer

fun CustomerInput.toCustomerModel(): Customer {
    return Customer(name = this.name, email = this.email)
}

fun CustomerInput.toCustomerModel(id: Int): Customer {
    return Customer(id = id, name = this.name, email = this.email)
}
