package `in`.aika.riotdataexplorer.domain.match

import `in`.aika.riotdataexplorer.domain.Account
import jakarta.persistence.Entity

@Entity
class TftParticipant(
    match: TftMatch,
    account: Account,
) : Participant<TftMatch>(match, account)
