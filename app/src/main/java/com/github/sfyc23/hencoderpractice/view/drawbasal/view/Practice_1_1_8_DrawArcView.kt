package com.github.sfyc23.hencoderpractice.view.drawbasal.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View

class Practice_1_1_8_DrawArcView : View {

    companion object Factory {
        val TAG = Practice_1_1_8_DrawArcView::class.java.simpleName
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //        练习内容：使用 canvas.drawArc() 方法画弧形和扇形

        //将坐标移到屏幕中央
        val centerX = width / 2
        val centerY = height / 2
        canvas.translate(centerX.toFloat(), centerY.toFloat())

        //画笔
        val paint = Paint()
        paint.color = Color.BLACK
        paint.strokeWidth = 1f

        paint.style = Paint.Style.FILL
        canvas.drawArc(-200f, -150f, 200f, 150f, -100f, 100f, true, paint)// 绘制扇形
        canvas.drawArc(-200f, -150f, 200f, 150f, 20f, 140f, false, paint)// 绘制弧形

        paint.style = Paint.Style.STROKE // 画线模式
        canvas.drawArc(-200f, -150f, 200f, 150f, 180f, 60f, false, paint) // 绘制不封口的弧形

    }
}
