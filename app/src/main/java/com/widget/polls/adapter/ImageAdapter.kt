package com.widget.polls.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.widget.polls.adapter.viewholder.ImageViewHolder
import com.widget.polls.model.ImageList

class ImageAdapter(

    private val listener: (Int) -> Unit,
    private val mImageList: ArrayList<ImageList>,
    private val mTotalCount: Int, private var mIsClicked: Boolean,
    private var mSelectedPos: Int
) : RecyclerView.Adapter<ImageViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ImageViewHolder(inflater, parent)
    }


    override fun getItemCount(): Int {
        return mImageList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        return holder.bind(getItem(position), position, listener, mTotalCount, mIsClicked, mSelectedPos)
    }

    private fun getItem(position: Int): ImageList {
        return mImageList[position]
    }

    fun notifyObj(position: Int, isClicked: Boolean) {
        this.mIsClicked = isClicked;
        this.mSelectedPos = position
        this.mImageList.get(position).selected = isClicked
        notifyDataSetChanged()
    }

    fun notifyItem(position: Int, isClicked: Boolean) {
        if (isClicked) {
            this.mSelectedPos = position
        }
        notifyItemChanged(position);
    }
}