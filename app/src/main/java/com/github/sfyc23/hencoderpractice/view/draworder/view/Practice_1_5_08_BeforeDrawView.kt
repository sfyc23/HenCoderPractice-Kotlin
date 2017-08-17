package com.hencoder.hencoderpracticedraw5.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.support.v7.widget.AppCompatEditText
import android.util.AttributeSet

class Practice_1_5_08_BeforeDrawView : AppCompatEditText {

    companion object Factory {
        val TAG = Practice_1_5_08_BeforeDrawView::class.java.simpleName
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun draw(canvas: Canvas) {
        // 在 super.draw() 的上方插入绘制代码，让绘制内容被其他所有内容盖住
        canvas.drawColor(Color.parseColor("#66BB6A")) // 涂上绿色
        super.draw(canvas)
    }
}
