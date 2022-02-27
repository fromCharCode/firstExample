package fcc.uebung.spring.firstExample.repositories

import fcc.uebung.spring.firstExample.model.Book
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID
import javax.transaction.Transactional

@Repository
interface BookRepository: CrudRepository<Book, UUID>