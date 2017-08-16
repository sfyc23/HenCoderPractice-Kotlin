package com.github.sfyc23.hencoderpractice.main

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

class PracticeDefaultView : View {
    companion object Factory {
        val TAG = PracticeDefaultView::class.java.simpleName
    }
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //        练习内容：使用 canvas.drawColor() 方法把 View 涂成黄色
        //        黄色： Color.YELLOW
        canvas.translate(width/2f,height/2f)
        var paint = Paint()
        paint.textSize = sp(16).toFloat();
        paint.textAlign = Paint.Align.CENTER
        canvas.drawText("请输出 view 的地址",0f,0f,paint)
    }
}

