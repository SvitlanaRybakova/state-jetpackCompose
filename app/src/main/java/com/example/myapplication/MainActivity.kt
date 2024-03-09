package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {

    val viewModel by lazy {ViewModelProvider(this).get(ViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val state by remember { viewModel.state}

            Column(modifier = Modifier.fillMaxSize()) {


                LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f)){
                    items(state.namesListState.size){
                        Text(text = state.namesListState[it])
                    }
                }

                MyTextField(
                    textValue = state.textState,
                    onValueChanged = {
                        viewModel.updateText(it)
                    },
                    onAddClick = {
                        viewModel.updateNameList(state.textState)
                        viewModel.updateText("")
                    }
                )

            }
        }
    }
}

@Composable
fun MyTextField(
    textValue: String,
    onValueChanged: (String) -> Unit,
    onAddClick: ()-> Unit
) {
    TextField(
        value = textValue, onValueChange = {
            onValueChanged(it)
        },
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = {
            Icon(imageVector = Icons.Default.Add, contentDescription = null, modifier = Modifier.clickable{ onAddClick()})
        }
    )
}

