package com.mkr.base_oc.provider

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.template.IProvider

interface IMineProvider :IProvider{
    fun getMineFragment(): Fragment
}