package com.widget.polls.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.widget.polls.R
import com.widget.polls.viewModel.PollViewModel
import kotlinx.android.synthetic.main.fragment_text_poll.*

class TextPollFragment : Fragment() {

    private lateinit var pollViewModel: PollViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View? = inflater.inflate(R.layout.fragment_text_poll, container, false)
        pollViewModel = ViewModelProviders.of(this).get(PollViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity is AppCompatActivity) {
            (activity as AppCompatActivity).setSupportActionBar(toolbar)
        }
    }
}