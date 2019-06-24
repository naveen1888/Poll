package com.widget.polls.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.widget.polls.model.PollList
import kotlinx.android.synthetic.main.item_text_poll.view.*

class TextPollViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    fun bind(
        pollList: PollList,
        listener: (PollList) -> Unit,
        sum: Int, flag: Boolean
    ) = with(itemView) {
        tvOption.text = pollList.option
        if (flag) {
            tvPollCount.text = pollList.value.toString()
            val double: Double = (pollList.value.toDouble() / sum) * 100
            progressbar.progress = double.toInt()
        }
        itemView.setOnClickListener { listener(pollList) }

    }
}