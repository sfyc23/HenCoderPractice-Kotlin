package com.github.sfyc23.hencoderpractice.view.drawtext.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class Practice_1_3_13_GetTextBoundsView : View {
    companion object Factory {
        val TAG = Practice_1_3_13_GetTextBoundsView::class.java.simpleName
    }
    var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    var paint2 = Paint(Paint.ANTI_ALIAS_FLAG)
    var texts = arrayOf("A", "a", "J", "j", "Â", "â")
    var yOffsets = floatArrayOf(0f, 0f, 0f, 0f, 0f, 0f)


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

        // 使用 Paint.getTextBounds() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让文字精准地居中，分毫不差

        val textBounds = Rect()
        texts.forEachIndexed { i, text ->
            paint2.getTextBounds(text, 0, text.length, textBounds)
            yOffsets[i] = (textBounds.top + textBounds.bottom) / 2f
        }

        val middle = (top + bottom) / 2f
        texts.forEachIndexed { i, text ->
            canvas.drawText(text, 100f * (i + 1), middle - yOffsets[i], paint2)
        }
    }
}