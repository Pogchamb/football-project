package pa.chan.testtasksport.features.main_page.domain

import pa.chan.testtasksport.features.main_page.domain.model.MatchModel

interface MainRepository {
    suspend fun getStatistic(): List<MatchModel>
    suspend fun loadMatchInfo(): List<MatchModel?>
}