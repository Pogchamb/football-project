package pa.chan.testtasksport.features.main_page.data

import pa.chan.testtasksport.features.main_page.domain.MainRepository
import pa.chan.testtasksport.features.main_page.domain.model.MatchModel
import pa.chan.testtasksport.features.splash.data.StatisticLocalDataSource
import pa.chan.testtasksport.features.splash.data.StatisticRemoteDataSource
import pa.chan.testtasksport.features.utils.extensions.toEntity
import pa.chan.testtasksport.features.utils.extensions.toModel
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val statisticRemoteDataSource: StatisticRemoteDataSource,
    private val statisticLocalDataSource: StatisticLocalDataSource
) : MainRepository {
    override suspend fun getStatistic(): List<MatchModel> {
        return statisticLocalDataSource.getStatistic().map {
            it.toModel()
        }
    }

    override suspend fun loadMatchInfo(page: Int): List<MatchModel?> {
        val matchesDtoList = statisticRemoteDataSource.getStatistic(page)
        val matchesEntityList = statisticLocalDataSource.getStatistic()
        val matchesModelList = matchesDtoList.map {
            val matchEntity = it.toEntity()
            if (!matchesEntityList.contains(matchEntity)) {
                statisticLocalDataSource.insertMatch(
                    matchEntity
                )
                matchEntity.toModel()
            } else {
                null
            }
        }
        return matchesModelList
    }

}