package com.github.sfyc23.hencoderpractice.view.drawbasal.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.dip
import org.jetbrains.anko.sp

class Practice_1_1_2_DrawCircleView : View {

    companion object Factory {
        val TAG = Practice_1_1_2_DrawCircleView::class.java.simpleName
    }

    var textPaint = Paint()//描述性文字
    var radius = 250f //圆的半径

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

        //        练习内容：使用 canvas.drawCircle() 方法画圆
        //        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        //第一个实心圆
        canvas.save()//保存当前canvas
        canvas.translate(width / 4f, height / 4f)
        val paint1 = Paint()
        paint1.color = Color.BLACK//画笔颜色
        paint1.style = Paint.Style.FILL
        canvas.drawCircle(0f, 0f, radius, paint1)
        canvas.drawText("实心圆", 0f, radius + 140f, textPaint)//描述文字
        canvas.restore()//将canvas恢复原样

        //第二个空心圆
        canvas.save()//保存当前canvas
        canvas.translate(width * 3 / 4f, height / 4f)
        val paint2 = Paint()
        paint2.color = Color.BLACK
        paint2.style = Paint.Style.STROKE
        canvas.drawCircle(0f, 0f, radius, paint2)
        canvas.drawText("空心圆", 0f, radius + 140f, textPaint)//描述文字
        canvas.restore()//将 canvas 恢复原样

        //3.蓝色实心圆
        canvas.save()//保存当前canvas
        canvas.translate(width  * 3/ 4f, height * 3 / 4f)
        val paint3 = Paint()
        paint3.color = Color.BLUE
        canvas.drawCircle(0f, 0f, radius, paint3)
        canvas.drawText("蓝色实心圆", 0f, radius + 140f, textPaint)//描述文字
        canvas.restore()//将canvas恢复原样

        //4.线宽为 20 的空心圆
        canvas.save()//保存当前canvas
        canvas.translate(width / 4f, height * 3 / 4f)
        val paint4 = Paint()
        paint4.color = Color.BLACK
        paint4.style = Paint.Style.STROKE
        paint4.strokeWidth = dip(20f).toFloat()
        canvas.drawCircle(0f, 0f, radius, paint4)
        canvas.drawText("线宽为 20 的空心圆", 0f, radius + 140f, textPaint)//描述文字
        canvas.restore()//将canvas恢复原样

    }
}
