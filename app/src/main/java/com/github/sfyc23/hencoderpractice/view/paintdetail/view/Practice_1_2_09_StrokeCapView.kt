package com.github.sfyc23.hencoderpractice.view.paintdetail.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

class Practice_1_2_09_StrokeCapView : View {
    companion object Factory {
        val TAG = Practice_1_2_09_StrokeCapView::class.java.simpleName
    }

    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var textPaint = Paint()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint.strokeWidth = 50f

        textPaint.color = Color.RED
        textPaint.textSize = sp(16f).toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.setStrokeCap() 来设置端点形状


        // 第一个：BUTT
        paint.strokeCap = Paint.Cap.BUTT
        canvas.drawLine(50f, 50f, 400f, 50f, paint)
        canvas.drawText("BUTT（平头） 默认", 450f, 70f, textPaint);


        // 第二个：ROUND
        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawLine(50f, 250f, 400f, 250f, paint)
        canvas.drawText("ROUND（圆头） ", 450f, 270f, textPaint);

        // 第三个：SQUARE
        paint.strokeCap = Paint.Cap.SQUARE
        canvas.drawLine(50f, 450f, 400f, 450f, paint)
        canvas.drawText("SQUARE（方头） ", 450f, 470f, textPaint);

    }
}
