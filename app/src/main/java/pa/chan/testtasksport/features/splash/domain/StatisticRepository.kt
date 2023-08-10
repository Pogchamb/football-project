package pa.chan.testtasksport.features.splash.domain

import pa.chan.testtasksport.features.splash.data.dto.PaginationDto

interface StatisticRepository {

    suspend fun loadStartMatchInfo(): PaginationDto

}