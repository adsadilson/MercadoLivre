package br.com.apssystem.mercadolivre.events.listener

import br.com.apssystem.mercadolivre.events.PurchaseEvent
import br.com.apssystem.mercadolivre.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.*

@Component
class GenerateNfeListener(
    private val service: PurchaseService
) {
    @Async
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent){
        val nfe = UUID.randomUUID().toString()
        val purchase = purchaseEvent.purchase.copy(nfe = nfe)
        service.update(purchase)
    }
}