package pa.chan.testtasksport.features.main_page.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pa.chan.testtasksport.databinding.MatchItemBinding
import pa.chan.testtasksport.features.main_page.domain.model.MatchModel


class MainAdapter(private val matchesList: List<MatchModel?>) :
    RecyclerView.Adapter<MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemBinding =
            MatchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = matchesList.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val reposItem = matchesList[position]
        holder.bind(reposItem)
    }
}