package `in`.aika.riotdataexplorer.api.model.lol.event

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type",
    defaultImpl = Unknown::class,
    visible = true,
)
@JsonSubTypes(
    JsonSubTypes.Type(value = PauseEnd::class, name = "PAUSE_END"),
    JsonSubTypes.Type(value = GameEnd::class, name = "GAME_END"),

    JsonSubTypes.Type(value = LevelUp::class, name = "LEVEL_UP"),
    JsonSubTypes.Type(value = SkillLevelUp::class, name = "SKILL_LEVEL_UP"),

    JsonSubTypes.Type(value = ChampionKill::class, name = "CHAMPION_KILL"),
    JsonSubTypes.Type(value = ChampionSpecialKill::class, name = "CHAMPION_SPECIAL_KILL"),
    JsonSubTypes.Type(value = BuildingKill::class, name = "BUILDING_KILL"),

    JsonSubTypes.Type(value = ItemPurchased::class, name = "ITEM_PURCHASED"),
    JsonSubTypes.Type(value = ItemDestroyed::class, name = "ITEM_DESTROYED"),
    JsonSubTypes.Type(value = ItemUndo::class, name = "ITEM_UNDO"),
    JsonSubTypes.Type(value = ItemSold::class, name = "ITEM_SOLD"),

    JsonSubTypes.Type(value = WardPlaced::class, name = "WARD_PLACED"),
    JsonSubTypes.Type(value = WardKill::class, name = "WARD_KILL"),

    JsonSubTypes.Type(value = TurretPlateDestroyed::class, name = "TURRET_PLATE_DESTROYED"),
    JsonSubTypes.Type(value = EliteMonsterKill::class, name = "ELITE_MONSTER_KILL"),
    JsonSubTypes.Type(value = ObjectiveBountyPrestart::class, name = "OBJECTIVE_BOUNTY_PRESTART"),
    JsonSubTypes.Type(value = ObjectiveBountyFinish::class, name = "OBJECTIVE_BOUNTY_FINISH"),
    JsonSubTypes.Type(value = DragonSoulGiven::class, name = "DRAGON_SOUL_GIVEN"),
    JsonSubTypes.Type(value = ChampionTransform::class, name = "CHAMPION_TRANSFORM"),
    JsonSubTypes.Type(value = PauseStart::class, name = "PAUSE_START"),
)
sealed class EventsTimeLineDto : LogIgnoredProperties() {
    abstract val timestamp: Long;
    abstract val type: String;
}
