package br.com.apssystem.mercadolivre.exceptions

class NegocioException(
    override val message: String,
    val errorCode: String
): RuntimeException(){

}