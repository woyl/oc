package com.mkr.base_oc.swipeback

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.mkr.base_oc.R

open class SwipeBackFragment : Fragment(){
    private var swipeBackLayout: SwipeBackLayout? = null
    private var mNoAnim: Animation? = null
    var mLocking = false

    private var _mActivity: SwipeBackActivity? = null

    private val windowBackground: Int
        get() {
            val a =
                activity?.theme?.obtainStyledAttributes(intArrayOf(android.R.attr.windowBackground))
            val background = a?.getResourceId(0, 0)
            a?.recycle()
            return background!!
        }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        activity.let { super.onAttach(it) }
        if (activity is SwipeBackActivity) {
            _mActivity = activity
        } else {
            throw RuntimeException("$activity must extends SwipeBackActivity")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            val isSupportHidden =
                savedInstanceState.getBoolean(SWIPEBACKFRAGMENT_STATE_SAVE_IS_HIDDEN)

            val ft = fragmentManager!!.beginTransaction()
            if (isSupportHidden) {
                ft.hide(this)
            } else {
                ft.show(this)
            }
            ft.commit()
        }

        mNoAnim = AnimationUtils.loadAnimation(activity, R.anim.no_anim)
        onFragmentCreate()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(SWIPEBACKFRAGMENT_STATE_SAVE_IS_HIDDEN, isHidden)
    }

    private fun onFragmentCreate() {
        swipeBackLayout = SwipeBackLayout(activity)
        val params = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        swipeBackLayout?.layoutParams = params
        swipeBackLayout?.setBackgroundColor(Color.TRANSPARENT)
    }

    protected fun attachToSwipeBack(view: View): View {
        swipeBackLayout?.attachToFragment(this, view)
        return swipeBackLayout as SwipeBackLayout
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (hidden && swipeBackLayout != null) {
            swipeBackLayout?.hiddenFragment()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val view = view
        initFragmentBackground(view)
        if (view != null) {
            view.isClickable = true
        }
    }

    private fun initFragmentBackground(view: View?) {
        if (view is SwipeBackLayout) {
            val childView = view.getChildAt(0)
            setBackground(childView)
        } else {
            setBackground(view)
        }
    }

    private fun setBackground(view: View?) {
        if (view != null && view.background == null) {
            val defaultBg = _mActivity!!.defaultFragmentBackground
            if (defaultBg == 0) {
                val background = windowBackground
                view.setBackgroundResource(background)
            } else {
                view.setBackgroundResource(defaultBg)
            }
        }
    }

    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation? {
        return if (mLocking) {
            mNoAnim
        } else super.onCreateAnimation(transit, enter, nextAnim)
    }

    open fun setSwipeBackEnable(enable: Boolean) {
        swipeBackLayout?.setEnableGesture(enable)
    }

    companion object {
        private val SWIPEBACKFRAGMENT_STATE_SAVE_IS_HIDDEN =
            "SWIPEBACKFRAGMENT_STATE_SAVE_IS_HIDDEN"
    }
}