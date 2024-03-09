package com.example.myapplication
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class ViewModel: ViewModel() {
    val state = mutableStateOf(ScreenState())

    fun updateText(newText: String){
        state.value = state.value.copy(textState = newText)
    }

    fun updateNameList(newName: String){
        val currentList = state.value.namesListState
        currentList.add(newName)
        state.value = state.value.copy(namesListState = currentList)
    }
}