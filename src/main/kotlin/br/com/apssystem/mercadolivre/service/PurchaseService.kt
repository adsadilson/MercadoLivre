package br.com.apssystem.mercadolivre.service

import br.com.apssystem.mercadolivre.events.PurchaseEvent
import br.com.apssystem.mercadolivre.model.Purchase
import br.com.apssystem.mercadolivre.repository.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val repository: PurchaseRepository,
    private val applicationEventPublisher: ApplicationEventPublisher,
) {
    fun create(purchase: Purchase){
        repository.save(purchase)
        applicationEventPublisher.publishEvent(PurchaseEvent(this,purchase))
    }

    fun update(purchase: Purchase) {
        repository.save(purchase)
    }
}
