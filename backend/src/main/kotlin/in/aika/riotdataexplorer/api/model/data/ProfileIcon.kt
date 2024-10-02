package `in`.aika.riotdataexplorer.api.model.data

import com.fasterxml.jackson.annotation.JsonView
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.data.general.Image
import `in`.aika.riotdataexplorer.api.model.data.wrapper.DataFiller
import `in`.aika.riotdataexplorer.domain.Views

@JsonView(Views.SummonerList::class)
data class ProfileIcon(
    val id: String,
    val image: Image,
) : LogIgnoredProperties(), DataFiller<ProfileIcon> {

    override fun getFilledData(version: String): ProfileIcon = this.apply {
        image.updateUrls(version)
    }
}
