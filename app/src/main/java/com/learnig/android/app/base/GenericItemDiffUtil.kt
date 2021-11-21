package com.learnig.android.app.base

import androidx.recyclerview.widget.DiffUtil
import com.learnig.android.app.data.models.Item

object GenericItemDiffUtil : ViewBindingDiffUtilCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem.equals(newItem)
}