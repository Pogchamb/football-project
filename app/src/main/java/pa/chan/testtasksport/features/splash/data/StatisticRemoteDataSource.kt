package pa.chan.testtasksport.features.splash.data

import pa.chan.testtasksport.features.splash.data.dto.MatchDto
import javax.inject.Inject

class StatisticRemoteDataSource @Inject constructor(
    private val statisticApi: StatisticApi
) {
    val TOKEN = "f3lW5z2WNLDijKcgq4qfYUlkI10DS7KWOOExvNVwOOO7MIwEAbdJ80A2e9aR"

    suspend fun getStatistic(page: Int = 1): List<MatchDto> {
        return statisticApi.getStatistic(page.toString(), TOKEN).data
    }
}