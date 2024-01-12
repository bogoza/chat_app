package com.example.chatapp.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatapp.data.User
import com.example.chatapp.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel:ViewModel() {
    private val _userList = MutableStateFlow<List<User>>(emptyList())
    val userList: StateFlow<List<User>> = _userList
    fun getPost(){
        viewModelScope.launch {
            _userList.value = RetrofitInstance.retrofit.getPost()
        }
    }
    init {
        getPost()
    }
}