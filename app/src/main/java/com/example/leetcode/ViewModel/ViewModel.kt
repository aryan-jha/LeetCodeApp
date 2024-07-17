package com.example.leetcode.ViewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.leetcode.Network.ApiProvider
import com.example.leetcode.Network.ResponseModels.SolvedResponse
import com.example.leetcode.Network.USERNAME
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel(){

    private val _userStats = mutableStateOf<SolvedResponse?>(null)
//    private val _userStats = MutableStateFlow<SolvedResponse?>(null)
    val userStats: androidx.compose.runtime.State<SolvedResponse?> = _userStats
//    val userStats: StateFlow<SolvedResponse?> get() = _userStats

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: androidx.compose.runtime.State<String?> = _errorMessage

    fun fetchUserStats(username: String) {
        viewModelScope.launch {
            try {
                val response = ApiProvider.provideApi().getSolvedDetails(username)
                _userStats.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Error fetching user stats: ${e.message}"
            }
        }
    }
//
//
//    var state = mutableStateOf("")
//
//    var res = mutableStateOf<SolvedResponse?>(null)
//
//    init {
//        viewModelScope.launch {
//            setDefault()
//            res.value = getUserDetails(user = USERNAME)
//            Log.d("res", "ApiResponse${ res.value }")
//        }
//    }
//
//
//    fun setDefault(){
//        state.value = State.Default.name
//    }
//
//    suspend fun getUserDetails(user: String): SolvedResponse {
//        return ApiProvider.provideApi().getSolvedDetails(user)
//    }

}



sealed class State(var name: String){
    object Default: State("default")
    object Loading: State("loading")
    object Success: State("success")
    object Error: State("error")
}