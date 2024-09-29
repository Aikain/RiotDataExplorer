package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ParticipantDto(
    val puuid: String,
    val riotIdGameName: String?,
    val riotIdName: String?,
    val riotIdTagline: String,

    val summonerId: String,
    val summonerLevel: Int,
    val summonerName: String,
    val profileIcon: Int,

    val participantId: Int,
    val teamId: Int,
    val playerSubteamId: Int,

    // Prior to patch 11.4, on Feb 18th, 2021, this field returned invalid championIds. We recommend determining the
    // champion based on the championName field for matches played prior to patch 11.4.
    val championId: Int,
    val championName: String,

    val role: String,
    val lane: String,

    // Both individualPosition and teamPosition are computed by the game server and are different versions of the most
    // likely position played by a player. The individualPosition is the best guess for which position the player
    // actually played in isolation of anything else. The teamPosition is the best guess for which position the player
    // actually played if we add the constraint that each team must have one top player, one jungle, one middle, etc.
    // Generally the recommendation is to use the teamPosition field over the individualPosition field.
    val individualPosition: String,
    val teamPosition: String,

    val perks: PerksDto,
    val summoner1Id: Int,
    val summoner2Id: Int,

    // game

    // This is an offshoot of the OneStone challenge. The code checks if a spell with the same instance ID does the
    // final point of damage to at least 2 Champions. It doesn't matter if they're enemies, but you cannot hurt your
    // friends.
    val gameEndedInEarlySurrender: Boolean,
    val gameEndedInSurrender: Boolean,
    val teamEarlySurrendered: Boolean,
    val win: Boolean,

    val timePlayed: Int,
    val totalTimeSpentDead: Int,

    val timeCCingOthers: Int,
    val totalTimeCCDealt: Int,

    // ???
    val champLevel: Int,
    val champExperience: Int,
    val bountyLevel: Int,

    // ???
    val kills: Int,
    val deaths: Int,
    val assists: Int,

    val doubleKills: Int,
    val tripleKills: Int,
    val quadraKills: Int,
    val pentaKills: Int,
    val killingSprees: Int,
    val largestKillingSpree: Int,
    val largestMultiKill: Int,
    val unrealKills: Int,

    // neutralMinionsKilled = mNeutralMinionsKilled, which is incremented on kills of kPet and kJungleMonster
    val neutralMinionsKilled: Int,

    // totalMillionsKilled = mMinionsKilled, which is only incremented on kills of kTeamMinion, kMeleeLaneMinion,
    // kSuperLaneMinion, kRangedLaneMinion and kSiegeLaneMinion
    val totalMinionsKilled: Int,

    // ???
    val damageDealtToBuildings: Int,
    val damageDealtToObjectives: Int,
    val damageDealtToTurrets: Int,
    val damageSelfMitigated: Int,

    val largestCriticalStrike: Int,
    val longestTimeSpentLiving: Int,
    val magicDamageDealt: Int,
    val magicDamageDealtToChampions: Int,
    val magicDamageTaken: Int,
    val physicalDamageDealt: Int,
    val physicalDamageDealtToChampions: Int,
    val physicalDamageTaken: Int,

    val spell1Casts: Int,
    val spell2Casts: Int,
    val spell3Casts: Int,
    val spell4Casts: Int,
    val summoner1Casts: Int,
    val summoner2Casts: Int,

    val totalAllyJungleMinionsKilled: Int,
    val totalDamageDealt: Int,
    val totalDamageDealtToChampions: Int,
    val totalDamageShieldedOnTeammates: Int,
    val totalDamageTaken: Int,
    val totalEnemyJungleMinionsKilled: Int,

    val trueDamageDealt: Int,
    val trueDamageDealtToChampions: Int,
    val trueDamageTaken: Int,

    // Whenever positive health is applied (which translates to all heals in the game but not things like regeneration),
    // totalHeal is incremented by the amount of health received. This includes healing enemies, jungle monsters,
    // yourself, etc
    val totalHeal: Int,

    // Whenever positive health is applied (which translates to all heals in the game but not things like regeneration),
    // totalHealsOnTeammates is incremented by the amount of health received. This is post modified, so if you heal
    // someone missing 5 health for 100 you will get +5 totalHealsOnTeammates
    val totalHealsOnTeammates: Int,
    val totalUnitsHealed: Int,

    // items?
    val goldEarned: Int,
    val goldSpent: Int,

    val consumablesPurchased: Int,
    val item0: Int,
    val item1: Int,
    val item2: Int,
    val item3: Int,
    val item4: Int,
    val item5: Int,
    val item6: Int,
    val itemsPurchased: Int,

    // vision?
    val visionScore: Int,
    val sightWardsBoughtInGame: Int,
    val visionWardsBoughtInGame: Int,
    val wardsPlaced: Int,
    val detectorWardsPlaced: Int,
    val wardsKilled: Int,

    // objectives?
    val baronKills: Int,
    val dragonKills: Int,

    val firstBloodAssist: Boolean,
    val firstBloodKill: Boolean,
    val firstTowerAssist: Boolean,
    val firstTowerKill: Boolean,

    val inhibitorKills: Int,
    val inhibitorTakedowns: Int,
    val inhibitorsLost: Int,
    val nexusKills: Int,
    val nexusTakedowns: Int,
    val nexusLost: Int,
    val objectivesStolen: Int,
    val objectivesStolenAssists: Int,
    val turretKills: Int,
    val turretTakedowns: Int,
    val turretsLost: Int,

    // pings
    val allInPings: Int, //	Yellow crossed swords
    val assistMePings: Int, // Green flag
    val baitPings: Int,
    val basicPings: Int,
    val dangerPings: Int,
    val commandPings: Int, // Blue generic ping (ALT+click)
    val enemyMissingPings: Int, // Yellow questionmark
    val enemyVisionPings: Int, // Red eyeball
    val holdPings: Int,
    val getBackPings: Int, // Yellow circle with horizontal line
    val needVisionPings: Int, // Green ward
    val onMyWayPings: Int, // Blue arrow pointing at ground
    val pushPings: Int, // Green minion
    val visionClearedPings: Int,

    // other

    // This field is currently only utilized for Kayn's transformations. (Legal values: 0 - None, 1 - Slayer, 2 - Assassin)
    val championTransform: Int,


    // TODO What are these?

    val challenges: ChallengesDto?,
    val eligibleForProgression: Boolean,
    val missions: MissionsDto?,

    val playerScore0: Int,
    val playerScore1: Int,
    val playerScore2: Int,
    val playerScore3: Int,
    val playerScore4: Int,
    val playerScore5: Int,
    val playerScore6: Int,
    val playerScore7: Int,
    val playerScore8: Int,
    val playerScore9: Int,
    val playerScore10: Int,
    val playerScore11: Int,

    val placement: Int,
    val subteamPlacement: Int,

    val playerAugment1: Int,
    val playerAugment2: Int,
    val playerAugment3: Int,
    val playerAugment4: Int,
    val playerAugment5: Int,
    val playerAugment6: Int,
) : LogIgnoredProperties()
