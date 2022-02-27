package fcc.uebung.spring.firstExample.model

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

@Entity
class Publisher(
    val name: String,
    val addressLine1: String,
    val city: String,
    val state: String,
    val zip: String,
    @OneToMany
    @JoinColumn(name = "publisher_id")
    val books: Set<Book>,
): UUIDBaseEntity() {
    override fun hashCode(): Int {
        return super.hashCode()
    }
}