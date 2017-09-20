package com.github.sfyc23.hencoderpractice.view.paintdetail.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

class Practice_1_2_13_ShadowLayerView : View {
    companion object Factory {
        val TAG = Practice_1_2_13_ShadowLayerView::class.java.simpleName
    }
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var textPaint = Paint()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        // 使用 Paint.setShadowLayer() 设置阴影
        textPaint.color = Color.RED
        textPaint.textSize = sp(16f).toFloat()

        paint.textSize = sp(28f).toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)


        canvas.drawText("Hello HenCoder(原文字)", 50f, 200f, paint)

        paint.setShadowLayer(10f, 0f, 0f, Color.RED)
        canvas.drawText("Hello HenCoder(ShadowLayer)", 50f, 600f, paint)

    }
}
