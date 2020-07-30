package com.mkr.login_oc.contract

import com.mkr.base_oc.mvp.BaseMvpView
import com.mkr.base_oc.mvp.KotlinPresenter
import com.mkr.base_oc.bean.login.LoginBean
import com.mkr.base_oc.bean.login.RegisterBean

interface LoginContract {
    interface View : BaseMvpView {
        fun requestLoginSuccess(loginBean: LoginBean?)

        fun requestError(str: String?)

        fun requestRegisterSuccess(registerBean: RegisterBean?)
    }

    abstract class Presenter : KotlinPresenter<View>() {
        internal abstract fun requestLogin(phone:String,password:String)

        internal abstract fun requestRegister()
    }
}