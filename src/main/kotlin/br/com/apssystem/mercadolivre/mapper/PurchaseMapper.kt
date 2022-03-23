package br.com.apssystem.mercadolivre.mapper

import br.com.apssystem.mercadolivre.controller.request.PurchaseRequest
import br.com.apssystem.mercadolivre.enums.BookStatus
import br.com.apssystem.mercadolivre.exceptions.NegocioException
import br.com.apssystem.mercadolivre.model.Purchase
import br.com.apssystem.mercadolivre.service.BookService
import br.com.apssystem.mercadolivre.service.CustomerService
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
    private val bookService: BookService,
    private val customerService: CustomerService,
) {
    fun toModel(request: PurchaseRequest): Purchase {
        val customer = customerService.findByID(request.customerId)
        val books = bookService.findAllByIds(request.bookIds)
        val bookSold = books.filter { it.status == BookStatus.VENDIDO }
        if (bookSold.isNotEmpty()) {
            throw NegocioException("Exists books sold", "002")
        }

        return Purchase(
            customer = customer,
            books = books.toMutableList(),
            price = books.sumOf { it.price }
        )
    }
}