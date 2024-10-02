package `in`.aika.riotdataexplorer.domain.current

import `in`.aika.riotdataexplorer.api.model.data.lol.Champion
import `in`.aika.riotdataexplorer.domain.Account

sealed class Participant {
    abstract val account: Account
    abstract val bot: Boolean // TODO: always false?
    abstract val teamId: Long
    abstract val champion: Champion
}
