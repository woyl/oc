package com.mkr.base_oc.api

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.mkr.base_oc.R
import com.mkr.base_oc.proxy.IUiCoreProxy

class UiCoreProxyImpl: IUiCoreProxy() {
    override fun loginFragment(): Class<out Fragment> ?{
        return null
    }

    override fun getContext(): Context {
        return App.appContext
    }


    override fun colorPrimary(): Int {
        return R.color.colorPrimary
    }

    override fun colorPrimaryDark(): Int {
        return R.color.colorPrimaryDark
    }

    override fun colorAccent(): Int {
        return R.color.colorAccent
    }

    override fun glidePlaceholderRes(): Int {
        return 0
    }

    override fun waitDialogRes(): Int {
        return R.layout.dialog_wait_progressbar
    }

    override fun colorSchemeResources(): IntArray {
        return intArrayOf(R.color.colorAccent)
    }


    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {

    }

    override fun headerIdRes(): Int {
        return R.layout.layout_title_white_commom
    }


    override fun headerBackId(): Int {
        return R.id.iv_back
    }

    override fun headerTitleId(): Int {
        return R.id.tv_title
    }

    override fun headerRightId(): Int {
        return R.id.tv_right
    }

    override fun headerRightIconId(): Int {
        return R.id.iv_right
    }

    override fun headerBtmLineId(): Int {
        return R.id.view_deader_line
    }
}