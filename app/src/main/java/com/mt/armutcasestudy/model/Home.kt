package com.mt.armutcasestudy.model

data class Home(
    val all_services: List<AllService>,
    val popular: List<Popular>,
    val posts: List<Post>
)