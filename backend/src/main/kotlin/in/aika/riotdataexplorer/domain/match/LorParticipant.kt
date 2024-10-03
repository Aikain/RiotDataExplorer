package `in`.aika.riotdataexplorer.domain.match

import `in`.aika.riotdataexplorer.domain.Account
import jakarta.persistence.Entity
import java.util.*

@Entity
class LorParticipant(
    match: LorMatch,
    account: Account,
) : Participant<LorMatch>(match, account)
