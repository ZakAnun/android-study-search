package com.example.androiddevchallenge.ui.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.MainViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PageView() {
    val mainViewModel: MainViewModel = viewModel()
    Column {
        SearchView(mainViewModel, currentInputText = mainViewModel.inputText) {
            mainViewModel.inputText = it
        }
        when {
            mainViewModel.isAllDigit(mainViewModel.inputText) -> {
                Text(text = "输入全是数字...",
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth())
            }
            mainViewModel.isAllEnglish(mainViewModel.inputText) -> {
                Text(text = "输入全是英文...",
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth())
            }
            mainViewModel.isAllChinese(mainViewModel.inputText) -> {
                Text(text = "输入全是中文...",
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth())
            }
            mainViewModel.isContainNormal(mainViewModel.inputText) -> {
                Text(text = "输入正常字符...",
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth())
            }
            mainViewModel.isInputEmpty() -> {

            }
            else -> {
                Text(text = "输入其它字符...",
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth())
            }
        }
        if (!mainViewModel.isInputEmpty()) {
            Text(text = "输入内容: ${mainViewModel.inputText}",
                modifier = Modifier.fillMaxWidth().padding(10.dp))
        }
    }
}

@Composable
fun SearchView(mainViewModel: MainViewModel, currentInputText: String, onValueChange: (String) -> Unit = {} ) {

    OutlinedTextField(
//        colors = TextFieldDefaults.textFieldColors(
//            textColor = Color.Black,
//            disabledTextColor = Color.Transparent,
//            backgroundColor = Color.Transparent,
//            focusedIndicatorColor = Color.Black,
//            unfocusedIndicatorColor = Color.Transparent,
//            disabledIndicatorColor = Color.Transparent),
        value = currentInputText,
        onValueChange = {
            onValueChange.invoke(it)
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(5.dp),
        label = {
            Text(text = "点击输入搜索内容")
        },
        placeholder = {
            Text(text = "请输入搜索内容吧")
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.search_icon),
                contentDescription = "搜索图标")
        },
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.search_del),
                contentDescription = "删除图标",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .padding(5.dp)
                    .clickable(onClick = {
                        mainViewModel.inputText = ""
                    }))
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SearchViewPreview() {
    MyTheme {
        val mainViewModel: MainViewModel = viewModel()
        SearchView(mainViewModel = mainViewModel, currentInputText = "") {
            Log.d("PageView", "SearchViewPreview: newInputText = $it")
        }
    }
}