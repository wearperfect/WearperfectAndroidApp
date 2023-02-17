package com.wearperfect.android.app.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wearperfect.android.app.constant.network.RequestState
import com.wearperfect.android.app.data.model.FeedPost
import com.wearperfect.android.app.data.repository.FeedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(private val feedRepository: FeedRepository) : ViewModel() {

    private val _feedPostList = MutableStateFlow<RequestState<List<FeedPost>>>(RequestState.Idle)
    val feedPostList: StateFlow<RequestState<List<FeedPost>>> = _feedPostList

    fun getFeed() {
        _feedPostList.value = RequestState.Loading
        try {
            viewModelScope.launch {
                val response = feedRepository.getFeed()
                if(response != null && response.toString().isNotEmpty()){
                    _feedPostList.value = RequestState.Success(response)
                }else{
                    _feedPostList.value = RequestState.Error(Exception("Invalid Response."))
                }
            }
        } catch (e: Exception) {
            Log.i("FeedRepository", "getFeed: Exception Occurred. ${e.message}")
            _feedPostList.value = RequestState.Error(e)
        }
    }
}