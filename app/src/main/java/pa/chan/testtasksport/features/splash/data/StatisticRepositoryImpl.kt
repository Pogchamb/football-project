package pa.chan.testtasksport.features.splash.data

import pa.chan.testtasksport.features.splash.data.dto.PaginationDto
import pa.chan.testtasksport.features.splash.domain.StatisticRepository
import pa.chan.testtasksport.features.utils.extensions.toEntity
import javax.inject.Inject

class StatisticRepositoryImpl @Inject constructor(
    private val statisticRemoteDataSource: StatisticRemoteDataSource,
    private val statisticLocalDataSource: StatisticLocalDataSource,
    private val prefDataSource: PrefDataSource
) : StatisticRepository {
    override suspend fun loadStartMatchInfo(): PaginationDto {

        return try {
            val matchesDto = statisticRemoteDataSource.getStatistic()
            val matchesEntityList = statisticLocalDataSource.getStatistic()
            matchesDto.data.forEach {
                val matchEntity = it.toEntity()
                if (!matchesEntityList.contains(matchEntity)) statisticLocalDataSource.insertMatch(
                    matchEntity
                )
            }

            if (prefDataSource.getCurrentPage() != 1) {
                prefDataSource.setCurrentPage(matchesDto.pagination.currentPage.toInt())
                prefDataSource.setHasMore(matchesDto.pagination.hasMore)
            }

            matchesDto.pagination
        } catch (e: Exception) {
            throw e
        }

    }

}