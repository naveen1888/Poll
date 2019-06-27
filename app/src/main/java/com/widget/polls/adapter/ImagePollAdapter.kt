package com.widget.polls.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.widget.polls.adapter.viewholder.ImagePollViewHolder
import com.widget.polls.model.PollImageList

class ImagePollAdapter(

    private val listener: (Int) -> Unit,
    private val pollList: ArrayList<PollImageList>,
    private val sum: Int
) : RecyclerView.Adapter<ImagePollViewHolder>() {

    private var flag: Boolean = false
    private var mSelectionPos = -1;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagePollViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ImagePollViewHolder(inflater, parent)
    }


    override fun getItemCount(): Int {
        return pollList.size
    }

    override fun onBindViewHolder(holder: ImagePollViewHolder, position: Int) {
        return holder.bind(getItem(position), position, listener, sum, flag, mSelectionPos)
    }

    private fun getItem(position: Int): PollImageList {
        return pollList[position]
    }

    fun setSelected(position: Int) {
        mSelectionPos = position
        flag = true
        notifyDataSetChanged()
    }
}