package com.hencoder.hencoderpracticedraw5.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet

class Practice_1_5_02_BeforeOnDrawView : AppCompatTextView {
    companion object Factory {
        val TAG = Practice_1_5_02_BeforeOnDrawView::class.java.simpleName
    }

    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bounds = RectF()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint.color = Color.parseColor("#FFC107")
    }

    // 在 super.onDraw() 的上方插入绘制代码，先绘制内容，之后再绘制原主体内容
    override fun onDraw(canvas: Canvas) {

        bounds.left = layout.getLineLeft(1)
        bounds.right = layout.getLineRight(1)
        bounds.top = layout.getLineTop(1).toFloat()
        bounds.bottom = layout.getLineBottom(1).toFloat()
        canvas.drawRect(bounds, paint)
        bounds.left = layout.getLineLeft(layout.lineCount - 3)
        bounds.right = layout.getLineRight(layout.lineCount - 3)
        bounds.top = layout.getLineTop(layout.lineCount - 3).toFloat()
        bounds.bottom = layout.getLineBottom(layout.lineCount - 3).toFloat()
        canvas.drawRect(bounds, paint)

        super.onDraw(canvas)
    }
}
