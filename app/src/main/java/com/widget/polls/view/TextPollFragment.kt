package com.widget.polls.view

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.widget.polls.R
import com.widget.polls.adapter.TextPollAdapter
import com.widget.polls.viewModel.PollViewModel
import kotlinx.android.synthetic.main.fragment_text_poll.*


class TextPollFragment : Fragment(), (Int) -> Unit {

    private var layoutManagerSavedState: Parcelable? = null
    private lateinit var pollViewModel: PollViewModel
    private lateinit var textPollAdapter: TextPollAdapter

    override fun invoke(position: Int) {

        textPollAdapter.setSelected(position)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_text_poll, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        pollViewModel = ViewModelProviders.of(this).get(PollViewModel::class.java)
        loadPoll();
    }

    private fun loadPoll() {
        pollViewModel.getPollList().observe(this, Observer { pollList ->

            val totalVotes = pollViewModel.getSumVal(pollList);
            textPollAdapter = TextPollAdapter(this, pollList, totalVotes)
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter = textPollAdapter
        })
    }


}