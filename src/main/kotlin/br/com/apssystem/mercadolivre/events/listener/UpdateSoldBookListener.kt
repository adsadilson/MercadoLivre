package br.com.apssystem.mercadolivre.events.listener

import br.com.apssystem.mercadolivre.events.PurchaseEvent
import br.com.apssystem.mercadolivre.service.BookService
import br.com.apssystem.mercadolivre.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.*

@Component
class UpdateSoldBookListener(
    private val service: BookService
) {
    @Async
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent){
        service.purchase(purchaseEvent.purchase.books)
    }
}