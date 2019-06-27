package com.widget.polls.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.widget.polls.adapter.viewholder.TextPollViewHolder
import com.widget.polls.model.PollList

class TextPollAdapter(

    private val listener: (Int) -> Unit,
    private val pollList: ArrayList<PollList>,
    private val sum: Int
) : RecyclerView.Adapter<TextPollViewHolder>() {

    private var flag: Boolean = false
    private var mSelectionPos = -1;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextPollViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TextPollViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return pollList.size
    }

    override fun onBindViewHolder(holder: TextPollViewHolder, position: Int) {
        return holder.bind(getItem(position), position, listener, sum, flag, mSelectionPos)
    }


    private fun getItem(position: Int): PollList {
        return pollList[position]
    }

    fun setSelected(position: Int) {
        mSelectionPos = position
        flag = true
        notifyDataSetChanged()
    }
}