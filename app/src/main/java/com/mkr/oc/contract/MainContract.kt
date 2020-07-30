package com.mkr.oc.contract

import com.mkr.base_oc.mvp.BaseMvpView

interface MainContract {
    interface View : BaseMvpView {
        fun requestSuccess(str: String?)

        fun requestError(str: String?)

    }
}