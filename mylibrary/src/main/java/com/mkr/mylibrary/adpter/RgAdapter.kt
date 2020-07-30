package com.mkr.mylibrary.adpter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class RgAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private var fragments : MutableList<Fragment>?= null

    init {
        fragments = mutableListOf()
    }

    fun addFragment(fragment: Fragment) {
        fragments?.add(fragment)
    }

    override fun getItemCount(): Int {
        return fragments?.size!!
    }

    override fun createFragment(position: Int): Fragment {
        return fragments?.get(position)!!
    }

}