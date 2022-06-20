package com.mt.armutcasestudy

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mt.armutcasestudy.adapter.ServiceAdapter
import com.mt.armutcasestudy.databinding.ActivityScrollingBinding
import com.mt.armutcasestudy.viewmodel.ServiceViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScrollingActivity : AppCompatActivity() {
private lateinit var binding: ActivityScrollingBinding
private val viewModel:ServiceViewModel by viewModels()
    private lateinit var serviceAdapter: ServiceAdapter
private lateinit var searchView: SearchView


    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        setUpRV()

    }
    private fun setUpRV() {
        serviceAdapter= ServiceAdapter()
        binding.recyclerView.apply {
            adapter = serviceAdapter
            layoutManager = LinearLayoutManager(
                this@ScrollingActivity, LinearLayoutManager.HORIZONTAL,
                false
            )

            setHasFixedSize(true)
        }


        viewModel.responseService.observe(this) { listService ->
            serviceAdapter.services = listService
        }


    }
override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}