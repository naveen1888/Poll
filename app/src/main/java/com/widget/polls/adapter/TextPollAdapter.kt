package com.widget.polls.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.widget.polls.R
import com.widget.polls.adapter.viewholder.TextPollViewHolder

class TextPollAdapter(val _context: Context) : RecyclerView.Adapter<TextPollViewHolder>() {


    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextPollViewHolder {
        return TextPollViewHolder(LayoutInflater.from(_context).inflate(R.layout.item_text_poll, parent, false))
    }


    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: TextPollViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}