package com.dttcaltekin.breakingbadapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dttcaltekin.breakingbadapp.databinding.ItemQuoteBinding
import com.dttcaltekin.breakingbadapp.domain.model.Quote

class DetailAdapter : RecyclerView.Adapter<DetailAdapter.QuoteViewHolder>() {

    private var quotes: Quote? = null

    class QuoteViewHolder(val binding: ItemQuoteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = ItemQuoteBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
        return QuoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        if (quotes == null) {
            return
        }

        val currentQuote = quotes!![position]
        holder.binding.quote.text = currentQuote.quote
    }

    fun updateQuoteList(newQuoteList : Quote) {
        quotes = newQuoteList
    }
    override fun getItemCount() = quotes?.size ?: 0

}