package br.com.apssystem.mercadolivre.service

import br.com.apssystem.mercadolivre.model.Purchase
import br.com.apssystem.mercadolivre.repository.PurchaseRepository
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val repository: PurchaseRepository,
) {
    fun create(purchase: Purchase){
        repository.save(purchase)
    }
}
