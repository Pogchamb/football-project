package pa.chan.testtasksport.features.main_page.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import pa.chan.testtasksport.databinding.FragmentMainBinding
import pa.chan.testtasksport.databinding.ToolbarBinding

@AndroidEntryPoint
class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModels()

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding

    private var _toolbarBinding: ToolbarBinding? = null
    private val toolbarBinding get() = _toolbarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        _toolbarBinding = binding?.toolbar
        val view = binding?.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        _toolbarBinding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.recyclerView?.layoutManager = LinearLayoutManager(requireContext())

        viewModel.matchesLiveData.observe(viewLifecycleOwner) {
            binding?.recyclerView?.adapter = MainAdapter(it)
        }

        viewModel.fetchData()

    }
}