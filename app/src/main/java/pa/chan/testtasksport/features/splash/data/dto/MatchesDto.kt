package pa.chan.testtasksport.features.splash.data.dto

import com.google.gson.annotations.SerializedName

data class MatchesDto(
    val data: List<MatchDto>
)

data class MatchDto(
    val id: String,
    @SerializedName("sport_id")
    val sportId: String,
    @SerializedName("league_id")
    val leagueId: String,
    @SerializedName("season_id")
    val seasonId: String,
    @SerializedName("stage_id")
    val stageId: String,
    @SerializedName("group_id")
    val groupId: String?,
    @SerializedName("aggregate_id")
    val aggregateId: String?,
    @SerializedName("round_id")
    val roundId: String?,
    @SerializedName("state_id")
    val stateId: String?,
    @SerializedName("venue_id")
    val venueId: String?,
    val name: String?,
    @SerializedName("starting_at")
    val startingAt: String?,
    @SerializedName("result_info")
    val resultInfo: String?,
    val leg: String?,
    val details: String?,
    val length: String?,
    val placeholder: String?,
    @SerializedName("has_odds")
    val hasOdds: String?,
    @SerializedName("starting_at_timestamp")
    val startingAtTimestamp: String?,
)