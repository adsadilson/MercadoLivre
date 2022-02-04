package br.com.apssystem.mercadolivre.model

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "purchase")
data class Purchase(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: Customer,

    @ManyToMany
    @JoinTable(name = "purchase_book",
        joinColumns =[JoinColumn(name = "purchase_id")],
        inverseJoinColumns = [JoinColumn(name = "book_id")])
    var books: MutableList<Book>,

    @Column
    var nfe: String?= null,

    @Column
    var price: BigDecimal,

    @Column(name = "created_at")
    var createdAt: LocalDateTime = LocalDateTime.now()
)
