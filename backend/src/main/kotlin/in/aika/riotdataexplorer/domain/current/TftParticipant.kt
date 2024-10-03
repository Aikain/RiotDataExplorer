package `in`.aika.riotdataexplorer.domain.current

import com.fasterxml.jackson.annotation.JsonView
import `in`.aika.riotdataexplorer.api.model.data.lol.Champion
import `in`.aika.riotdataexplorer.domain.Account
import `in`.aika.riotdataexplorer.domain.Views

data class TftParticipant(
    @JsonView(Views.CurrentGameGet::class)
    override val account: Account,

    @JsonView(Views.CurrentGameGet::class)
    override val bot: Boolean,

    @JsonView(Views.CurrentGameGet::class)
    override val teamId: Long,
) : Participant()
