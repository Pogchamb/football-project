package pa.chan.testtasksport.features.splash.data

import pa.chan.testtasksport.features.splash.data.dto.MatchesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface StatisticApi {
    @GET("fixtures")
    suspend fun getStatistic(
        @Query("page") page : String,
        @Query("api_token") token : String
    ): MatchesDto

}