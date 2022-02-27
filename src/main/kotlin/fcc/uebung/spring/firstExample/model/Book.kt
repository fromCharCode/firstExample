package fcc.uebung.spring.firstExample.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "books")
data class Book(
    @Column(name = "title")
    val title: String,
    @Column(name = "isbn")
    val isbn: String,
    @JsonIgnoreProperties("authors")
    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinTable(
        name =  "author_book",
        joinColumns = [JoinColumn(name = "book_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "author_id", referencedColumnName = "id")],
    )
    val authors: Set<Author>,
    @ManyToOne
    val publisher: Publisher
): UUIDBaseEntity() {
    override fun toString(): String {
        return "([$isbn]: $title)"
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}