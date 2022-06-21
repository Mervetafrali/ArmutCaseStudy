package com.mt.armutcasestudy.repository

import com.mt.armutcasestudy.api.ApiService
import javax.inject.Inject

class ServiceRepository
@Inject
constructor(private val apiService:ApiService)
{
    suspend fun getServices()=apiService.getServices()

    suspend fun getHome()=apiService.getHome()
}