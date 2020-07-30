package com.mkr.login_oc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.mkr.base_oc.activity.BaseMvpActivity
import com.mkr.base_oc.config.ARouterPaths
import com.mkr.login_oc.contract.LoginContract
import com.mkr.login_oc.presenter.LoginPresenter

/**
 *  输入验证码
 */
@Route(path = ARouterPaths.inputVerificationCodeActivity)
class InputVerificationCodeActivity() : BaseMvpActivity<LoginContract.View,LoginPresenter>() {
    override val layoutId: Int
        get() = R.layout.activity_input_verification_code

    override fun initView(rootView: View) {

    }
}