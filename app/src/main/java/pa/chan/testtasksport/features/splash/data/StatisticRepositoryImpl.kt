package pa.chan.testtasksport.features.splash.data

import pa.chan.testtasksport.features.splash.domain.StatisticRepository
import pa.chan.testtasksport.features.utils.extensions.toEntity
import javax.inject.Inject

class StatisticRepositoryImpl @Inject constructor(
    private val statisticRemoteDataSource: StatisticRemoteDataSource,
    private val statisticLocalDataSource: StatisticLocalDataSource
) : StatisticRepository {
    override suspend fun loadStartMatchInfo(): Boolean {

        return try {
            val matchesDtoList = statisticRemoteDataSource.getStatistic()
            val matchesEntityList = statisticLocalDataSource.getStatistic()
            matchesDtoList.forEach {
                val matchEntity = it.toEntity()
                if (!matchesEntityList.contains(matchEntity)) statisticLocalDataSource.insertMatch(
                    matchEntity
                )
            }
            true
        } catch (e: Exception) {
            e.message
            false
        }

    }

}