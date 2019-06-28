package com.widget.polls.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.widget.polls.R
import com.widget.polls.model.ImageList
import com.widget.polls.model.TextList

class ImageViewModel : ViewModel() {


    var imageList: MutableLiveData<ArrayList<ImageList>>? = null
    var textList: MutableLiveData<ArrayList<TextList>>? = null
    var lastPos: Int = -1;
    var curPos: Int = -1;
    var isClicked: Boolean = false;

    fun loadImageList(): LiveData<ArrayList<ImageList>> {

        if (imageList == null) {
            imageList = MutableLiveData();
            loadTextPoll();
        }
        return imageList as MutableLiveData<ArrayList<ImageList>>

    }


    fun getSumVal(imageLists: ArrayList<ImageList>): Int {
        var sum = 0
        for (i in imageLists) {
            sum += i.value
        }
        return sum

    }

    private fun loadTextPoll() {

        val list: ArrayList<ImageList> = ArrayList()
        list.add(
            ImageList(
                R.drawable.brady,
                "Tom Brady",
                12, false
            )
        )
        list.add(
            ImageList(
                R.drawable.benjamin, "Benjamin Watson",
                184, false
            )
        )
        list.add(
            ImageList(
                R.drawable.patrick,
                "Patrick Peterson",
                21, false
            )
        )

        list.add(
            ImageList(
                R.drawable.mike,
                "Mike Hart ",
                45, false
            )
        )

        imageList?.value = list

    }

}