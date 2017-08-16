package com.github.sfyc23.hencoderpractice.view.drawtext.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

class Practice_1_3_05_SetFakeBoldTextView : View {
    companion object Factory {
        val TAG = Practice_1_3_05_SetFakeBoldTextView::class.java.simpleName
    }
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var text = "Hello HenCoder"

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint.textSize = sp(16).toFloat()
        // 使用 Paint.setFakeBoldText() 来加粗文字
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawText(text+" (原版)", 50f, 100f, paint)

        paint.isFakeBoldText = true;
        canvas.drawText(text+" (FakeBold:true)", 50f, 300f, paint)

    }
}
