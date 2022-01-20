package br.com.apssystem.mercadolivre.model

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity(name = "customer")
data class Customer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @NotNull
    @Column(length = 100, nullable = false)
    var name: String,

    @Column(length = 250, nullable = false, unique = true)
    var email: String,
)
