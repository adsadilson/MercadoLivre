package br.com.apssystem.mercadolivre.exceptions

class BadRequestException(
    override val message: String,
    val errorCode: String
): Exception() {
}