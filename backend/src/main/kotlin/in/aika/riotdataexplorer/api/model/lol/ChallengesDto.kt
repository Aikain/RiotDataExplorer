package `in`.aika.riotdataexplorer.api.model.lol

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

// TODO: cleanup
data class ChallengesDto(
    @JsonProperty("12AssistStreakCount")
    val twelweAssistStreakCount: Int,
    val baronBuffGoldAdvantageOverThreshold: Int,
    val controlWardTimeCoverageInRiverOrEnemyHalf: Float,
    val earliestBaron: Int,
    val earliestDragonTakedown: Int,
    val earliestElderDragon: Int,
    val earlyLaningPhaseGoldExpAdvantage: Int,
    val fasterSupportQuestCompletion: Int,
    val fastestLegendary: Int,
    val hadAfkTeammate: Int,
    val highestChampionDamage: Int,
    val highestCrowdControlScore: Int,
    val highestWardKills: Int,
    val junglerKillsEarlyJungle: Int,
    val killsOnLanersEarlyJungleAsJungler: Int,
    val laningPhaseGoldExpAdvantage: Int,
    val legendaryCount: Int,
    val maxCsAdvantageOnLaneOpponent: Float,
    val maxLevelLeadLaneOpponent: Int,
    val mostWardsDestroyedOneSweeper: Int,
    val mythicItemUsed: Int,
    val playedChampSelectPosition: Int,
    val soloTurretsLategame: Int,
    val takedownsFirst25Minutes: Int,
    val teleportTakedowns: Int,
    val thirdInhibitorDestroyedTime: Int,
    val threeWardsOneSweeperCount: Int,
    val visionScoreAdvantageLaneOpponent: Float,
    val InfernalScalePickup: Int,
    val fistBumpParticipation: Int,
    val voidMonsterKill: Int,
    val abilityUses: Int,
    val acesBefore15Minutes: Int,
    val alliedJungleMonsterKills: Float,
    val baronTakedowns: Int,
    val blastConeOppositeOpponentCount: Int,
    val bountyGold: Int,
    val buffsStolen: Int,
    val completeSupportQuestInTime: Int,
    val controlWardsPlaced: Int,
    val damagePerMinute: Float,
    val damageTakenOnTeamPercentage: Float,
    val dancedWithRiftHerald: Int,
    val deathsByEnemyChamps: Int,
    val dodgeSkillShotsSmallWindow: Int,
    val doubleAces: Int,
    val dragonTakedowns: Int,
    val legendaryItemUsed: List<Int>,
    val effectiveHealAndShielding: Float,
    val elderDragonKillsWithOpposingSoul: Int,
    val elderDragonMultikills: Int,
    val enemyChampionImmobilizations: Int,
    val enemyJungleMonsterKills: Float,
    val epicMonsterKillsNearEnemyJungler: Int,
    val epicMonsterKillsWithin30SecondsOfSpawn: Int,
    val epicMonsterSteals: Int,
    val epicMonsterStolenWithoutSmite: Int,
    val firstTurretKilled: Int,
    val firstTurretKilledTime: Float,
    val flawlessAces: Int,
    val fullTeamTakedown: Int,
    val gameLength: Float,
    val getTakedownsInAllLanesEarlyJungleAsLaner: Int,
    val goldPerMinute: Float,
    val hadOpenNexus: Int,
    val immobilizeAndKillWithAlly: Int,
    val initialBuffCount: Int,
    val initialCrabCount: Int,
    val jungleCsBefore10Minutes: Float,
    val junglerTakedownsNearDamagedEpicMonster: Int,
    val kda: Float,
    val killAfterHiddenWithAlly: Int,
    val killedChampTookFullTeamDamageSurvived: Int,
    val killingSprees: Int,
    val killParticipation: Float,
    val killsNearEnemyTurret: Int,
    val killsOnOtherLanesEarlyJungleAsLaner: Int,
    val killsOnRecentlyHealedByAramPack: Int,
    val killsUnderOwnTurret: Int,
    val killsWithHelpFromEpicMonster: Int,
    val knockEnemyIntoTeamAndKill: Int,
    val kTurretsDestroyedBeforePlatesFall: Int,
    val landSkillShotsEarlyGame: Int,
    val laneMinionsFirst10Minutes: Int,
    val lostAnInhibitor: Int,
    val maxKillDeficit: Int,
    val mejaisFullStackInTime: Int,
    val moreEnemyJungleThanOpponent: Float,

    // This is an offshoot of the OneStone challenge. The code checks if a spell with the same instance ID does the
    // final point of damage to at least 2 Champions. It doesn't matter if they're enemies, but you cannot hurt your
    // friends.
    val multiKillOneSpell: Int,	
    val multikills: Int,
    val multikillsAfterAggressiveFlash: Int,
    val multiTurretRiftHeraldCount: Int,
    val outerTurretExecutesBefore10Minutes: Int,
    val outnumberedKills: Int,
    val outnumberedNexusKill: Int,
    val perfectDragonSoulsTaken: Int,
    val perfectGame: Int,
    val pickKillWithAlly: Int,
    val poroExplosions: Int,
    val quickCleanse: Int,
    val quickFirstTurret: Int,
    val quickSoloKills: Int,
    val riftHeraldTakedowns: Int,
    val saveAllyFromDeath: Int,
    val scuttleCrabKills: Int,
    val shortestTimeToAceFromFirstTakedown: Float,
    val skillshotsDodged: Int,
    val skillshotsHit: Int,
    val snowballsHit: Int,
    val soloBaronKills: Int,

    @JsonAlias("SWARM_DefeatAatrox")
    val SWARMDefeatAatrox: Int,

    @JsonAlias("SWARM_DefeatBriar")
    val SWARMDefeatBriar: Int,

    @JsonAlias("SWARM_DefeatMiniBosses")
    val SWARMDefeatMiniBosses: Int,

    @JsonAlias("SWARM_EvolveWeapon")
    val SWARMEvolveWeapon: Int,

    @JsonAlias("SWARM_Have3Passives")
    val SWARMHave3Passives: Int,

    @JsonAlias("SWARM_KillEnemy")
    val SWARMKillEnemy: Int,

    @JsonAlias("SWARM_PickupGold")
    val SWARMPickupGold: Float,

    @JsonAlias("SWARM_ReachLevel50")
    val SWARMReachLevel50: Int,

    @JsonAlias("SWARM_Survive15Min")
    val SWARMSurvive15Min: Int,

    @JsonAlias("SWARM_WinWith5EvolvedWeapons")
    val SWARMWinWith5EvolvedWeapons: Int,

    val soloKills: Int,
    val stealthWardsPlaced: Int,
    val survivedSingleDigitHpCount: Int,
    val survivedThreeImmobilizesInFight: Int,
    val takedownOnFirstTurret: Int,
    val takedowns: Int,
    val takedownsAfterGainingLevelAdvantage: Int,
    val takedownsBeforeJungleMinionSpawn: Int,
    val takedownsFirstXMinutes: Int,
    val takedownsInAlcove: Int,
    val takedownsInEnemyFountain: Int,
    val teamBaronKills: Int,
    val teamDamagePercentage: Float,
    val teamElderDragonKills: Int,
    val teamRiftHeraldKills: Int,
    val tookLargeDamageSurvived: Int,
    val turretPlatesTaken: Int,

    // Any player who damages a tower that is destroyed within 30 seconds of a Rift Herald charge will receive credit.
    // A player who does not damage the tower will not receive credit.
    val turretsTakenWithRiftHerald: Int,	
    val turretTakedowns: Int,
    val twentyMinionsIn3SecondsCount: Int,
    val twoWardsOneSweeperCount: Int,
    val unseenRecalls: Int,
    val visionScorePerMinute: Float,
    val wardsGuarded: Int,
    val wardTakedowns: Int,
    val wardTakedownsBefore20M: Int,
) : LogIgnoredProperties()
