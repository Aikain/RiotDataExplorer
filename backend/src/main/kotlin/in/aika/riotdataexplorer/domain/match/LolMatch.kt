package `in`.aika.riotdataexplorer.domain.match

import jakarta.persistence.*
import org.hibernate.annotations.BatchSize

@Entity
class LolMatch(
    @Column(unique = true, updatable = false)
    val matchId: String,

    @Enumerated(EnumType.STRING)
    override val status: MatchStatus = MatchStatus.AVAILABLE,

    @BatchSize(size = 16)
    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "match")
    override val participants: MutableSet<LolParticipant> = mutableSetOf(),
) : Match<LolParticipant>()
