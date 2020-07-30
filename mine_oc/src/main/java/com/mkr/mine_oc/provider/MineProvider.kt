package com.mkr.mine_oc.provider

import android.content.Context
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.mkr.base_oc.config.ARouterPaths
import com.mkr.base_oc.provider.IMineProvider
import com.mkr.mine_oc.fragment.MineFragment

@Route(path = ARouterPaths.mine,name = "我的")
class MineProvider :IMineProvider {
    override fun getMineFragment(): Fragment {
        return MineFragment.mineFragment
    }

    override fun init(context: Context?) {
    }
}