package com.dttcaltekin.breakingbadapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dttcaltekin.breakingbadapp.databinding.ItemCharacterBinding
import com.dttcaltekin.breakingbadapp.domain.model.Character
import com.dttcaltekin.breakingbadapp.domain.model.CharacterItem
import com.dttcaltekin.breakingbadapp.utils.loadImage
import com.dttcaltekin.breakingbadapp.utils.placeHolderProgressBar

class HomeAdapter(
    private val characterList: Character,
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<HomeAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = ItemCharacterBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val currentCharacter = characterList[position]
        holder.binding.apply {
            name.text = currentCharacter.name
            nickName.text = currentCharacter.nickname
            job.text = currentCharacter.occupation[0]
            realName.text = currentCharacter.portrayed

            character.loadImage(
                currentCharacter.img,
                placeHolderProgressBar(holder.itemView.context)
            )

            root.setOnClickListener {
                onClick.invoke(currentCharacter.name)
            }
        }
    }

    override fun getItemCount() = characterList.size
}