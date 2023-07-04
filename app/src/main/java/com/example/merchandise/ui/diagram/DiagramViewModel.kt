package com.example.merchandise.ui.diagram

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DiagramViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is diagram Fragment"
    }
    val text: LiveData<String> = _text
}