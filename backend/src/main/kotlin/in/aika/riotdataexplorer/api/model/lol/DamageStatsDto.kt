package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class DamageStatsDto(
    val magicDamageDone: Int,
    val magicDamageDoneToChampions: Int,
    val magicDamageTaken: Int,
    val physicalDamageDone: Int,
    val physicalDamageDoneToChampions: Int,
    val physicalDamageTaken: Int,
    val totalDamageDone: Int,
    val totalDamageDoneToChampions: Int,
    val totalDamageTaken: Int,
    val trueDamageDone: Int,
    val trueDamageDoneToChampions: Int,
    val trueDamageTaken: Int,
) : LogIgnoredProperties()
