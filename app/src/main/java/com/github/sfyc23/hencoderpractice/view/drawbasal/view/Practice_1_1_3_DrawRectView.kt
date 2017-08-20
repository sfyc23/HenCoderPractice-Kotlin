package com.github.sfyc23.hencoderpractice.view.drawbasal.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

class Practice_1_1_3_DrawRectView : View {

    companion object Factory {
        val TAG = Practice_1_1_3_DrawRectView::class.java.simpleName
    }

    var textPaint = Paint()//描述性文字
    var radius = 250f //圆的半径

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        textPaint.apply {
            color = Color.RED//文字颜色
            textSize = sp(16f).toFloat()//文字大小
            textAlign = Paint.Align.CENTER//文字对齐方式，居中对齐
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //        练习内容：使用 canvas.drawRect() 方法画矩形
        val centerX = width / 2f
        val centerY = height * 0.382f

        val paint = Paint()
        paint.style = Paint.Style.FILL
        paint.color = Color.BLACK
        canvas.drawRect(centerX - radius, centerY - radius, centerX + radius, centerY + radius, paint)

        canvas.drawText("矩形", centerX, centerY + radius + 140f, textPaint)//描述文字
    }
}
