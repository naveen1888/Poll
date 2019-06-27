package com.widget.polls.viewmodel

import com.widget.polls.viewModel.PollViewModel
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class TextPollTest {

    private lateinit var viewModel: PollViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = PollViewModel()


    }

    @Test
    fun testPerformCalculation() {
        
    }


}

