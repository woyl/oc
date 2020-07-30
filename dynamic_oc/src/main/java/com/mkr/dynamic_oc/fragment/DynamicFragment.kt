package com.mkr.dynamic_oc.fragment

import android.view.View
import com.mkr.base_oc.fragment.BaseFragment
import com.mkr.dynamic_oc.R

class DynamicFragment :BaseFragment() {

    companion object {
        val dynamicFragment = DynamicFragment()
    }

    override val layoutId: Int
        get() = R.layout.fragment_dynamic

    override fun initView(view: View) {
        mHeadView.visibility = View.GONE
    }

}