package com.github.sfyc23.hencoderpractice.view.paintdetail.view

import android.content.Context
import android.graphics.*
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

class Practice_1_2_03_SweepGradientView : View {
    companion object Factory {
        val TAG = Practice_1_2_03_SweepGradientView::class.java.simpleName
    }

    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)//描述性文字

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        // 用 Paint.setShader(shader) 设置一个 SweepGradient
        // SweepGradient 的参数：圆心坐标：(300, 300)；颜色：#E91E63 到 #2196F3
        //SweepGradient(float cx, float cy, int color0, int color1)

        textPaint.apply {
            color = Color.WHITE//文字颜色
            textSize = sp(16f).toFloat()//文字大小
            textAlign = Paint.Align.CENTER//文字对齐方式，居中对齐
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawText(" 2.3 SweepGradient 扫描渐变", width/2f, 140f, textPaint)//描述文字
//        canvas.drawCircle(300f, 300f, 200f, paint)

        var rectF = RectF(-350f, -200f, 350f, 200f)
        canvas.save()//保存当前canvas
        canvas.translate(width / 2f, height * 0.382f)//将坐标移到屏幕中央
        paint.shader = SweepGradient(0f, 0f, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"));
        canvas.drawRect(rectF, paint)
        canvas.restore()//将 canvas 恢复原样
    }
}
