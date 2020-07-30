package com.mkr.base_oc.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mkr.base_oc.mvp.BaseMvpPresenter
import com.mkr.base_oc.mvp.BaseMvpView
import com.mkr.base_oc.utils.MvpUtils

abstract class BaseMvpFragment <V : BaseMvpView, P : BaseMvpPresenter<V>> : BaseFragment() {
     var presenter: P? = null
     private fun initMvp() {
         presenter = MvpUtils.getT<P>(this, 1)
         presenter!!.attchView(this as V)
     }

     override fun onCreateView(
         inflater: LayoutInflater,
         container: ViewGroup?,
         savedInstanceState: Bundle?
     ): View? {
         initMvp()
         return super.onCreateView(inflater, container, savedInstanceState)
     }

     override fun onDestroyView() {
         if (presenter != null) {
             presenter!!.detachView()
             presenter = null
         }
         super.onDestroyView()
     }
}