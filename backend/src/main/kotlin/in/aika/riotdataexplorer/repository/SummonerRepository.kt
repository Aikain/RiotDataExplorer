package `in`.aika.riotdataexplorer.repository

import `in`.aika.riotdataexplorer.domain.Summoner
import org.springframework.data.jpa.repository.JpaRepository

interface SummonerRepository : JpaRepository<Summoner, String>
