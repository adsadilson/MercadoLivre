package br.com.apssystem.mercadolivre.model

import br.com.apssystem.mercadolivre.enums.BookStatus
import java.math.BigDecimal
import javax.persistence.*

@Entity
data class Book(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null,

    @ManyToOne
    @JoinColumn(name="customer_id")
    var customer: Customer? = null

)