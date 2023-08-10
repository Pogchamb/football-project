package pa.chan.testtasksport.features.splash.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import pa.chan.testtasksport.R

@AndroidEntryPoint
class SplashFragment : Fragment() {
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadStatistic()

        viewModel.loadLiveData.observe(viewLifecycleOwner) {
            val action = SplashFragmentDirections.actionSplashFragmentToMainFragment(
                it.currentPage.toInt(),
                it.hasMore
            )
            findNavController().navigate(action)

        }
    }
}