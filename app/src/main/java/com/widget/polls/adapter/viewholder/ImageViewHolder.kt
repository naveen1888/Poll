package com.widget.polls.adapter.viewholder

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.widget.polls.R
import com.widget.polls.model.ImageList

class ImageViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_image_poll, parent, false)) {

    private var mName: TextView? = null
    private var mImageView: ImageView? = null
    private var mPollCount: TextView? = null
    private var mProgressBar: ProgressBar? = null
    private var mLayout: RelativeLayout? = null

    init {
        mName = itemView.findViewById(R.id.tvName)
        mImageView = itemView.findViewById(R.id.imageView)
        mPollCount = itemView.findViewById(R.id.tvPollCount)
        mProgressBar = itemView.findViewById(R.id.progressbar)
        mLayout = itemView.findViewById(R.id.layout)
    }

    fun bind(
        list: ImageList, position: Int,
        listener: (Int) -> Unit,
        totalCount: Int, isClicked: Boolean, selectedPos: Int
    ) {

        mName?.text = list.name
        mImageView?.setImageResource(list.drawable)

        if (isClicked) {
            mPollCount?.text = list.value.toString()
            val double: Double = (list.value.toDouble() / totalCount) * 100
            mProgressBar?.progress = double.toInt()
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


