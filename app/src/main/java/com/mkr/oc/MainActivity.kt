package com.mkr.oc

import android.view.View
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.mkr.base_oc.activity.BaseActivity
import com.mkr.base_oc.config.ARouterPaths
import com.mkr.base_oc.provider.IDynamicProvider
import com.mkr.base_oc.provider.IHomeProvider
import com.mkr.base_oc.provider.IMessageProvider
import com.mkr.base_oc.provider.IMineProvider
import com.mkr.base_oc.entity.MainChannel
import kotlinx.android.synthetic.main.activity_main.*

public class MainActivity : BaseActivity(), RadioGroup.OnCheckedChangeListener {

    private var mCurrFragment:Fragment?= null

    @Autowired(name = ARouterPaths.home)
    internal var IHomeProvider : IHomeProvider?=null
    @Autowired(name = ARouterPaths.dynamic)
    internal var IDynamicProvider : IDynamicProvider?=null
    @Autowired(name = ARouterPaths.message)
    internal var IMessageProvider : IMessageProvider?=null
    @Autowired(name = ARouterPaths.mine)
    internal var IMineProvider : IMineProvider?=null


    private var homeFragment:Fragment?=null
    private var dynamicFragment:Fragment?=null
    private var messageFragment:Fragment?=null
    private var mineFragment:Fragment?=null

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
                    switchContent(mCurrFragment,homeFragment,MainChannel.HOME)
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


        /**viewpage2*/
//        val adapter = RgAdapter(this)
//        adapter.addFragment(HomeFragment.homeFragment)
//        adapter.addFragment(DynamicFragment.dynamicFragment)
//        adapter.addFragment(MessageFragment.messageFragment)
//        adapter.addFragment(MineFragment.mineFragment)

//        view_pager2.adapter = adapter
//        radio_group.setOnCheckedChangeListener(this)
//        view_pager2.currentItem = 0
//        view_pager2.offscreenPageLimit =3
//        view_pager2.isUserInputEnabled = false
//
//        view_pager2.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                when (position) {
//                    0 -> radio_bt_home.isChecked = true
//                    1 -> radio_bt_dynamic.isChecked = true
//                    2 -> radio_bt_message.isChecked = true
//                    3 -> radio_bt_mine.isChecked = true
//                }
//            }
//        })
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

    /**radiogroup]*/
    override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
        when (p1) {
//            radio_bt_home.id -> view_pager2.setCurrentItem(0,false)
//            radio_bt_dynamic.id -> view_pager2.setCurrentItem(1,false)
//            radio_bt_message.id -> view_pager2.setCurrentItem(2,false)
//            radio_bt_mine.id -> view_pager2.setCurrentItem(3,false)
        }
    }
}