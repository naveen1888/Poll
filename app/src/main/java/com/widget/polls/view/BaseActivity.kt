package com.widget.polls.view

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

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