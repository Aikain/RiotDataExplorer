package `in`.aika.riotdataexplorer.api.model.data.wrapper

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.data.lol.SpellBuff

data class SpellBuffWrapper(
    val spellBuffs: List<SpellBuff>,
) : LogIgnoredProperties()
