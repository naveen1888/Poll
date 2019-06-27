package com.widget.polls.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.widget.polls.R
import com.widget.polls.model.PollImageList

class PollImageViewModel() : ViewModel() {

    private var pollImageList: MutableLiveData<ArrayList<PollImageList>> = MutableLiveData()

    private fun loadImagePollList(): LiveData<ArrayList<PollImageList>> {

        val list: ArrayList<PollImageList> = ArrayList()
        list.add(
            PollImageList(
                R.drawable.brady,
                "Tom Brady",
                12
            )
        )
        list.add(
            PollImageList(
                R.drawable.brady, "Tom Brady",
                76
            )
        )
        list.add(
            PollImageList(
                R.drawable.brady,
                "Tom Brady",
                21
            )
        )

        list.add(
            PollImageList(
                R.drawable.brady,
                "Tom Brady",
                21
            )
        )
        pollImageList.value = list
        return pollImageList

    }

    fun getPollImageList(): LiveData<ArrayList<PollImageList>> {
        return loadImagePollList()
    }

    fun getSumVal(pollImageLists: ArrayList<PollImageList>): Int {
        var sum = 0
        for (i in pollImageLists) {
            sum += i.value
        }
        return sum

    }

}