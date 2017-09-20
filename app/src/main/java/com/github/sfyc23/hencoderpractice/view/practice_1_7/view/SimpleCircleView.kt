package com.github.sfyc23.hencoderpractice.view.practice_1_7.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View

/**
 * 简单的圆
 */
class SimpleCircleView : View {

    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var _color: Int = 0xffff0000.toInt()
    var color: Int
        get() = _color
    set(value) {
        _color = value
        invalidate()
    }


    internal var position = PointF()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}


    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = color
        val radius = Math.min(width, height) / 2f
//        val radius = dpToFloat(400)
        canvas.drawCircle(radius, radius, radius, paint)
    }
}
