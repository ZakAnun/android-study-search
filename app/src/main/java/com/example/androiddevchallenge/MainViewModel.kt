package com.example.androiddevchallenge

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var inputText: String by mutableStateOf("")

    /**
     * 是否全为数字
     */
    fun isAllDigit(str: String): Boolean {
        return str.matches(Regex("[0-9]+"))
    }

    /**
     * 是否全为英文
     */
    fun isAllEnglish(str: String): Boolean {
        return str.matches(Regex("[a-zA-Z]+"))
    }

    /**
     * 包含英文和数字
     */
    fun isContainNormal(str: String): Boolean {
        return str.matches(Regex("[a-zA-Z0-9\\u4e00-\\u9fa5]+"))
    }

    /**
     * 是否全为汉字
     */
    fun isAllChinese(str: String): Boolean {
        return str.matches(Regex("[\\u4e00-\\u9fa5]+"))
    }

    fun isInputEmpty(): Boolean {
        return inputText.isEmpty()
    }
}