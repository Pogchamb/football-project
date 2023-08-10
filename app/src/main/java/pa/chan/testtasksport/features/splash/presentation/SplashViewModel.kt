package pa.chan.testtasksport.features.splash.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pa.chan.testtasksport.features.splash.domain.LoadStatisticUseCase
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val loadStatisticUseCase: LoadStatisticUseCase
): ViewModel() {

    private val _loadLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val loadLiveData: LiveData<Boolean>
        get() = _loadLiveData


    fun loadStatistic() {
        viewModelScope.launch {
            val load = loadStatisticUseCase()
            _loadLiveData.postValue(load)
        }
    }


}