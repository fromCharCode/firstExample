package fcc.uebung.spring.firstExample.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
open class UUIDBaseEntity(
    @Id
    open var id: UUID = UUID.randomUUID(),
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UUIDBaseEntity) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}