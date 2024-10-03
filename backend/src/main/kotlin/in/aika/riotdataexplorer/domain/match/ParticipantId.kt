package `in`.aika.riotdataexplorer.domain.match

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable
import java.util.UUID

@Embeddable
class ParticipantId(
    @Column(name = "match_id")
    val matchId: UUID,

    @Column(name = "puuid")
    val puuid: String,
) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ParticipantId

        if (matchId != other.matchId) return false
        if (puuid != other.puuid) return false

        return true
    }

    override fun hashCode(): Int {
        var result = matchId.hashCode() ?: 0
        result = 31 * result + puuid.hashCode()
        return result
    }
}
