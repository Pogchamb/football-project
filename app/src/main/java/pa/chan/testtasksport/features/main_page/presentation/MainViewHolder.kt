package pa.chan.testtasksport.features.main_page.presentation

import androidx.recyclerview.widget.RecyclerView
import pa.chan.testtasksport.databinding.MatchItemBinding
import pa.chan.testtasksport.features.main_page.domain.model.MatchModel

class MainViewHolder (
    private val matchItemBinding: MatchItemBinding,
) : RecyclerView.ViewHolder(matchItemBinding.root) {


    fun bind(matchModel: MatchModel?) {
        matchItemBinding.matchName.text = matchModel?.name
        matchItemBinding.resultInfo.text = matchModel?.result
        matchItemBinding.startingAt.text = matchModel?.startingAt
        matchItemBinding.league.text = matchModel?.league
        matchItemBinding.season.text = matchModel?.season

    }
}