package com.gjj.test

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gjj.framwork.utils.GLogger
import com.gjj.framwork.utils.logError

/**
 * author: gujingjing
 * created on: 2020/8/17 12:34 PM
 * description:
 */
class MainTestAdapter(val data: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    GLogger {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_view_test, parent, false)
        return object : RecyclerView.ViewHolder(view) {}
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.text)?.text = data[position]
    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)
        logError { "onViewAttachedToWindow-adapterPosition=${holder.adapterPosition}  -itemId=${holder.itemId}" }
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        logError { "onViewDetachedFromWindow-adapterPosition=${holder.adapterPosition}  -itemId=${holder.itemId}" }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        super.onViewRecycled(holder)
        logError { "onViewRecycled-adapterPosition=${holder.adapterPosition}  -itemId=${holder.itemId}" }
    }

    override val logTag: String
        get() = "MainTestAdapter"
}