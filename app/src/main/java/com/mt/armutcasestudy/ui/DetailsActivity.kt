package com.mt.armutcasestudy.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.google.gson.Gson
import com.mt.armutcasestudy.R
import com.mt.armutcasestudy.databinding.ActivityDetailsBinding
import com.mt.armutcasestudy.model.ServiceItem
import com.mt.armutcasestudy.viewmodel.ServiceViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailsBinding
    private  val viewModel: ServiceViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        supportActionBar?.hide()
        binding=ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val gson = Gson()
        val serviceItem:ServiceItem= gson.fromJson(intent.getStringExtra("service"),ServiceItem::class.java)
        setUp(serviceItem)
    }
    private fun setUp(serviceItem:ServiceItem){
        viewModel.responseService.observe(this){listAllService->
            val item: ServiceItem? =listAllService.firstOrNull{ it.id==serviceItem.id }
            binding.imgItem.load(item?.image_url?:serviceItem.image_url ) {
                crossfade(true)
                crossfade(1000)
            }
            binding.prosItem.text= "${item?.pro_count?:serviceItem.pro_count} pros near you"
            binding.avgItem.text= "${item?.average_rating?:serviceItem.average_rating} average rating"
            binding.jobItem.text= "Last month ${item?.completed_jobs_on_last_month?:serviceItem.completed_jobs_on_last_month} ${item?.name?:serviceItem.name} job complated"

        }

    }

}