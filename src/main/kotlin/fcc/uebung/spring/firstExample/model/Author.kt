package fcc.uebung.spring.firstExample.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "authors")
data class Author(
    @Column(name = "first_name")
    val firstName: String,
    @Column(name = "last_name")
    val lastName: String,
    @JsonIgnoreProperties("books")
    @ManyToMany(mappedBy = "authors", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val books: Set<Book> = mutableSetOf(),
): UUIDBaseEntity() {
    override fun hashCode(): Int {
        return super.hashCode()
    }
}