package br.com.apssystem.mercadolivre.dto

import br.com.apssystem.mercadolivre.controller.request.BookRequest
import br.com.apssystem.mercadolivre.controller.request.BookRequestUpdate
import br.com.apssystem.mercadolivre.controller.request.CustomerRequest
import br.com.apssystem.mercadolivre.controller.response.BookResponse
import br.com.apssystem.mercadolivre.controller.response.CustomerResponse
import br.com.apssystem.mercadolivre.enums.BookStatus
import br.com.apssystem.mercadolivre.model.Book
import br.com.apssystem.mercadolivre.model.Customer

fun CustomerRequest.toModel(): Customer {
    return Customer(
        name = this.name,
        email = this.email,
        password = this.password
    )
}

fun CustomerRequest.toModel(id: Int): Customer {
    return Customer(
        id = id,
        name = this.name,
        email = this.email,
        password = this.password
    )
}

fun BookRequest.toModel(customer: Customer): Book {
    return Book(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}

fun BookRequestUpdate.toModel(previousValue: Book): Book {
    return Book(
        id = previousValue.id,
        name = this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer
    )
}

fun Customer.toResponse(): CustomerResponse {
    return CustomerResponse(
        name = this.name,
        email = this.email,
        password = this.password
    )
}

fun Book.toResponse(): BookResponse {
    return BookResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        customer = this.customer,
        status = this.status!!
    )
}

