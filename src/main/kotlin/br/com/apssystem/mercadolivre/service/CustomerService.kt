package br.com.apssystem.mercadolivre.service

import br.com.apssystem.mercadolivre.controller.input.CustomerInput
import br.com.apssystem.mercadolivre.model.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomerService {

    val customers = mutableListOf<CustomerModel>()

    fun getListAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name) }
        }
        return customers;
    }

    fun getFindByID(id: String): CustomerModel {
        return customers.filter { it.id == id }.first()
    }

    fun create(customer: CustomerModel) {
        val id = gerID()
        customers.add(CustomerModel(id, customer.name, customer.email))
    }

    fun update(id: String, customer: CustomerModel) {
        customers.first { it.id == id }.let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun delete(id: String) {
        customers.removeIf { it.id == id }
    }

    private fun gerID(): String {
        val id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id!!.toInt() + 1
        }.toString()
        return id
    }
}



