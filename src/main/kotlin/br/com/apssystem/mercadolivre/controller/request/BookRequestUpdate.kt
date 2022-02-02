package br.com.apssystem.mercadolivre.controller.request

import java.math.BigDecimal

data class BookRequestUpdate (
    var name: String?,
    var price: BigDecimal?,
)
