package com.github.sfyc23.hencoderpractice.view.drawbasal.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.dip

class Practice_1_1_2_DrawCircleView : View {

    companion object Factory {
        val TAG = Practice_1_1_2_DrawCircleView::class.java.simpleName
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //        练习内容：使用 canvas.drawCircle() 方法画圆
        //        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        //第一个实心圆
        val paint1 = Paint()
        paint1.color = Color.BLACK
        paint1.style = Paint.Style.FILL
        canvas.drawCircle(width / 4f, height / 4f, Math.min(height, width) / 5f, paint1)

        //第二个空心圆
        val paint2 = Paint()
        paint2.color = Color.BLACK
        paint2.style = Paint.Style.STROKE
        canvas.drawCircle(width * 3 / 4f, height / 4f, Math.min(height, width) / 5f, paint2)


        //3.蓝色实心圆
        val paint3 = Paint()
        paint3.color = Color.BLUE
        canvas.drawCircle(width / 4f, height * 3 / 4f, Math.min(height, width) / 5f, paint3)

        //4.线宽为 20 的空心圆
        val paint4 = Paint()
        paint4.color = Color.BLACK
        paint4.style = Paint.Style.STROKE
        paint4.strokeWidth = dip(20f).toFloat()
        canvas.drawCircle(width * 3 / 4f, height * 3 / 4f, Math.min(height, width) / 5f, paint4)
    }
}
