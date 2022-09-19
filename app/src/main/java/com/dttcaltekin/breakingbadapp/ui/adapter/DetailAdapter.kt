package com.dttcaltekin.breakingbadapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dttcaltekin.breakingbadapp.databinding.ItemQuoteBinding
import com.dttcaltekin.breakingbadapp.domain.model.Quote

class DetailAdapter(
    private val quotes: Quote
) : RecyclerView.Adapter<DetailAdapter.QuoteViewHolder>() {

    class QuoteViewHolder(val binding: ItemQuoteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = ItemQuoteBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
        return QuoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val currentQuote = quotes[position]
        holder.binding.quote.text = currentQuote.quote
    }

    override fun getItemCount() = quotes.size

}