package com.github.sfyc23.hencoderpractice.view.practice_1_7.view

import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.content.Context
import android.graphics.PointF
import android.util.AttributeSet
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.RelativeLayout
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick


class Practice_1_7_03_OfObjectLayout : RelativeLayout {

    companion object Factory {
        val TAG = Practice_1_7_03_OfObjectLayout::class.java.simpleName
    }

    lateinit var view: Practice_1_7_03_OfObjectView
    lateinit var animateBt: Button

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        view = find<Practice_1_7_03_OfObjectView>(R.id.objectAnimatorView)
        animateBt = find<Button>(R.id.animateBt)

        animateBt.onClick {
            val animator = ObjectAnimator.ofObject(view, "position",
                    PointFEvaluator(), PointF(0f, 0f), PointF(1f, 1f))
            animator.apply {
//                setEvaluator(PointFEvaluator())
                interpolator = LinearInterpolator()
                duration = 2000
                animator.start()
            }

        }
    }

    internal class PointFEvaluator : TypeEvaluator<PointF> {
        var newPoint = PointF()

        override fun evaluate(fraction: Float, startValue: PointF, endValue: PointF): PointF {
            val x = startValue.x + fraction * (endValue.x - startValue.x)
            val y = startValue.y + fraction * (endValue.y - startValue.y)

            newPoint.set(x, y)

            return newPoint
        }
    }
}
