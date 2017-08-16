package com.github.sfyc23.hencoderpractice.view.drawbasal.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
class Practice_1_1_9_DrawPathView : View{

    companion object Factory {
        val TAG = Practice_1_1_9_DrawPathView::class.java.simpleName
    }

    internal var paint = Paint()
    internal var path = Path() // 初始化 Path 对象

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //        练习内容：使用 canvas.drawPath() 方法画心形

        //将坐标移到屏幕中央
        val centerX = width / 2
        val centerY = height / 2
        canvas.translate(centerX.toFloat(), centerY.toFloat())

        path.addArc(-200f, -200f, 0f, 0f, -225f, 225f)
        path.arcTo(0f, -200f, 200f, 0f, -180f, 225f, false)
        path.lineTo(0f, 142f)

        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 50f


        canvas.drawPath(path, paint) // 绘制出 path 描述的图形（心形），大功告成


    }
}
