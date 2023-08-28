package pa.chan.testtasksport.features.main_page.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pa.chan.testtasksport.features.main_page.domain.GetMatchesUseCase
import pa.chan.testtasksport.features.main_page.domain.LoadNextPageUseCase
import pa.chan.testtasksport.features.main_page.domain.model.MatchModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMatchesUseCase: GetMatchesUseCase,
    private val loadNextPageUseCase: LoadNextPageUseCase
) : ViewModel() {
    private val _matchesLiveData: MutableLiveData<List<MatchModel?>> = MutableLiveData()
    val matchesLiveData: LiveData<List<MatchModel?>>
        get() = _matchesLiveData

    fun fetchData() {
        viewModelScope.launch {
            val matches = getMatchesUseCase()
            _matchesLiveData.postValue(matches)
        }
    }

    fun loadData() {
        viewModelScope.launch {
            val matches = loadNextPageUseCase()
            _matchesLiveData.postValue(matches)
        }
    }

}