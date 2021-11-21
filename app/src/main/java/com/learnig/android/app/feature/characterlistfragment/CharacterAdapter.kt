package com.learnig.android.app.feature.characterlistfragment

import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.learnig.android.app.base.BaseAdapter
import com.learnig.android.app.base.GenericItemDiffUtil
import com.learnig.android.app.data.models.Character
import com.learnig.android.app.data.models.Item
import com.learnig.android.app.databinding.ItemCharacterBinding

class CharacterAdapter : BaseAdapter<Item, ItemCharacterBinding>(GenericItemDiffUtil) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewBindingViewHolder<Item, ItemCharacterBinding> {
        val inflater = parent.layoutInflater
        val binding = ItemCharacterBinding.inflate(inflater, parent, false)
        return CharacterViewHolder(binding)
    }


    inner class CharacterViewHolder(binding: ItemCharacterBinding) :
        ViewBindingViewHolder<Item, ItemCharacterBinding>(binding) {
        override fun bind(item: Item) {
            item as Character
            binding.characterName.text = item.name
            binding.characterStatus.text = item.status
            Glide.with(itemView).load(item.url).into(binding.characterImage)

        }
    }
}