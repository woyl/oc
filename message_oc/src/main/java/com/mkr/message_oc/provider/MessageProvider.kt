package com.mkr.message_oc.provider

import android.content.Context
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.mkr.base_oc.config.ARouterPaths
import com.mkr.base_oc.provider.IMessageProvider
import com.mkr.message_oc.fragment.MessageFragment

@Route(path = ARouterPaths.message,name = "消息")
class MessageProvider :IMessageProvider {
    override fun getMessageFragment(): Fragment {
        return MessageFragment.messageFragment
    }

    override fun init(context: Context?) {

    }
}