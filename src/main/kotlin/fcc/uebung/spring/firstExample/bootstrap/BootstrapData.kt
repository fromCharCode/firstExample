package fcc.uebung.spring.firstExample.bootstrap

import fcc.uebung.spring.firstExample.model.Author
import fcc.uebung.spring.firstExample.model.Book
import fcc.uebung.spring.firstExample.model.Publisher
import fcc.uebung.spring.firstExample.repositories.AuthorRepository
import fcc.uebung.spring.firstExample.repositories.BookRepository
import fcc.uebung.spring.firstExample.repositories.PublisherRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class BootstrapData(
    val authorRepository: AuthorRepository,
    val bookRepository: BookRepository,
    val publisherRepository: PublisherRepository,
): CommandLineRunner {
    override fun run(vararg args: String?) {

        val publisher = Publisher(
            name = "Sandstein Kommunikation GmbH",
            addressLine1 = "Goetheallee 6",
            city = "Dresden",
            state = "Germany",
            zip = "01309",
            emptySet()
        )
        publisherRepository.save(publisher)

        val publisher2 = Publisher(
            name = "Thalia Bücher GmbH",
            addressLine1 = "An den Speichern 8",
            city = "Münster",
            state = "Germany",
            zip = "48157",
            emptySet()
        )
        publisherRepository.save(publisher2)

        println(publisherRepository.findAll().map { it.name })

        val author = Author("Anne", "Dubbers", emptySet())
        val book = Book("Aus der Geschichte eines Dresdner Stadtteils: Löbtau", "978-3-937199-48-1", setOf(author), publisher)

        authorRepository.save(author)
        bookRepository.save(book)

        val author2 = Author("Gustave", "Le Bon", emptySet())
        val book2 = Book("Psychologie der Massen", "9783520099167", setOf(author2), publisher2)
        val book3 = Book("Psychologie des Sozialismus", "9783749758807 ", setOf(author2), publisher2)

        authorRepository.save(author2)
        bookRepository.save(book2)
        bookRepository.save(book3)

        val authors = authorRepository.findAll()
        val publishers = publisherRepository.findAll()

        println("Amount of authors: ${authorRepository.count()}")
        println("Amount of all books: ${bookRepository.count()}")
        for (auth in authors){
            println("${auth.firstName} ${auth.lastName} has written: ${auth.books.map { it.title }} ")
        }

        for (pub in publishers){
            println("${pub.name} has published: ${pub.books.map { it.title }}")
        }
    }
}