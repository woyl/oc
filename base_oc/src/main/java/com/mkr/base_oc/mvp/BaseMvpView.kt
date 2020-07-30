package com.mkr.base_oc.mvp

import android.app.Dialog
import com.mkr.base_oc.activity.BaseActivity
import com.mkr.base_oc.fragment.BaseFragment

interface BaseMvpView {
    fun isWaitDialogShow(): Boolean

    fun getWaitDialog(): Dialog

    fun getmFragment(): BaseFragment?

    fun showWaitDialog()

    fun showWaitDialog(message: String)

    fun showWaitDialog(message: String, cancelable: Boolean)

    fun getmActivity(): BaseActivity

    fun hideWaitDialog()

    fun showToast(msg: String?)

    fun showToast(strId: Int)

    fun showStatusEmptyView(emptyMessage: String)

    fun showStatusErrorView(emptyMessage: String)

    fun showStatusLoadingView(loadingMessage: String)

    fun showStatusLoadingView(loadingMessage: String, isHasMinTime: Boolean)

    fun hideStatusView()
}