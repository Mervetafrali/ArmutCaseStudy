package com.mt.armutcasestudy.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mt.armutcasestudy.model.Service
import com.mt.armutcasestudy.repository.ServiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ServiceViewModel
@Inject
constructor
    (private val repository: ServiceRepository) : ViewModel() {
    private val _response= MutableLiveData<Service>()
    val responseService:LiveData<Service> get()=_response
    init {
        getAllService()
    }
    private fun getAllService()=viewModelScope.launch {
        repository.getServices().let { response ->
            if(response.isSuccessful){
                _response.postValue(response.body())
            }else{
                Log.d("getAllService", "getAllService Err:${response.code()}")
            }
        }
    }
}

