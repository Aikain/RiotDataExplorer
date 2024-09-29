package `in`.aika.riotdataexplorer.domain

class Views {
    interface AccountList
    interface AccountGet : AccountList, SummonerList

    interface SummonerList
}
