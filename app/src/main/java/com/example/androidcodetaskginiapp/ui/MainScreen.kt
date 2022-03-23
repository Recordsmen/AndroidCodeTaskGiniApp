package com.example.androidcodetaskginiapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.RecyclerViewAdapter
import com.example.androidcodetaskginiapp.R
import com.example.androidcodetaskginiapp.databinding.MainScreenFragmentBinding
import com.example.androidcodetaskginiapp.model.Hit
import com.example.androidcodetaskginiapp.viewModel.MainScreenViewModel

class MainScreen : Fragment() {

    private lateinit var adapter: RecyclerViewAdapter
    private val viewModel: MainScreenViewModel by lazy {
        ViewModelProvider(this)[MainScreenViewModel::class.java]
    }
    lateinit var binding:MainScreenFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainScreenFragmentBinding.inflate(layoutInflater,container,false)
        adapter = RecyclerViewAdapter()
        binding.recyclerView.adapter = adapter
        viewModel.response.observe(viewLifecycleOwner, {
                images -> adapter.setData(images)
        })
        return binding.root
    }



}