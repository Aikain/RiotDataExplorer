package `in`.aika.riotdataexplorer.repository.match

import `in`.aika.riotdataexplorer.domain.match.Match
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import java.io.Serializable
import java.util.UUID

@NoRepositoryBean
interface MatchBaseRepository<M : Match<*>> : JpaRepository<M, UUID>
