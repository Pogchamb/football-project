package pa.chan.testtasksport.features.main_page.data

import pa.chan.testtasksport.features.main_page.domain.MainRepository
import pa.chan.testtasksport.features.main_page.domain.model.MatchModel
import pa.chan.testtasksport.features.splash.data.PrefDataSource
import pa.chan.testtasksport.features.splash.data.StatisticLocalDataSource
import pa.chan.testtasksport.features.splash.data.StatisticRemoteDataSource
import pa.chan.testtasksport.features.utils.extensions.toEntity
import pa.chan.testtasksport.features.utils.extensions.toModel
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val statisticRemoteDataSource: StatisticRemoteDataSource,
    private val statisticLocalDataSource: StatisticLocalDataSource,
    private val prefDataSource: PrefDataSource
) : MainRepository {
    override suspend fun getStatistic(): List<MatchModel> {
        return statisticLocalDataSource.getStatistic().map {
            it.toModel()
        }
    }

    override suspend fun loadMatchInfo(): List<MatchModel?> {
        val currentPage = prefDataSource.getCurrentPage()
        if (prefDataSource.getHasMore()) prefDataSource.setCurrentPage(currentPage + 1)

        val matchesDtoList = statisticRemoteDataSource.getStatistic(prefDataSource.getCurrentPage())
        prefDataSource.setHasMore(matchesDtoList.pagination.hasMore)
        prefDataSource.setCurrentPage(matchesDtoList.pagination.currentPage.toInt())

        val matchesEntityList = statisticLocalDataSource.getStatistic()
        val matchesModelList = matchesDtoList.data.map {
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