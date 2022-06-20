package com.mt.armutcasestudy.model

data class ServiceItem(
    val average_rating: Double,
    val completed_jobs_on_last_month: Int,
    val id: Int,
    val image_url: String,
    val long_name: String,
    val name: String,
    val pro_count: Int,
    val service_id: Int
)