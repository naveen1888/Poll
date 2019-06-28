package com.widget.polls.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.widget.polls.R
import kotlinx.android.synthetic.main.activity_polls.*
import kotlinx.android.synthetic.main.content_poll.*

class PollActivity : AppCompatActivity() {

    private var textFragment: TextFragment? = null
    private var imageFragment: ImageFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_polls)
        setSupportActionBar(toolbar)
        btnImagePoll.setOnClickListener(clickListener)
        btnTextPoll.setOnClickListener(clickListener)

    }

    private fun showTextFragment() {

        textFragment = TextFragment()
        addFragmentWithBackStack(textFragment!!, R.id.container, "TextFragment")
    }

    private fun showImageFragment() {

        imageFragment = ImageFragment()
        addFragmentWithBackStack(imageFragment!!, R.id.container, "ImageFragment")

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

    private fun addFragmentWithBackStack(fragment: Fragment, layoutResId: Int, tag: String) {

        supportFragmentManager.beginTransaction()
            .add(layoutResId, fragment, tag)
            .addToBackStack(tag)
            .commit()

    }


}