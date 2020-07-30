package com.mkr.dynamic_oc.provider

import android.content.Context
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.mkr.base_oc.config.ARouterPaths
import com.mkr.base_oc.provider.IDynamicProvider
import com.mkr.dynamic_oc.fragment.DynamicFragment

@Route(path =  ARouterPaths.dynamic,name = "动态")
class IDynamicProvider :IDynamicProvider {
    override fun getDynamicFragment(): Fragment {
        return DynamicFragment.dynamicFragment
    }

    override fun init(context: Context?) {
    }
}