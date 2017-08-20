package com.github.sfyc23.hencoderpractice.view.paintdetail.view

import android.content.Context
import android.graphics.*
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

class Practice_1_2_01_LinearGradientView : View {
    companion object Factory {
        val TAG = Practice_1_2_01_LinearGradientView::class.java.simpleName
    }

    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)//描述性文字

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        // 用 Paint.setShader(shader) 设置一个 LinearGradient
        // LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3

        textPaint.apply {
            color = Color.WHITE//文字颜色
            textSize = sp(16f).toFloat()//文字大小
            textAlign = Paint.Align.CENTER//文字对齐方式，居中对齐
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawText("2.1 LinearGradient 线性渐变", width/2f, 140f, textPaint)//描述文字

        var bottomHeight = 550f//Y 水平线的坐标点
        var leftWidth = 500f//X 水平线的坐标点
        var rectF = RectF(-350f, -200f, 350f, 200f)

        canvas.save()//保存当前canvas
        canvas.translate(leftWidth, 1f * bottomHeight )//将坐标移到屏幕中央
        paint.shader = LinearGradient(-100f, -100f, 100f, 100f, Color.parseColor("#E91E53"), Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        canvas.drawRect(rectF, paint)
        canvas.drawText("1. CLAMP （夹子模式)", 0f, -250f, textPaint)//描述文字
        canvas.restore()//将 canvas 恢复原样


        canvas.save()//保存当前canvas
        canvas.translate(leftWidth, 2f * bottomHeight)//将坐标移到屏幕中央
        paint.shader = LinearGradient(-100f, -100f, 100f, 100f, Color.parseColor("#E91E53"), Color.parseColor("#2196F3"), Shader.TileMode.MIRROR);
        canvas.drawRect(rectF, paint)
        canvas.drawText("2.MIRROR （镜像模式)", 0f, -250f, textPaint)//描述文字
        canvas.restore()//将 canvas 恢复原样


        canvas.save()//保存当前canvas
        canvas.translate(leftWidth, 3f * bottomHeight)//将坐标移到屏幕中央
        paint.shader = LinearGradient(-100f, -100f, 100f, 100f, Color.parseColor("#E91E53"), Color.parseColor("#2196F3"), Shader.TileMode.REPEAT);
        canvas.drawRect(rectF, paint)
        canvas.drawText("3.REPEAT （重复模式)", 0f, -250f, textPaint)//描述文字
        canvas.restore()//将 canvas 恢复原样
    }
}
