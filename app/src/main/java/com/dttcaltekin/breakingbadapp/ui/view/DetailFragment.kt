package com.dttcaltekin.breakingbadapp.ui.view

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.dttcaltekin.breakingbadapp.base.BaseFragment
import com.dttcaltekin.breakingbadapp.databinding.FragmentDetailBinding
import com.dttcaltekin.breakingbadapp.ui.adapter.DetailAdapter
import com.dttcaltekin.breakingbadapp.ui.viewmodel.DetailViewModel
import com.dttcaltekin.breakingbadapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>(
    FragmentDetailBinding::inflate
) {
    override val viewModel by viewModels<DetailViewModel>()
    private val args by navArgs<DetailFragmentArgs>()
    private var adapter: DetailAdapter? = null

    override fun onCreateFinished() {}

    override fun initializeListeners() {}

    override fun observeEvents() {
        viewModel.getQuote(args.name)
        lifecycleScope.launch {
            viewModel.quoteList.collect {
                when (it) {
                    is Resource.Success -> {
                        binding.progressBar.isVisible = false
                        it.data?.let { quotes ->
                            adapter = DetailAdapter()

                            adapter?.updateQuoteList(quotes)
                            binding.quoteRV.adapter = adapter
                        }
                    }

                    is Resource.Error -> {
                        binding.progressBar.isVisible = false
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    }

                    is Resource.Loading -> {
                        binding.progressBar.isVisible = true
                    }
                    else -> {}
                }
            }
        }
    }
}