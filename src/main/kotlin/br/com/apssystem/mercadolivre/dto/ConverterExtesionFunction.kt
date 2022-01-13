package br.com.apssystem.mercadolivre.dto

import br.com.apssystem.mercadolivre.controller.input.CustomerInput
import br.com.apssystem.mercadolivre.model.CustomerModel

fun CustomerInput.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun CustomerInput.toCustomerModel(id: String): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}
