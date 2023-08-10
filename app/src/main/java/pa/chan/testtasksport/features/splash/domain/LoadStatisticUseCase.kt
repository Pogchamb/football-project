package pa.chan.testtasksport.features.splash.domain

import javax.inject.Inject

class LoadStatisticUseCase @Inject constructor(
    private val statisticRepository: StatisticRepository
) {

    suspend operator fun invoke() {
        statisticRepository.setMatchesInfo()
    }

}