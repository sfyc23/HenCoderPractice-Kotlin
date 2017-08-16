package com.github.sfyc23.hencoderpractice.view.drawbasal.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View

class Practice_1_1_7_DrawRoundRectView : View {

    companion object Factory {
        val TAG = Practice_1_1_7_DrawRoundRectView::class.java.simpleName
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形

        //将坐标移到屏幕中央
        val centerX = width / 2
        val centerY = height / 2
        canvas.translate(centerX.toFloat(), centerY.toFloat())

        //画笔
        val paint = Paint()
        paint.color = Color.BLACK
        paint.strokeWidth = 10f

        canvas.drawRoundRect(-300f, -200f, 300f, 200f, 50f, 50f, paint)

    }
}
