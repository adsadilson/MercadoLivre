package br.com.apssystem.mercadolivre.dto

import br.com.apssystem.mercadolivre.controller.input.BookInput
import br.com.apssystem.mercadolivre.controller.input.BookInputUpdate
import br.com.apssystem.mercadolivre.controller.input.CustomerInput
import br.com.apssystem.mercadolivre.enums.BookStatus
import br.com.apssystem.mercadolivre.model.Book
import br.com.apssystem.mercadolivre.model.Customer

fun CustomerInput.toCustomerModel(): Customer {
    return Customer(name = this.name, email = this.email)
}

fun CustomerInput.toCustomerModel(id: Int): Customer {
    return Customer(id = id, name = this.name, email = this.email)
}

fun BookInput.toBookModel(customer: Customer): Book {
    return Book(name = this.name, price = this.price, status = BookStatus.ATIVO, customer = customer)
}

fun BookInputUpdate.toBookModel(previousValue: Book): Book{
    return Book(
        id = previousValue.id,
        name = this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer

    )
}

