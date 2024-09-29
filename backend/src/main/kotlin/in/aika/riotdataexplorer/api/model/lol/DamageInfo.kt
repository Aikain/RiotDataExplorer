package `in`.aika.riotdataexplorer.api.model.lol

data class DamageInfo(
    val participantId: Int,

    val magicDamage: Int,
    val physicalDamage: Int,
    val trueDamage: Int,

    val name: String,
    val basic: Boolean,
    val spellName: String,
    val spellSlot: Int,
    val type: String, // TODO: enum? OTHER; ...
)
