package pa.chan.testtasksport.features.utils.extensions

import pa.chan.testtasksport.features.main_page.domain.model.MatchModel
import pa.chan.testtasksport.features.splash.data.dto.MatchDto
import pa.chan.testtasksport.features.splash.data.entity.MatchEntity

fun MatchDto.toEntity(): MatchEntity = MatchEntity(
    id = this.id,
    name = this.name,
    league = this.leagueId,
    season = this.seasonId,
    startingAt = this.startingAt,
    result = this.resultInfo
)

fun MatchEntity.toModel(): MatchModel = MatchModel(
    id, name, league, season, startingAt, result
)