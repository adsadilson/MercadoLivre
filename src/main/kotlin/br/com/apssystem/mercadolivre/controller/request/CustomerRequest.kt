package br.com.apssystem.mercadolivre.controller.request

import br.com.apssystem.mercadolivre.validation.EmailAvailable
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class CustomerRequest (

    @field:NotBlank(message = "Nome deve ser informado")
    var name: String,

    @field:Email(message = "E-mail deve ser válido")
    @EmailAvailable(message = "E-mail em uso!")
    var email: String,
)