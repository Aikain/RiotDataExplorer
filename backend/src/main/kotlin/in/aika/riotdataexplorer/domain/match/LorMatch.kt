package `in`.aika.riotdataexplorer.domain.match

import jakarta.persistence.*
import org.hibernate.annotations.BatchSize
import java.util.*

@Entity
class LorMatch(
    @Column(unique = true, updatable = false)
    val matchId: UUID,

    @Enumerated(EnumType.STRING)
    override val status: MatchStatus = MatchStatus.AVAILABLE,

    @BatchSize(size = 16)
    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "match")
    override val participants: MutableSet<LorParticipant> = mutableSetOf(),
) : Match<LorParticipant>()
