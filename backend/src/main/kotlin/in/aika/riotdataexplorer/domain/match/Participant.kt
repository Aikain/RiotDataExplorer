package `in`.aika.riotdataexplorer.domain.match

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import `in`.aika.riotdataexplorer.domain.Account
import jakarta.persistence.*

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
)
@JsonSubTypes(
    JsonSubTypes.Type(value = LolParticipant::class, name = "LolParticipant"),
    JsonSubTypes.Type(value = LorParticipant::class, name = "LorParticipant"),
    JsonSubTypes.Type(value = TftParticipant::class, name = "TftParticipant"),
)
@MappedSuperclass
sealed class Participant<M : Match<*>>(
    @ManyToOne(cascade = [CascadeType.DETACH])
    @MapsId("matchId")
    @JoinColumn(name = "match_id")
    val match: M,

    @ManyToOne(cascade = [CascadeType.DETACH])
    @MapsId("puuid")
    @JoinColumn(name = "puuid")
    val account: Account,
) {
    @EmbeddedId
    val id: ParticipantId = ParticipantId(match.id!!, account.puuid)
}
