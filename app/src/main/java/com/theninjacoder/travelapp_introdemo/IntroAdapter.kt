package com.theninjacoder.travelapp_introdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class IntroAdapter : ListAdapter<ScreenItems, IntroAdapter.IntroViewHolder>(ScreenItems.ScreenDiff()) {


    inner class IntroViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private val img: ImageView = v.findViewById(R.id.screen_image)
        private val title: TextView = v.findViewById(R.id.screen_title)
        private val content = v.findViewById<TextView>(R.id.screen_content)

        fun bind(item: ScreenItems) {
            img.setImageResource(item.img)
            title.text = item.title
            content.text = item.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        return IntroViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.screen_item, parent, false
                )
        )
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}