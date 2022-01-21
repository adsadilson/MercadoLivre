package br.com.apssystem.mercadolivre.controller.input

import java.math.BigDecimal

data class BookInputUpdate (
    var name: String?,
    var price: BigDecimal?,
)
