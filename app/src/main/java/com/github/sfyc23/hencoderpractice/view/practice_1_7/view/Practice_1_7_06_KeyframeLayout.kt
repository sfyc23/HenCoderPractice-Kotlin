package com.github.sfyc23.hencoderpractice.view.practice_1_7.view

import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.util.AttributeSet
import android.widget.Button
import android.widget.RelativeLayout
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick


class Practice_1_7_06_KeyframeLayout : RelativeLayout {
    companion object Factory {
        val TAG = Practice_1_7_06_KeyframeLayout::class.java.simpleName
    }
    lateinit var view: Practice_1_7_06_KeyframeView
    lateinit var animateBt: Button

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        view = find<Practice_1_7_06_KeyframeView>(R.id.objectAnimatorView)
        animateBt = find<Button>(R.id.animateBt)

        animateBt.onClick {
            val keyframe1 = Keyframe.ofFloat(0f, 0f) // 开始：progress 为 0
            val keyframe2 = Keyframe.ofFloat(0.5f, 100f) // 进行到一半是，progres 为 100
            val keyframe3 = Keyframe.ofFloat(1f, 80f) // 结束时倒回到 80
            val holder = PropertyValuesHolder.ofKeyframe("progress", keyframe1, keyframe2, keyframe3)

            ObjectAnimator.ofPropertyValuesHolder(view, holder).apply {
                duration = 2000
                interpolator = FastOutSlowInInterpolator()
                start()
            }

        }
    }
}
