package com.github.sfyc23.hencoderpractice.view.drawtext.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

class Practice_1_3_09_SetTextScaleXView : View {
    companion object Factory {
        val TAG = Practice_1_3_09_SetTextScaleXView::class.java.simpleName
    }
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var text = "Hello HenCoder"

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint.textSize = sp(16).toFloat()

        // 使用 Paint.setTextScaleX() 来改变文字宽度
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawText("Hello HenCoder(原版)", 50f, 100f, paint)

        paint.textScaleX = 0.8f
        canvas.drawText("Hello HenCoder(0.8f)", 50f, 300f, paint)

        paint.textScaleX = 1.2f
        canvas.drawText("Hello HenCoder(1.2f)", 50f, 500f, paint)

    }
}
