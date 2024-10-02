package `in`.aika.riotdataexplorer.api.model.data.wrapper

interface DataFiller<Data> {
    fun getFilledData(version: String): Data
}
