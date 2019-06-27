package com.widget.polls.view

import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {


    fun addFragment(fragment: Fragment, layoutResId: Int, tag: String) {
        supportFragmentManager.beginTransaction()
            .add(layoutResId, fragment, tag)
            .commit()
    }

    fun addFragmentWithBackStack(fragment: Fragment, layoutResId: Int, tag: String) {


        supportFragmentManager.beginTransaction()
            .add(layoutResId, fragment, tag)
            .addToBackStack(tag)
            .commit()

    }

}