package com.widget.polls.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.widget.polls.R
import com.widget.polls.adapter.ImageAdapter
import com.widget.polls.viewModel.ImageViewModel
import kotlinx.android.synthetic.main.fragment_text_poll.*

class ImageFragment : Fragment(), (Int) -> Unit {


    private lateinit var viewModel: ImageViewModel
    private lateinit var mAdapter: ImageAdapter

    override fun invoke(position: Int) {
        viewModel.isClicked = true
        viewModel.curPos = position;
        if (viewModel.lastPos == -1) {
            viewModel.lastPos = position;
            mAdapter.notifyObj(position, true)
        } else {
            mAdapter.notifyItem(position, true)
            mAdapter.notifyItem(viewModel.lastPos, false)
            viewModel.lastPos = position;
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image_poll, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ImageViewModel::class.java)
        loadPoll();
    }

    private fun loadPoll() {

        viewModel.loadImageList().observe(this, Observer { pollList ->

            val totalVotes = viewModel.getSumVal(pollList);
            mAdapter = ImageAdapter(this, pollList, totalVotes, viewModel.isClicked, viewModel.curPos)
            recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.adapter = mAdapter
        })
    }
}