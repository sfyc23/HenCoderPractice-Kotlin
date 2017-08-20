package com.github.sfyc23.hencoderpractice.view.drawbasal.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

class Practice_1_1_8_DrawArcView : View {

    companion object Factory {
        val TAG = Practice_1_1_8_DrawArcView::class.java.simpleName
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

        //        练习内容：使用 canvas.drawArc() 方法画弧形和扇形

        //辅助用线
        canvas.drawLine(width / 2f, 0f, width / 2f, height.toFloat(), textPaint)
        canvas.drawLine(0f, height * 0.382f, width.toFloat(), height * 0.382f, textPaint)


        canvas.save()//保存当前canvas
        canvas.translate(width / 2f, height * 0.382f)//将坐标移到屏幕中央

        var rectF = RectF(-200f, -150f, 200f, 150f)//坐标点
        val paint = Paint()//画笔
        paint.color = Color.BLACK
        paint.strokeWidth = 1f


        paint.style = Paint.Style.FILL
//        canvas.drawOval(-200f, -150f, 200f, 150f, textPaint)
        canvas.drawArc(rectF, -100f, 100f, true, paint)// 绘制扇形
        canvas.drawArc(rectF, 20f, 140f, false, paint)// 绘制弧形

        paint.style = Paint.Style.STROKE // 画线模式
        canvas.drawArc(rectF, 180f, 60f, false, paint) // 绘制不封口的弧形

        canvas.drawText("drawArc() 方法画弧形和扇形", 0f, 150f + 140f, textPaint)//描述文字
        canvas.restore()//将 canvas 恢复原样
    }
}
