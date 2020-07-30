package com.mkr.mine_oc.fragment

import android.view.View
import com.mkr.base_oc.fragment.BaseFragment
import com.mkr.mine_oc.R

class MineFragment :BaseFragment() {

    companion object {
        val mineFragment = MineFragment()
    }
    override val layoutId: Int
        get() = R.layout.fragment_mine

    override fun initView(view: View) {
        mHeadView.visibility = View.GONE
    }
}