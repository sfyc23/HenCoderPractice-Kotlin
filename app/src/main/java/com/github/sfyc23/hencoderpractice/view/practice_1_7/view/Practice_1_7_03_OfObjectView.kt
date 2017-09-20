package com.github.sfyc23.hencoderpractice.view.practice_1_7.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View
import com.github.sfyc23.base.ext.dpToFloat


class Practice_1_7_03_OfObjectView : View {

    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var _position = PointF()
    var position: PointF
        get() = _position
        set(value) {
            value?.let {
                _position = value
                invalidate()
            }
        }

    val RADIUS: Float

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint.color = Color.parseColor("#009688")
        RADIUS = dpToFloat(20)
    }

    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val innerPaddingLeft = RADIUS * 1
        val innterPaddingRight = RADIUS * 1
        val innterPaddingTop = RADIUS * 1
        val innterPaddingBottom = RADIUS * 3
        val width = width.toFloat() - innerPaddingLeft - innterPaddingRight - RADIUS * 2
        val height = height.toFloat() - innterPaddingTop - innterPaddingBottom - RADIUS * 2

        canvas.drawCircle(innerPaddingLeft + RADIUS + width * position.x,
                innterPaddingTop + RADIUS + height * position.y,
                RADIUS,
                paint)
    }
}
