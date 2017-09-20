package com.github.sfyc23.hencoderpractice.view.drawtext.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice_1_3_14_GetFontMetricsView : View {
    companion object Factory {
        val TAG = Practice_1_3_14_GetFontMetricsView::class.java.simpleName
    }
    var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    var paint2 = Paint(Paint.ANTI_ALIAS_FLAG)
    var texts = arrayOf("A", "a", "J", "j", "Â", "â")
    var top = 200f
    var bottom = 400f

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint1.style = Paint.Style.STROKE
        paint1.strokeWidth = 20f
        paint1.color = Color.parseColor("#E91E63")
        paint2.textSize = 160f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawRect(50f, top, width - 50f, bottom, paint1)

        // 使用 Paint.getFontMetrics() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让不同的文字的 baseline 对齐

        var fontMetrics = paint2.fontMetrics
        var yOffset = (fontMetrics.ascent + fontMetrics.descent) / 2f

        val middle = (top + bottom) / 2

        texts.forEachIndexed { i, text ->
            canvas.drawText(text, 100f * (i + 1), middle - yOffset, paint2)
        }
//        canvas.drawText(texts[0], 100f, middle.toFloat(), paint2)
//        canvas.drawText(texts[1], 200f, middle.toFloat(), paint2)
//        canvas.drawText(texts[2], 300f, middle.toFloat(), paint2)
//        canvas.drawText(texts[3], 400f, middle.toFloat(), paint2)
//        canvas.drawText(texts[4], 500f, middle.toFloat(), paint2)
//        canvas.drawText(texts[5], 600f, middle.toFloat(), paint2)
    }
}
