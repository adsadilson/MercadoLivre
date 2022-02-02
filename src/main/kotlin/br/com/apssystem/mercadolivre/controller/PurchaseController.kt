package br.com.apssystem.mercadolivre.controller

import br.com.apssystem.mercadolivre.controller.request.PurchaseRequest
import br.com.apssystem.mercadolivre.mapper.PurchaseMapper
import br.com.apssystem.mercadolivre.service.PurchaseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController()
@RequestMapping("/purchase")
class PurchaseController(
    private val service: PurchaseService,
    private val mapper: PurchaseMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PurchaseRequest){
        service.create(mapper.toModel(request))
    }
}