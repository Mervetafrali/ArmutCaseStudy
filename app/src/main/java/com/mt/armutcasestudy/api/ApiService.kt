package com.mt.armutcasestudy.api

import com.mt.armutcasestudy.helper.ServiceConstants
import com.mt.armutcasestudy.model.Home
import com.mt.armutcasestudy.model.Service
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(ServiceConstants.END_POINT_SERVICE)
    suspend fun getServices():Response<Service>

    @GET(ServiceConstants.END_POINT_HOME)
    suspend fun getHome():Response<Home>

}