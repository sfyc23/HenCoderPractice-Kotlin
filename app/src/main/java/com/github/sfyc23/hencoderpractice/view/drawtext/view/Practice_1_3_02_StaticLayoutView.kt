package com.github.sfyc23.hencoderpractice.view.drawtext.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View



class Practice_1_3_02_StaticLayoutView : View {
    companion object Factory {
        val TAG = Practice_1_3_02_StaticLayoutView::class.java.simpleName
    }

    var textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    var text = "(常规)Hello\nHenCoder"

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        textPaint.textSize = 60f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 StaticLayout 代替 Canvas.drawText() 来绘制文字，
        // 以绘制出带有换行的文字
        canvas.drawText(text, 50f, 100f, textPaint)

        val text1 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
        val staticLayout1 = StaticLayout(text1, textPaint, 1000,
                Layout.Alignment.ALIGN_NORMAL, 1f, 0f, true)

        val text2 = "a\nbc\ndefghi\njklm\nnopqrst\nuvwx\nyz"
        val staticLayout2 = StaticLayout(text2, textPaint, 1000,
                Layout.Alignment.ALIGN_NORMAL, 1f, 0f, true)

        canvas.save();
        canvas.translate(50f, 200f);
        staticLayout1.draw(canvas);
        canvas.translate(0f, 300f);
        staticLayout2.draw(canvas);
        canvas.restore();
    }
}
