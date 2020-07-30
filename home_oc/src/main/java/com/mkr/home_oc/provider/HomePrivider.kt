package com.mkr.home_oc.provider

import android.content.Context
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.mkr.base_oc.config.ARouterPaths
import com.mkr.base_oc.provider.IHomeProvider
import com.mkr.home_oc.fragment.HomeFragment

@Route(path = ARouterPaths.home,name = "首页")
class HomePrivider :IHomeProvider {
    override fun getHomeFragment(): Fragment {
        return HomeFragment.homeFragment
    }

    override fun init(context: Context?) {
    }
}