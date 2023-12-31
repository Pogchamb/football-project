package pa.chan.testtasksport.features.main_page.domain

import pa.chan.testtasksport.features.main_page.domain.model.MatchModel
import javax.inject.Inject

class GetMatchesUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {

    suspend operator fun invoke(): List<MatchModel> {
        return mainRepository.getStatistic()
    }

}