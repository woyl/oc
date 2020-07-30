package com.mkr.login_oc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.mkr.base_oc.config.ARouterPaths

/**
 * 设置用户资料
 */
@Route(path = ARouterPaths.SetUpUserInfoActivity)
class SetUpUserInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_up_user_info)


    }
}