package com.mkr.base_oc.activity

import android.os.Bundle
import com.mkr.base_oc.mvp.BaseMvpPresenter
import com.mkr.base_oc.mvp.BaseMvpView
import com.mkr.base_oc.utils.MvpUtils

abstract class BaseMvpActivity <V : BaseMvpView, P : BaseMvpPresenter<V>> : BaseActivity() {

    var presenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        initMvp()
        super.onCreate(savedInstanceState)
    }

    private fun initMvp() {
        presenter = MvpUtils.getT<P>(this, 1)
        presenter!!.attchView(this as V)
    }

    override fun onDestroy() {
        if (presenter != null) {
            presenter!!.detachView()
            presenter = null
        }
        super.onDestroy()
    }
}

