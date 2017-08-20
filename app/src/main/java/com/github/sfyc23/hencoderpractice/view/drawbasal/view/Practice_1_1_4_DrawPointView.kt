package com.github.sfyc23.hencoderpractice.view.drawbasal.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

class Practice_1_1_4_DrawPointView : View {

    companion object Factory {
        val TAG = Practice_1_1_4_DrawPointView::class.java.simpleName
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

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //        练习内容：使用 canvas.drawPoint() 方法画点
        //        一个圆点，一个方点
        //        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点


        val p1 = Paint()
        p1.strokeCap = Paint.Cap.ROUND
        p1.strokeWidth = 400f


        val p2 = Paint()
        p2.strokeCap = Paint.Cap.SQUARE
        p2.strokeWidth = 400f

        canvas.save()//保存当前canvas
        canvas.translate(width / 4f, height * 0.382f)
        canvas.drawPoint(0f, 0f, p1)
        canvas.drawText("Cap.ROUND(空心圆)", 0f, 200f + 140f, textPaint)//描述文字
        canvas.restore()//将 canvas 恢复原样

        canvas.save()//保存当前canvas
        canvas.translate(width * 3 / 4f, height * 0.382f)
        canvas.drawPoint(0f, 0f, p2)
        canvas.drawText("Cap.SQUARE(正方形)", 0f, 200f + 140f, textPaint)//描述文字
        canvas.restore()//将 canvas 恢复原样


    }
}
