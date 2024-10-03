package `in`.aika.riotdataexplorer.domain.current

import com.fasterxml.jackson.annotation.JsonView
import `in`.aika.riotdataexplorer.api.model.data.SummonerSpell
import `in`.aika.riotdataexplorer.api.model.data.lol.Champion
import `in`.aika.riotdataexplorer.domain.Account
import `in`.aika.riotdataexplorer.domain.Views

data class LolParticipant(
    @JsonView(Views.CurrentGameGet::class)
    override val account: Account,

    @JsonView(Views.CurrentGameGet::class)
    override val bot: Boolean,

    @JsonView(Views.CurrentGameGet::class)
    override val teamId: Long,

    @JsonView(Views.CurrentGameGet::class)
    val champion: Champion,

    @JsonView(Views.CurrentGameGet::class)
    val summonerSpell1: SummonerSpell,

    @JsonView(Views.CurrentGameGet::class)
    val summonerSpell2: SummonerSpell,

    @JsonView(Views.CurrentGameGet::class)
    val perks: Perks,
) : Participant()
