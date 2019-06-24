package com.widget.polls.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.widget.polls.R
import com.widget.polls.adapter.viewholder.TextPollViewHolder
import com.widget.polls.model.PollList

class TextPollAdapter(
    val listener: (PollList) -> Unit,
    private val pollList: ArrayList<PollList>,
    private val sum: Int, var flag: Boolean
) :
    RecyclerView.Adapter<TextPollViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextPollViewHolder {
        return TextPollViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_text_poll, parent, false)
        )
    }


    override fun getItemCount(): Int {
        return pollList.size
    }


    override fun onBindViewHolder(holder: TextPollViewHolder, position: Int) {
        return holder.bind(getItem(position), listener, sum, flag)
    }


    private fun getItem(position: Int): PollList {
        return pollList[position]
    }
}