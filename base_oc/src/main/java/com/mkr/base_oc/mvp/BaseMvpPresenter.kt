package com.mkr.base_oc.mvp

 abstract class BaseMvpPresenter <V : BaseMvpView>{
    var view: V? = null


    fun attchView(v: V) {
        view = v
    }


    open fun detachView() {
        this.view = null
    }
}