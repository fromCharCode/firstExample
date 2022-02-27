package fcc.uebung.spring.firstExample.repositories

import fcc.uebung.spring.firstExample.model.Publisher
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface PublisherRepository: CrudRepository<Publisher, UUID>