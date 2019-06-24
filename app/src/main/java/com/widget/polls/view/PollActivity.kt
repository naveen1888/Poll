package com.widget.polls.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.widget.polls.R
import com.widget.polls.viewModel.PollViewModel
import kotlinx.android.synthetic.main.activity_polls.*
import kotlinx.android.synthetic.main.content_poll.*

class PollActivity : BaseActivity() {

    private var textPollFragment: TextPollFragment? = null
    private lateinit var pollViewModel: PollViewModel
    private var imagePollFragment: ImagePollFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_polls)
        pollViewModel = PollViewModel()
        setSupportActionBar(toolbar)
        btnImagePoll.setOnClickListener(clickListener)
        btnTextPoll.setOnClickListener(clickListener)

    }

    private fun showTextFragment() {
        textPollFragment = TextPollFragment()
        addFragmentWithBackStack(textPollFragment!!, R.id.container, "TextPollFragment")
    }

    private fun showImageFragment() {
        imagePollFragment = ImagePollFragment()
        addFragmentWithBackStack(imagePollFragment!!, R.id.container, "ImagePollFragment")

    }

    private val clickListener: View.OnClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.btnTextPoll -> {
                showTextFragment()
            }
            R.id.btnImagePoll -> {
                showImageFragment()
            }
        }
    }


}