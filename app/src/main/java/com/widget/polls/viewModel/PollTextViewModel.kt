package com.widget.polls.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.widget.polls.model.PollImageList
import com.widget.polls.model.PollTextList

class PollTextViewModel : ViewModel() {

    private var pollTextList: MutableLiveData<ArrayList<PollTextList>> = MutableLiveData()
    private var pollImageList: MutableLiveData<ArrayList<PollImageList>> = MutableLiveData()

    private fun loadPollList(): LiveData<ArrayList<PollTextList>> {

        val textList: ArrayList<PollTextList> = ArrayList()
        textList.add(PollTextList("For sure! He's done.", 22))
        textList.add(PollTextList("He still has a lot left in tank!", 56))
        textList.add(PollTextList("I'm not interested..", 8))
        textList.add(PollTextList("Who? Is he still playing?", 14))
        pollTextList.value = textList

        return pollTextList

    }

    fun getPollList(): LiveData<ArrayList<PollTextList>> {
        return loadPollList()
    }

    fun getSumVal(pollTextLists: ArrayList<PollTextList>): Int {
        var sum = 0
        for (i in pollTextLists) {
            sum += i.value
        }
        return sum

    }

}