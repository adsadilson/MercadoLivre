package br.com.apssystem.mercadolivre.service

import br.com.apssystem.mercadolivre.model.Customer
import br.com.apssystem.mercadolivre.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {

    fun getListAll(name: String?): List<Customer> {
        name?.let {
            return customerRepository.findByNameContaining(name)
        }
        return customerRepository.findAll().toList();
    }

    fun getFindByID(id: Int): Customer {
        return customerRepository.findById(id).get()
     }

    fun create(customer: Customer) {
        customerRepository.save(customer)
    }

    fun update(id: Int, customer: Customer) {
        if(!customerRepository.existsById(id!!)){
            throw Exception()
        }
        customerRepository.save(customer)
    }

    fun delete(id: Int) {
        customerRepository.deleteById(id)
    }

}



