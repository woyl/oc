package com.mkr.login_oc

import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.mkr.base_oc.activity.BaseMvpActivity
import com.mkr.base_oc.api.App
import com.mkr.base_oc.bean.login.LoginBean
import com.mkr.base_oc.bean.login.RegisterBean
import com.mkr.base_oc.config.ARouterNavigator
import com.mkr.base_oc.config.ARouterPaths
import com.mkr.login_oc.contract.LoginContract
import com.mkr.login_oc.presenter.LoginPresenter
import kotlin.math.log

/**
 * 登录
 */
@Route(path = ARouterPaths.loginActivity)
class LoginActivity : BaseMvpActivity<LoginContract.View, LoginPresenter>(), LoginContract.View {

    override val layoutId: Int
        get() = R.layout.activity_login

    override fun initView(rootView: View) {
        var edPhone: AppCompatEditText = findViewById(R.id.ed_login_phone)

        var btnNext:AppCompatButton = findViewById(R.id.bt_next)

        btnNext.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        super.onClick(v)
        when(v.id){
            R.id.bt_next -> ARouter.getInstance().build(ARouterPaths.inputVerificationCodeActivity).navigation(this,object:NavigationCallback{
                override fun onLost(postcard: Postcard?) {

                    Log.e("TAG", "onLost: "   + postcard)
                }

                override fun onFound(postcard: Postcard?) {

                    Log.e("TAG", "onLost: "  )

                }

                override fun onInterrupt(postcard: Postcard?) {

                    Log.e("TAG", "onLost: "  )
                }

                override fun onArrival(postcard: Postcard?) {

                    Log.e("TAG", "onLost: "  )
                }

            })

        }
    }



    override fun requestLoginSuccess(loginBean: LoginBean?) {
    }

    override fun requestError(str: String?) {
    }

    override fun requestRegisterSuccess(registerBean: RegisterBean?) {
    }




}
