package br.com.apssystem.mercadolivre.exceptions

class NotFoundException(
    override val message: String,
    val errorCode: String
): Exception() {
}