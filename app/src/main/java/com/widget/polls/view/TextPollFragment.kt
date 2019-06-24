package com.widget.polls.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.widget.polls.R
import com.widget.polls.adapter.TextPollAdapter
import com.widget.polls.model.PollList
import com.widget.polls.viewModel.PollViewModel
import kotlinx.android.synthetic.main.fragment_text_poll.*

class TextPollFragment : Fragment(), (PollList) -> Unit {


    private lateinit var pollViewModel: PollViewModel
    private val pollList = ArrayList<PollList>()
    private lateinit var textPollAdapter: TextPollAdapter
    private var flag: Boolean = false;
    override fun invoke(pollList: PollList) {

        pollList.isSelected = true
        textPollAdapter.flag =true
        textPollAdapter.notifyDataSetChanged()

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View? = inflater.inflate(R.layout.fragment_text_poll, container, false)
        pollViewModel = ViewModelProviders.of(this).get(PollViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pollList.add(PollList("For sure! He's done.", 12, false))
        pollList.add(PollList("He still has a lot left in tank!", 64, false))
        pollList.add(PollList("I'm not interested..", 40, false))
        pollList.add(PollList("Who? Is he still playing?", 78, false))

        var sum = 0
        for (i in pollList) {
            sum += i.value
        }
        textPollAdapter = TextPollAdapter(this, pollList, sum, flag)
        recyclerView.adapter = textPollAdapter
        recyclerView.layoutManager = LinearLayoutManager(activity)

    }
}