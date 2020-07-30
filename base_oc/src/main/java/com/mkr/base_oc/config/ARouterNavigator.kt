package com.mkr.base_oc.config

import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter

/**
 * @Author Novan
 * @create 2020/7/28 11:17
 * @desc  路由跳转
 */
class ARouterNavigator {
    companion object{  // == java static

        fun startLoginActivity(context:Context){
            ARouter.getInstance().build(ARouterPaths.loginActivity).navigation(context)
        }

        fun startInputVerificationCodeActivity(context: Context){
            ARouter.getInstance().build(ARouterPaths.inputVerificationCodeActivity).navigation(context)
        }

    }
}