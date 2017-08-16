package com.github.sfyc23.hencoderpractice.view.drawbasal.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice_1_1_6_DrawLineView : View {

    companion object Factory {
        val TAG = Practice_1_1_6_DrawLineView::class.java.simpleName
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //        练习内容：使用 canvas.drawLine() 方法画直线

        //将坐标移到屏幕中央
        val centerX = width / 2
        val centerY = height / 2
        canvas.translate(centerX.toFloat(), centerY.toFloat())

        val paint = Paint()
        paint.color = Color.BLACK
        paint.strokeWidth = 15f
        canvas.drawLine(-200f, -200f, 200f, 200f, paint)
    }
}
