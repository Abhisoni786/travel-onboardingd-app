package com.theninjacoder.travelapp_introdemo

import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.DiffUtil

data class ScreenItems(
        val id: Int,
        val title: String,
        val content: String,
        @DrawableRes
        val img: Int
) {

    class ScreenDiff : DiffUtil.ItemCallback<ScreenItems>() {
        override fun areItemsTheSame(oldItem: ScreenItems, newItem: ScreenItems): Boolean = newItem.id == oldItem.id

        override fun areContentsTheSame(oldItem: ScreenItems, newItem: ScreenItems): Boolean = newItem == oldItem
    }

}