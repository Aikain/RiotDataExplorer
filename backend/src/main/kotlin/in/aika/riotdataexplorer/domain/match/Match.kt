package `in`.aika.riotdataexplorer.domain.match

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import jakarta.persistence.Entity
import jakarta.persistence.Inheritance
import jakarta.persistence.InheritanceType
import org.springframework.data.jpa.domain.AbstractPersistable
import java.util.*

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
)
@JsonSubTypes(
    JsonSubTypes.Type(value = LolMatch::class, name = "LolMatch"),
    JsonSubTypes.Type(value = LorMatch::class, name = "LorMatch"),
    JsonSubTypes.Type(value = TftMatch::class, name = "TftMatch"),
)
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Match<P> : AbstractPersistable<UUID>() {

    abstract val status: MatchStatus
    abstract val participants: MutableSet<P>

    init {
        id = UUID.randomUUID()
    }
}
