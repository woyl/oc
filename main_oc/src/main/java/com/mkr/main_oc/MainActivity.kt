package com.mkr.main_oc

import android.view.View
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.mkr.base_oc.activity.BaseActivity
import com.mkr.base_oc.config.ARouterPaths
import com.mkr.base_oc.entity.MainChannel
import com.mkr.base_oc.provider.IDynamicProvider
import com.mkr.base_oc.provider.IHomeProvider
import com.mkr.base_oc.provider.IMessageProvider
import com.mkr.base_oc.provider.IMineProvider
import kotlinx.android.synthetic.main.activity_main.*

public class MainActivity : BaseActivity() {

    private var mCurrFragment: Fragment?= null

    @Autowired(name = ARouterPaths.home)
    internal var IHomeProvider : IHomeProvider?=null
    @Autowired(name = ARouterPaths.dynamic)
    internal var IDynamicProvider : IDynamicProvider?=null
    @Autowired(name = ARouterPaths.message)
    internal var IMessageProvider : IMessageProvider?=null
    @Autowired(name = ARouterPaths.mine)
    internal var IMineProvider : IMineProvider?=null


    private var homeFragment: Fragment?=null
    private var dynamicFragment: Fragment?=null
    private var messageFragment: Fragment?=null
    private var mineFragment: Fragment?=null
    override val layoutId: Int
        get() = R.layout.activity_main

    override fun initView(rootView: View) {
        mHeadView.visibility = View.GONE

        homeFragment = IHomeProvider?.getHomeFragment()
        dynamicFragment = IDynamicProvider?.getDynamicFragment()
        messageFragment = IMessageProvider?.getMessageFragment()
        mineFragment = IMineProvider?.getMineFragment()

        mCurrFragment = homeFragment

        navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    switchContent(mCurrFragment,homeFragment, MainChannel.HOME)
                    mCurrFragment = homeFragment
                    true
                }
                R.id.navigation_dynamic -> {
                    switchContent(mCurrFragment,dynamicFragment,MainChannel.DYNAMIC)
                    mCurrFragment = dynamicFragment
                    true
                }
                R.id.navigation_message -> {
                    switchContent(mCurrFragment,messageFragment,MainChannel.MESSAGE)
                    mCurrFragment = messageFragment
                    true
                }
                R.id.navigation_mine -> {
                    switchContent(mCurrFragment,mineFragment,MainChannel.MINE)
                    mCurrFragment = mineFragment
                    true
                }
            }
            false
        }

        if (homeFragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_content, homeFragment!!, MainChannel.HOME.name).commit()
        }
    }

    private fun switchContent(
        mCurrFragment: Fragment?,
        to: Fragment?,
        home: MainChannel
    ) {
        if (mCurrFragment == null || to == null ) return

        if (!to.isAdded) {
            supportFragmentManager.beginTransaction().hide(mCurrFragment).add(R.id.frame_content,to,home.name).commit()
        } else {
            supportFragmentManager.beginTransaction().hide(mCurrFragment).show(to).commit()
        }
    }
}
