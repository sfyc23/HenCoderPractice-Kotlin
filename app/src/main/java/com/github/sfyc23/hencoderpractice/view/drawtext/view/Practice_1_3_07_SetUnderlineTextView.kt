package com.github.sfyc23.hencoderpractice.view.drawtext.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

class Practice_1_3_07_SetUnderlineTextView : View {
    companion object Factory {
        val TAG = Practice_1_3_07_SetUnderlineTextView::class.java.simpleName
    }
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint.textSize = sp(16).toFloat()

        // 使用 Paint.setUnderlineText() 来设置下划线
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawText("setUnderlineText", 50f, 100f, paint)

        paint.isUnderlineText = true

        canvas.drawText("下划线", 50f, 300f, paint)
    }
}
