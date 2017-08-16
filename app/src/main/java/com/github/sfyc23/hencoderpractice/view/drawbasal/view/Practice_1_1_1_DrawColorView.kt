package com.github.sfyc23.hencoderpractice.view.drawbasal.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View

class Practice_1_1_1_DrawColorView : View {
    companion object Factory {
        val TAG = Practice_1_1_1_DrawColorView::class.java.simpleName
    }
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //        练习内容：使用 canvas.drawColor() 方法把 View 涂成黄色
        //        黄色： Color.YELLOW
        canvas.drawColor(Color.YELLOW)
    }
}

