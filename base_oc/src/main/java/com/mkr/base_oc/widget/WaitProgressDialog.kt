package com.mkr.base_oc.widget

import android.app.Dialog
import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.widget.TextView
import com.mkr.base_oc.R
import com.mkr.base_oc.helper.UiCoreHelper

class WaitProgressDialog(private val mContext: Context) {
    private var progressBar: Dialog? = null
    private var tv_tips: TextView? = null

    val waitDialog: Dialog?
        get() {
            if (progressBar == null)
                init("Loading", false)
            return progressBar
        }

    val isShowing: Boolean
        get() {
            if (progressBar == null)
                init("Loading", false)
            return progressBar?.isShowing!!
        }

    fun show(tips: String) {
        show("Loading")
    }

    fun show(isCancle: Boolean) {
        show("Loading", isCancle)
    }

    fun show(tips: String = "Loading", isCancle: Boolean = false) {
        init(tips, isCancle)
        progressBar?.show()
    }

    private fun init(tips: String, isCancle: Boolean) {
        var tips = tips
        if (progressBar == null) {
            progressBar = Dialog(mContext, R.style.DialogStyle)
            val view = LayoutInflater.from(mContext)
                .inflate(UiCoreHelper.getProxyA().waitDialogRes(), null)
            progressBar?.setContentView(view)
            tv_tips = view.findViewWithTag("tv_tips")
            if (TextUtils.isEmpty(tips))
                tips = "Loading"
            tv_tips?.text = tips
            progressBar?.setCancelable(isCancle)
            progressBar?.setCanceledOnTouchOutside(false)
        }
    }

    fun dismiss() {
        if (progressBar != null && progressBar!!.isShowing) {
            progressBar?.dismiss()
        }
    }
}