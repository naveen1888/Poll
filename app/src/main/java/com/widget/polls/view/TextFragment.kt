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
import com.widget.polls.adapter.TextAdapter
import com.widget.polls.model.TextList
import com.widget.polls.viewModel.TextViewModel
import kotlinx.android.synthetic.main.fragment_text_poll.*


class TextFragment : Fragment(), (Int) -> Unit {

    private lateinit var viewModel: TextViewModel
    private lateinit var mAdapter: TextAdapter

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
        return inflater.inflate(R.layout.fragment_text_poll, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        viewModel = ViewModelProviders.of(this).get(TextViewModel::class.java)
        loadPoll()
    }


    private fun loadPoll() {

        viewModel.loadPollList().observe(this, Observer { pollList ->
            val totalVotes = getSumVal(pollList);
            mAdapter = TextAdapter(
                this, pollList, totalVotes, viewModel.isClicked, viewModel.curPos
            )
            recyclerView.adapter = mAdapter

        })
    }

    private fun getSumVal(textLists: ArrayList<TextList>): Int {
        var sum = 0
        for (i in textLists) {
            sum += i.value
        }
        return sum
    }

}