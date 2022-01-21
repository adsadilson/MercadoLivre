package br.com.apssystem.mercadolivre.controller.input

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class BookInput (

    var name: String,

    var price: BigDecimal,

    @JsonAlias("customer_id")
    var customerId: Int

)