package com.widget.polls.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.widget.polls.model.TextList

class TextViewModel : ViewModel() {


    var textList: MutableLiveData<ArrayList<TextList>>? = null
    var lastPos: Int = -1;
    var curPos: Int = -1;
    var isClicked: Boolean = false;

    fun loadPollList(): LiveData<ArrayList<TextList>> {

        if (textList == null) {
            textList = MutableLiveData();
            loadTextPoll();
        }
        return textList as MutableLiveData<ArrayList<TextList>>

    }

    private fun loadTextPoll() {

        val list: ArrayList<TextList> = ArrayList()
        list.add(TextList("For sure! He's done.", 22, false))
        list.add(TextList("He still has a lot left in tank!", 56, false))
        list.add(TextList("I'm not interested..", 8, false))
        list.add(TextList("Who? Is he still playing?", 14, false))

        textList?.value = list

    }


}