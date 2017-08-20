package com.github.sfyc23.hencoderpractice.view.drawbasal.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

class Practice_1_1_1_DrawColorView : View {
    companion object Factory {
        val TAG = Practice_1_1_1_DrawColorView::class.java.simpleName
    }
    var textPaint = Paint()//描述性文字

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        textPaint.apply {
            color = Color.WHITE//文字颜色
            textSize = sp(16f).toFloat()//文字大小
            textAlign = Paint.Align.CENTER//文字对齐方式，居中对齐
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //        练习内容：使用 canvas.drawColor() 方法把 View 涂成黄色
        //        黄色： Color.YELLOW
        canvas.drawColor(Color.BLACK)
        canvas.drawText("白天不懂黑的夜 , 把 View 涂成黄色", width / 2f, height * 0.382f, textPaint)

    }
}

