package com.widget.polls.viewmodel

import com.widget.polls.viewModel.PollTextViewModel
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class TextPollTest {

    private lateinit var textViewModel: PollTextViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        textViewModel = PollTextViewModel()


    }

    @Test
    fun testPerformCalculation() {
        
    }


}

