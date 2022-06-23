package com.mt.armutcasestudy.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mt.armutcasestudy.R
import com.mt.armutcasestudy.adapter.HomeAdapter
import com.mt.armutcasestudy.adapter.PopularAdapter
import com.mt.armutcasestudy.adapter.PostsAdapter
import com.mt.armutcasestudy.adapter.ServiceAdapter
import com.mt.armutcasestudy.databinding.FragmentHomeBinding
import com.mt.armutcasestudy.model.Home
import com.mt.armutcasestudy.viewmodel.ServiceViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    //private val viewModel:ServiceViewModel by viewModels()
    private lateinit var serviceAdapter: ServiceAdapter
    private lateinit var popularAdapter: PopularAdapter
    private lateinit var postsAdapter: PostsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // val serviceTitles: Array<String> = resources.getStringArray(R.array.serviceTitles)
       // val serviceImages: Array<String> = resources.getStringArray(R.array.serviceImages)
        //setUpRV(serviceTitles,serviceImages)

    }

    /*private fun setUpRV(serviceTitles: Array<String>, serviceImages: Array<String>) {
        serviceAdapter = ServiceAdapter(serviceTitles,serviceImages)
        popularAdapter= PopularAdapter()
        postsAdapter = PostsAdapter()
        binding.recyclerView.apply {
            adapter = serviceAdapter
            layoutManager = GridLayoutManager(activity, 4)
        }
        binding.recyclerViewPopular.apply {
            adapter=popularAdapter
            layoutManager = LinearLayoutManager(
                activity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
        }
        binding.recyclerViewPosts.apply {
            adapter=postsAdapter
            layoutManager = LinearLayoutManager(
                activity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
        }
        viewModel.responseHome.observe(requireActivity()) { listService ->
            serviceAdapter.services = listService.all_services
            popularAdapter.popular=listService.popular
            postsAdapter.posts=listService.posts
            Log.i("tag", listService.popular.toString())
        }


    }
*/

}