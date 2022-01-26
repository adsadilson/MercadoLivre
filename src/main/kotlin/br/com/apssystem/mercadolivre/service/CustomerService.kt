package br.com.apssystem.mercadolivre.service

import br.com.apssystem.mercadolivre.enums.Errors
import br.com.apssystem.mercadolivre.exceptions.NotFoundException
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
        return customerRepository.findById(id).orElseThrow {
            NotFoundException(Errors.ML201.message.format(id), Errors.ML201.code)
        }
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

    fun emailAvailable(email: String) : Boolean{
        return !customerRepository.existsByEmail(email);
    }

}



