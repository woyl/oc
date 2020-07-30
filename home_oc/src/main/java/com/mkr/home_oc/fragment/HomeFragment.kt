package com.mkr.home_oc.fragment

import android.view.View
import com.mkr.base_oc.fragment.BaseFragment
import com.mkr.home_oc.R

class HomeFragment :BaseFragment() {

    companion object {
        val homeFragment = HomeFragment()
    }

    override val layoutId: Int
        get() = R.layout.fragment_home

    override fun initView(view: View) {
        mHeadView.visibility = View.GONE
    }
}