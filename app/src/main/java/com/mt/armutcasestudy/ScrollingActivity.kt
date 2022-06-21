package com.mt.armutcasestudy

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mt.armutcasestudy.adapter.HomeAdapter
import com.mt.armutcasestudy.adapter.PopularAdapter
import com.mt.armutcasestudy.adapter.PostsAdapter
import com.mt.armutcasestudy.adapter.ServiceAdapter
import com.mt.armutcasestudy.databinding.ActivityScrollingBinding
import com.mt.armutcasestudy.viewmodel.ServiceViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScrollingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScrollingBinding
    private val viewModel: ServiceViewModel by viewModels()
    private lateinit var serviceAdapter: ServiceAdapter
    private lateinit var popularAdapter: PopularAdapter
    private lateinit var postsAdapter: PostsAdapter

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        setUpRV()

    }

    private fun setUpRV() {
        serviceAdapter = ServiceAdapter()
        popularAdapter= PopularAdapter()
        postsAdapter = PostsAdapter()
        binding.recyclerView.apply {
            adapter = serviceAdapter
            layoutManager = LinearLayoutManager(
                this@ScrollingActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
        }
        binding.recyclerViewPopular.apply {
            adapter=popularAdapter
            layoutManager = LinearLayoutManager(
                this@ScrollingActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
        }
        binding.recyclerViewPosts.apply {
            adapter=postsAdapter
            layoutManager = LinearLayoutManager(
                this@ScrollingActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
        }
        viewModel.responseService.observe(this) { listService ->
            serviceAdapter.services = listService
        }
        viewModel.responseHome.observe(this) { listService ->
            popularAdapter.popular=listService.popular
            postsAdapter.posts=listService.posts
            Log.i("tag", listService.popular.toString())
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