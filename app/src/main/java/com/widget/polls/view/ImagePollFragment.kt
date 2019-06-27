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
import com.widget.polls.adapter.ImagePollAdapter
import com.widget.polls.viewModel.PollImageViewModel
import kotlinx.android.synthetic.main.fragment_text_poll.*

class ImagePollFragment : Fragment(), (Int) -> Unit {

    private lateinit var imageViewModel: PollImageViewModel
    private lateinit var imagePollAdapter: ImagePollAdapter

    override fun invoke(position: Int) {
        imagePollAdapter.setSelected(position)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image_poll, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        imageViewModel = ViewModelProviders.of(this).get(PollImageViewModel::class.java)
        loadPoll();
    }

    private fun loadPoll() {

        imageViewModel.getPollImageList().observe(this, Observer { pollList ->

            val totalVotes = imageViewModel.getSumVal(pollList);
            imagePollAdapter = ImagePollAdapter(this, pollList, totalVotes)
            recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.adapter = imagePollAdapter
        })
    }
}