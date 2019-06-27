package com.widget.polls.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.widget.polls.model.PollImageList
import com.widget.polls.model.PollList

class PollViewModel() : ViewModel() {

    private var pollList: MutableLiveData<ArrayList<PollList>> = MutableLiveData()
    private var pollImageList: MutableLiveData<ArrayList<PollImageList>> = MutableLiveData()

    private fun loadPollList(): LiveData<ArrayList<PollList>> {

        val list: ArrayList<PollList> = ArrayList()
        list.add(PollList("For sure! He's done.", 22))
        list.add(PollList("He still has a lot left in tank!", 56))
        list.add(PollList("I'm not interested..", 8))
        list.add(PollList("Who? Is he still playing?", 14))
        pollList.value = list

        return pollList

    }

    fun getPollList(): LiveData<ArrayList<PollList>> {
        return loadPollList()
    }

    fun getSumVal(pollLists: ArrayList<PollList>): Int {
        var sum = 0
        for (i in pollLists) {
            sum += i.value
        }
        return sum

    }

}