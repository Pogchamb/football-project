package pa.chan.testtasksport.features.splash.domain

import pa.chan.testtasksport.features.splash.data.dto.PaginationDto
import javax.inject.Inject

class LoadStatisticUseCase @Inject constructor(
    private val statisticRepository: StatisticRepository
) {

    suspend operator fun invoke(): PaginationDto {
        return statisticRepository.loadStartMatchInfo()
    }

}