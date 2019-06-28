package com.widget.polls.adapter.viewholder

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.widget.polls.R
import com.widget.polls.model.TextList

class TextViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_text_poll, parent, false)) {

    private var mOption: TextView? = null
    private var mPollCount: TextView? = null
    private var mProgressBar: ProgressBar? = null
    private var mLayout: RelativeLayout? = null

    init {
        mOption = itemView.findViewById(R.id.tvOption)
        mPollCount = itemView.findViewById(R.id.tvPollCount)
        mProgressBar = itemView.findViewById(R.id.progressbar)
        mLayout = itemView.findViewById(R.id.layout)
    }

    fun bind(
        textList: TextList, position: Int,
        listener: (Int) -> Unit,
        totalCount: Int, isClicked: Boolean, selectedPos: Int
    ) {

        mOption?.text = textList.option
        if (isClicked) {

            mPollCount?.text = textList.value.toString()
            val double: Double = (textList.value.toDouble() / totalCount) * 100

            mProgressBar?.progress = double.toInt();
            val drawable: Drawable?
            if (selectedPos == position) {
                mLayout?.isSelected = true
                drawable = ContextCompat.getDrawable(itemView.context, R.drawable.seekbar_progress)
            } else {
                mLayout?.isSelected = false
                drawable = ContextCompat.getDrawable(itemView.context, R.drawable.seekbar_progress_black)
            }
            mProgressBar?.progressDrawable = drawable
        }

        itemView.setOnClickListener { listener(position) }

    }

}


