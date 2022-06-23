package com.mt.armutcasestudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson
import com.mt.armutcasestudy.R
import com.mt.armutcasestudy.model.ServiceItem
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import org.w3c.dom.Text

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        supportActionBar?.hide()
        val gson = Gson()
        val serviceItem:ServiceItem= gson.fromJson(intent.getStringExtra("service"),ServiceItem::class.java)
        val imageView: ImageView = findViewById(R.id.img)
        val pros: TextView = findViewById(R.id.pros)
        val avg: TextView = findViewById(R.id.avg)
        val job: TextView = findViewById(R.id.job)
        Picasso.get()
            .load(serviceItem.image_url)
            .into(imageView)
        pros.text= "${serviceItem.pro_count} pros near you"
        avg.text= "${serviceItem.average_rating} average rating"
        job.text= "Last month ${serviceItem.completed_jobs_on_last_month} ${serviceItem.name.toString()} job complated"

    }
}