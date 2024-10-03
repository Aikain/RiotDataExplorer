package `in`.aika.riotdataexplorer.domain.match

import `in`.aika.riotdataexplorer.domain.Account
import jakarta.persistence.Entity

@Entity
class LolParticipant(
    match: LolMatch,
    account: Account,
) : Participant<LolMatch>(match, account)
