package com.charmist.socketiodemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.charmist.socketiodemo.R
import kotlinx.android.synthetic.main.item_achievement.view.*

class AchievementAdapter() :
    RecyclerView.Adapter<AchievementAdapter.AchievementHolder>() {
    var onItemClick: (s: String) -> Unit = {}

    var values: MutableList<String> = ArrayList(0)
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementHolder {
        val viewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.item_achievement, parent, false)
        return AchievementHolder(
            viewHolder
        ) {
            onItemClick(values[it])
        }
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: AchievementHolder, position: Int) {
        holder.bindUi(values[position])
    }

    class AchievementHolder(
        private val view: View,
        private val onItemClick: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(view) {
        fun bindUi(s: String) {
            view.tv.text = s
            view.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }
    }

}


