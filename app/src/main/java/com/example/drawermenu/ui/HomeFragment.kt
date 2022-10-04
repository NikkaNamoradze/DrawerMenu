package com.example.drawermenu.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.drawermenu.R
import com.example.drawermenu.adapter.MenuAdapter
import com.example.drawermenu.databinding.FragmentHomeBinding
import com.example.drawermenu.model.ModelItem
import com.example.drawermenu.model.menuList
import com.example.drawermenu.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val adapter by lazy {
        MenuAdapter()
    }

    override fun start() {
        setUpRecycler()
    }

    private fun setUpRecycler(){
        binding.rvMenu.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMenu.adapter = adapter
        adapter.submitList(menuList)
    }

}