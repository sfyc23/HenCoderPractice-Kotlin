package com.github.sfyc23.hencoderpractice.view.practice_1_7.view

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.RelativeLayout
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick


class Practice_1_7_01_ArgbEvaluatorView : RelativeLayout {

    companion object Factory {
        val TAG = Practice_1_7_01_ArgbEvaluatorView::class.java.simpleName
    }

    lateinit var view: SimpleCircleView
    lateinit var animateBt: Button

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        view = find<SimpleCircleView>(R.id.objectAnimatorView)
        animateBt = find<Button>(R.id.animateBt)

        animateBt.onClick {
            ObjectAnimator.ofInt(view, "color", 0xffff0000.toInt(), 0xff00ff00.toInt()).apply {
                setEvaluator(ArgbEvaluator())
                interpolator = LinearInterpolator()
                duration = 2000
                start()
            }
        }
    }
}
