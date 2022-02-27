package fcc.uebung.spring.firstExample.repositories

import fcc.uebung.spring.firstExample.model.Author
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID
import javax.transaction.Transactional

@Repository
interface AuthorRepository: CrudRepository<Author, UUID>