package com.example.chatapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapp.adapter_recycler_view.UserRecyclerViewAdapter
import com.example.chatapp.base.BaseFragment
import com.example.chatapp.data.User
import com.example.chatapp.databinding.FragmentHomeBinding
import com.example.chatapp.view_model.HomeViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private lateinit var adapter:UserRecyclerViewAdapter
    private val viewModel:HomeViewModel by viewModels()
    override fun start() {
        drawRv()
    }

    private fun drawRv() = with(binding){
        adapter = UserRecyclerViewAdapter()
        homeRv.layoutManager = LinearLayoutManager(requireContext())
        homeRv.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.userList.collect{
                    adapter.submitList(it)
                }
            }
        }

    }
}