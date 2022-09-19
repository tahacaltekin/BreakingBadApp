package com.dttcaltekin.breakingbadapp.ui.view

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.dttcaltekin.breakingbadapp.base.BaseFragment
import com.dttcaltekin.breakingbadapp.databinding.FragmentHomeBinding
import com.dttcaltekin.breakingbadapp.ui.adapter.HomeAdapter
import com.dttcaltekin.breakingbadapp.ui.viewmodel.HomeViewModel
import com.dttcaltekin.breakingbadapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate
) {
    override val viewModel by viewModels<HomeViewModel>()
    private var adapter: HomeAdapter? = null

    override fun onCreateFinished() {}

    override fun initializeListeners() {}

    override fun observeEvents() {
        lifecycleScope.launch {
            viewModel.characterList.collect {
                when (it) {
                    is Resource.Success -> {
                        binding.progressBar.isVisible = false
                        it.data?.let { character ->
                            adapter = HomeAdapter(character) { name ->
                                val action =
                                    HomeFragmentDirections.actionHomeFragmentToDetailFragment(name)
                                findNavController().navigate(action)
                            }
                            binding.characterRV.adapter = adapter
                        }
                    }

                    is Resource.Error -> {
                        binding.progressBar.isVisible = false
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    }

                    else -> {
                        binding.progressBar.isVisible = true
                    }
                }
            }
        }
    }
}