package com.hencoder.hencoderpracticedraw5.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import org.jetbrains.anko.sp

class Practice_1_5_05_AfterOnDrawForegroundView : AppCompatImageView {
    companion object Factory {
        val TAG = Practice_1_5_05_AfterOnDrawForegroundView::class.java.simpleName
    }
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}


    override fun onDrawForeground(canvas: Canvas) {
        super.onDrawForeground(canvas)


        paint.textSize = sp(16).toFloat()

        //绘制背景
        paint.color = Color.parseColor("#f44336")
        canvas.drawRect(0f, 40f, 200f, 120f, paint)

        //绘制文字
        paint.color = Color.WHITE
        canvas.drawText("New", 20f, 100f, paint)
    }
}
