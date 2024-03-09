package com.example.myapplication

data class ScreenState(
    val textState: String = "",
    val namesListState: MutableList<String> = mutableListOf()
)
