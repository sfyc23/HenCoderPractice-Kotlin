package com.github.sfyc23.hencoderpractice.view.practice_1_7.view

import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.RelativeLayout
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick


class Practice_1_7_02_HsvEvaluatorLayout : RelativeLayout {

    companion object Factory {
        val TAG = Practice_1_7_02_HsvEvaluatorLayout::class.java.simpleName
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
                setEvaluator(HsvEvaluator())
                interpolator = LinearInterpolator()
                duration = 2000
                start()
            }
        }
    }

    class HsvEvaluator : TypeEvaluator<Int> {
        var startHsv = FloatArray(3)
        var endHsv = FloatArray(3)
        var outHsv = FloatArray(3)

        override fun evaluate(fraction: Float, startValue: Int?, endValue: Int?): Int? {
            // 把 ARGB 转换成 HSV
            Color.colorToHSV(startValue!!, startHsv)
            Color.colorToHSV(endValue!!, endHsv)

            // 计算当前动画完成度（fraction）所对应的颜色值
            if (endHsv[0] - startHsv[0] > 180) {
                endHsv[0] -= 360f
            } else if (endHsv[0] - startHsv[0] < -180) {
                endHsv[0] += 360f
            }
            outHsv[0] = startHsv[0] + (endHsv[0] - startHsv[0]) * fraction
            if (outHsv[0] > 360) {
                outHsv[0] -= 360f
            } else if (outHsv[0] < 0) {
                outHsv[0] += 360f
            }
            outHsv[1] = startHsv[1] + (endHsv[1] - startHsv[1]) * fraction
            outHsv[2] = startHsv[2] + (endHsv[2] - startHsv[2]) * fraction

            // 计算当前动画完成度（fraction）所对应的透明度
            // shr 赞同于 >> 24
            val alpha = startValue shr 24 + ((endValue shr 24 - startValue shr 24) * fraction).toInt()

            // 把 HSV 转换回 ARGB 返回
            return Color.HSVToColor(alpha, outHsv)
        }
    }
}
