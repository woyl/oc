package com.mkr.message_oc.fragment

import android.view.View
import com.mkr.base_oc.fragment.BaseFragment
import com.mkr.message_oc.R

class MessageFragment :BaseFragment() {
    companion object {
        val messageFragment = MessageFragment()
    }

    override val layoutId: Int
        get() = R.layout.fragment_message

    override fun initView(view: View) {
        mHeadView.visibility = View.GONE
    }

}