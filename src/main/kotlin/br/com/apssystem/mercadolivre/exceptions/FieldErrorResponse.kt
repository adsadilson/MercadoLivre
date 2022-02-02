package br.com.apssystem.mercadolivre.exceptions

data class FieldErrorResponse(
    var message: String,
    var field: String)
