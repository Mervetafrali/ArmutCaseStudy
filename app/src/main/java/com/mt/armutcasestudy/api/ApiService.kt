package com.mt.armutcasestudy.api

import com.mt.armutcasestudy.helper.Constants
import com.mt.armutcasestudy.model.Service
import com.mt.armutcasestudy.model.ServiceItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getServices():Response<Service>

}