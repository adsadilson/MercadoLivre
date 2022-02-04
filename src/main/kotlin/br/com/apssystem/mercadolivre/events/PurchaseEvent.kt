package br.com.apssystem.mercadolivre.events

import br.com.apssystem.mercadolivre.model.Purchase
import org.springframework.context.ApplicationEvent

class PurchaseEvent(
    source: Any,
    val purchase: Purchase,
):ApplicationEvent(source)