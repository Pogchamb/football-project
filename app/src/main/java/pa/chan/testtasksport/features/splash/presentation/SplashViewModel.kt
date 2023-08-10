package pa.chan.testtasksport.features.splash.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pa.chan.testtasksport.features.splash.data.dto.PaginationDto
import pa.chan.testtasksport.features.splash.domain.LoadStatisticUseCase
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val loadStatisticUseCase: LoadStatisticUseCase
): ViewModel() {

    private val _loadLiveData: MutableLiveData<PaginationDto> = MutableLiveData()
    val loadLiveData: LiveData<PaginationDto>
        get() = _loadLiveData


    fun loadStatistic() {
        viewModelScope.launch {
            val pagination = loadStatisticUseCase()
            _loadLiveData.postValue(pagination)
        }
    }

}