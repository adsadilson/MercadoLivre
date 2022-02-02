package br.com.apssystem.mercadolivre.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

data class PurchaseRequest(

    @field:NotBlank
    @field:Positive
    @JsonAlias("customer_id")
    val customerId: Int,

    @JsonAlias("book_ids")
    @field:NotBlank
    val bookIds: Set<Int>
)
