package com.mkr.base_oc.api

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.BuildConfig
import com.alibaba.android.arouter.launcher.ARouter
import com.mkr.base_oc.helper.UiCoreHelper

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = this
        initUiCoreProxy()

        init()
    }

    private fun init() {
        ARouter.openLog()     // 打印日志
        ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        //路由初始化
        ARouter.init(this)
    }

    companion object {
        lateinit var appContext: Context
    }

    fun initUiCoreProxy() {
        UiCoreHelper.setProxyA(UiCoreProxyImpl())
    }
}