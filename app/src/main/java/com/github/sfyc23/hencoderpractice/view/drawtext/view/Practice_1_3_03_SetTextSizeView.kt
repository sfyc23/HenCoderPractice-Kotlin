package com.github.sfyc23.hencoderpractice.view.drawtext.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

class Practice_1_3_03_SetTextSizeView : View {
    companion object Factory {
        val TAG = Practice_1_3_03_SetTextSizeView::class.java.simpleName
    }
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var text = "Hello HenCoder"


    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        var y = 100f

        // 使用 paint.setTextSize() 来设置不同大小的文字

        // 第一处：文字大小 16

        paint.textSize = sp(8f).toFloat()
        canvas.drawText(text, 50f, y, paint)

        y += 55
        // 第一处：文字大小 24
        paint.textSize = sp(10f).toFloat()
        canvas.drawText(text, 50f, y, paint)

        y += 65
        // 第一处：文字大小 48
        paint.textSize = sp(12f).toFloat()
        canvas.drawText(text, 50f, y, paint)

        y += 80
        // 第一处：文字大小 72
        paint.textSize = sp(16f).toFloat()
        canvas.drawText(text, 50f, y, paint)
    }
}