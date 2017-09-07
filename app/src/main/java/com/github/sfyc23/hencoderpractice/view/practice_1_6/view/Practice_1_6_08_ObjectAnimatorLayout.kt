package com.github.sfyc23.hencoderpractice.view.practice_1_6.view

import android.animation.ObjectAnimator
import android.content.Context
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.util.AttributeSet
import android.widget.Button
import android.widget.RelativeLayout
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick


class Practice_1_6_08_ObjectAnimatorLayout : RelativeLayout {
    companion object Factory {
        val TAG = Practice_1_6_08_ObjectAnimatorLayout::class.java.simpleName
    }
    lateinit var animView: Practice_1_6_08_ObjectAnimatorView
    lateinit var animateBt: Button

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        animView = find<Practice_1_6_08_ObjectAnimatorView>(R.id.objectAnimatorView)
        animateBt = find<Button>(R.id.animateBt)

        animateBt.onClick {
            val animator = ObjectAnimator.ofFloat(animView, "progress", 0f, 65f)
            animator.setDuration(1000)
            animator.setInterpolator(FastOutSlowInInterpolator())
            animator.start()
        }
    }
}
