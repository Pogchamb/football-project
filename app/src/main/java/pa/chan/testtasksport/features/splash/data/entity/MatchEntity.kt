package pa.chan.testtasksport.features.splash.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MatchEntity(
    @PrimaryKey
    val id: String,
    val name: String?,
    val league: String?,
    val season: String?,
    val startingAt: String?,
    val result: String?,
)