package com.mkr.login_oc.presenter

import com.mkr.base_oc.api.ApiHelper
import com.mkr.base_oc.bean.login.LoginBean
import com.mkr.login_oc.contract.LoginContract

class LoginPresenter : LoginContract.Presenter() {

    override fun requestLogin(phone: String, password: String) {
        view?.showWaitDialog()

        launchRequest(
            {
                ApiHelper.api()?.requestLoginOut(phone, password)?.await()
            },
            { loginBean: LoginBean? ->
                view?.requestLoginSuccess(loginBean)

            },
            { errMsg: String? ->
                view?.requestError(errMsg)

            },
            {
                view?.hideWaitDialog()
            })
    }

    override fun requestRegister() {
    }
}