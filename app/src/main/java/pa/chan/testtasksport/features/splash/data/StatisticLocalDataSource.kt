package pa.chan.testtasksport.features.splash.data

import pa.chan.testtasksport.features.splash.data.entity.MatchEntity
import javax.inject.Inject

class StatisticLocalDataSource @Inject constructor(
    private val statisticDao: StatisticDao
) {
    suspend fun getStatistic(): List<MatchEntity> {
        return statisticDao.getStatistic()
    }

    suspend fun insertMatch(matchEntity: MatchEntity) {
        statisticDao.insertStatistic(matchEntity)
    }

    suspend fun deleteStatistic() {
        statisticDao.deleteStatistic()
    }

}