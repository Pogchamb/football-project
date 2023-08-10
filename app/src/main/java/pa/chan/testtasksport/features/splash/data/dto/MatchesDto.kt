package pa.chan.testtasksport.features.splash.data.dto

import com.google.gson.annotations.SerializedName

data class MatchesDto(
    val data: List<MatchDto>,
    val pagination: PaginationDto
)

data class PaginationDto(
   @SerializedName("current_page")
   val currentPage: String,
   @SerializedName("has_more")
   val hasMore: Boolean
)

data class MatchDto(
    val id: String,
    @SerializedName("league_id")
    val leagueId: String,
    @SerializedName("season_id")
    val seasonId: String,
    @SerializedName("state_id")
    val stateId: String?,
    val name: String?,
    @SerializedName("starting_at")
    val startingAt: String?,
    @SerializedName("result_info")
    val resultInfo: String?,
)