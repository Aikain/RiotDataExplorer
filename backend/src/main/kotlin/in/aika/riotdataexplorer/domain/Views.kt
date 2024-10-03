package `in`.aika.riotdataexplorer.domain

class Views {
    interface AccountList : SummonerList
    interface AccountGet : AccountList

    interface CurrentGameGet : AccountGet

    interface MatchList
    interface MatchGet : MatchList

    interface SummonerList
}
