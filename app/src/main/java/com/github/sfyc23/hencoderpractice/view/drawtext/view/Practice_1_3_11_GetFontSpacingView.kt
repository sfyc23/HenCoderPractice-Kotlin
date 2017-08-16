package com.github.sfyc23.hencoderpractice.view.drawtext.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

class Practice_1_3_11_GetFontSpacingView : View {
    companion object Factory {
        val TAG = Practice_1_3_11_GetFontSpacingView::class.java.simpleName
    }
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var text = "Hello HenCoder"

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint.textSize = sp(16).toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.getFontSpacing() 来获取推荐的行距
        var spacing = 20f

        canvas.drawText(text, 50f, 100f, paint)

        spacing = paint.fontSpacing

        canvas.drawText(text+"(${spacing})", 50f, 100 + spacing, paint)

        canvas.drawText(text+"(${2*spacing})", 50f, 100 + spacing * 2, paint)
    }
}
