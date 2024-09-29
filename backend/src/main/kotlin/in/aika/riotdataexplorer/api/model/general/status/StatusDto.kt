package `in`.aika.riotdataexplorer.api.model.general.status

import com.fasterxml.jackson.annotation.JsonAlias
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import java.time.OffsetDateTime

data class StatusDto(
    val id: Int,

    @JsonAlias("maintenance_status")
    val maintenanceStatus: MaintenanceStatus?,

    @JsonAlias("incident_severity")
    val incidentSeverity: IncidentSeverity?,

    val titles: List<ContentDto>,
    val updates: List<UpdateDto>,

    @JsonAlias("created_at")
    val createdAt: OffsetDateTime,

    @JsonAlias("archive_at")
    val archiveAt: OffsetDateTime?,

    @JsonAlias("updated_at")
    val updatedAt: OffsetDateTime?,
    val platforms: List<Platform>,
) : LogIgnoredProperties() {
    enum class IncidentSeverity {
        INFO,
        WARNING,
        CRITICAL,
    }

    enum class MaintenanceStatus {
        SCHEDULED,
        IN_PROGRESS,
        COMPLETE,
    }

    enum class Platform {
        WINDOWS,
        MACOS,
        ANDROID,
        IOS,
        PS4,
        XBONE,
        SWITCH,
    }
}
