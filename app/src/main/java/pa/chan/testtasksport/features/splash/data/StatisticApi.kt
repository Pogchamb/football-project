package pa.chan.testtasksport.features.splash.data

import pa.chan.testtasksport.features.splash.data.dto.MatchesDto
import retrofit2.http.GET
import retrofit2.http.Path

interface StatisticApi {
    @GET("/fixtures?page={page}&api_token={token}")
    suspend fun getStatistic(
        @Path(value = "page") page: String,
        @Path(value = "token") token: String
    ): MatchesDto

}