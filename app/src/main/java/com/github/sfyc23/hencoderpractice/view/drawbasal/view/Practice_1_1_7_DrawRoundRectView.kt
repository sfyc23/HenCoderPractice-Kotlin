package com.github.sfyc23.hencoderpractice.view.drawbasal.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

class Practice_1_1_7_DrawRoundRectView : View {

    companion object Factory {
        val TAG = Practice_1_1_7_DrawRoundRectView::class.java.simpleName
    }
    var textPaint = Paint()//描述性文字

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        textPaint.apply {
            color = Color.RED//文字颜色
            textSize = sp(16f).toFloat()//文字大小
            textAlign = Paint.Align.CENTER//文字对齐方式，居中对齐
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形

        //画笔
        val paint = Paint()
        paint.color = Color.BLACK
        paint.strokeWidth = 10f

        canvas.save()//保存当前canvas
        canvas.translate(width / 2f, height * 0.382f)
        canvas.drawRoundRect(-300f, -200f, 300f, 200f, 50f, 50f, paint)
        canvas.drawText("drawRoundRect(圆角矩形)", 0f, 200f + 140f, textPaint)//描述文字
        canvas.restore()//将 canvas 恢复原样


    }
}
