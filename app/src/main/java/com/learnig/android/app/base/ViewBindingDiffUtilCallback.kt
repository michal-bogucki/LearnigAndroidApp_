package com.learnig.android.app.base

import androidx.recyclerview.widget.DiffUtil
import com.learnig.android.app.data.models.Item

abstract class ViewBindingDiffUtilCallback<T : Item> :
    DiffUtil.ItemCallback<T>()