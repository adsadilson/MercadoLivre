package br.com.apssystem.mercadolivre.exceptions

data class ErrorResponse(
    var httpCode: Int,
    var message: String,
    var internalCode: String,
    var fields: List<FieldErrorResponse>?
)