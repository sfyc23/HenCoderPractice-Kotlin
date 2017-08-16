package com.github.sfyc23.hencoderpractice.view.drawtext.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

class Practice_1_3_08_SetTextSkewXView : View {
    companion object Factory {
        val TAG = Practice_1_3_08_SetTextSkewXView::class.java.simpleName
    }
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint.textSize = sp(16).toFloat()

        // 使用 Paint.setTextSkewX() 来让文字倾斜
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawText("setTextSkewX", 50f, 100f, paint)

        paint.textSkewX = -0.5f
        canvas.drawText("文字倾斜(-0.5f)", 50f, 300f, paint)
    }
}
