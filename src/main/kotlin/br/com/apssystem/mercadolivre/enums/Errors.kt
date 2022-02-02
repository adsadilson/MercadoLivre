package br.com.apssystem.mercadolivre.enums

enum class Errors(val code: String, val message: String) {
    ML001("ML001","Invalid Request"),
    ML101("ML101","Book [%s] not exists"),
    ML102("ML102","Cannot update book with status [%s]"),
    ML201("ML201","Customer [%s] not exists")
}