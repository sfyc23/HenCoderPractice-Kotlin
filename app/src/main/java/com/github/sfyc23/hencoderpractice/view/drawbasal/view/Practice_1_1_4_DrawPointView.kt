package com.github.sfyc23.hencoderpractice.view.drawbasal.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice_1_1_4_DrawPointView : View {

    companion object Factory {
        val TAG = Practice_1_1_4_DrawPointView::class.java.simpleName
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //        练习内容：使用 canvas.drawPoint() 方法画点
        //        一个圆点，一个方点
        //        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点

        //中心坐标
        val centerX = width / 2
        val centerY = height / 2

        val p1 = Paint()
        p1.strokeCap = Paint.Cap.ROUND
        p1.strokeWidth = 100f


        val p2 = Paint()
        p2.strokeCap = Paint.Cap.SQUARE
        p2.strokeWidth = 100f

        canvas.drawPoint((centerX / 2).toFloat(), centerY.toFloat(), p1)
        canvas.drawPoint((centerX * 3 / 2).toFloat(), centerY.toFloat(), p2)


    }
}
