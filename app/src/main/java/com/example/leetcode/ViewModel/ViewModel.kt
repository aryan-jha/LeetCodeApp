package com.example.leetcode.ViewModel

import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel(){



}



sealed class State(var name: String){
    object Default: State("default")
    object Loading: State("loading")
    object Success: State("success")
    object Error: State("error")
}