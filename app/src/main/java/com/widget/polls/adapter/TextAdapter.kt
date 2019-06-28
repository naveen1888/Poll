package com.widget.polls.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.widget.polls.adapter.viewholder.TextViewHolder
import com.widget.polls.model.TextList

class TextAdapter(
    private val listener: (Int) -> Unit,
    private val mTextList: ArrayList<TextList>,
    private val mTotalCount: Int, private var mIsClicked: Boolean,
    private var mSelectedPos: Int
) : RecyclerView.Adapter<TextViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TextViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return mTextList.size
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        return holder.bind(getItem(position), position, listener, mTotalCount, mIsClicked, mSelectedPos)
    }


    private fun getItem(position: Int): TextList {
        return mTextList[position]
    }


    fun notifyObj(position: Int, isClicked: Boolean) {
        this.mIsClicked = isClicked;
        this.mSelectedPos = position
        this.mTextList.get(position).selected = isClicked
        notifyDataSetChanged()
    }

    fun notifyItem(position: Int, isClicked: Boolean) {
        if (isClicked) {
            this.mSelectedPos = position
        }
        notifyItemChanged(position);
    }

}