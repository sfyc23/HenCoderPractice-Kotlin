package com.github.sfyc23.hencoderpractice.view.paintdetail.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

class Practice_1_2_15_FillPathView : View {
    companion object Factory {
        val TAG = Practice_1_2_15_FillPathView::class.java.simpleName
    }
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var pathPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var path = Path()
    internal var path1 = Path()
    internal var path2 = Path()
    internal var path3 = Path()

    internal var textPaint = Paint()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        path.moveTo(50f, 100f)
        path.rLineTo(50f, 100f)
        path.rLineTo(80f, -150f)
        path.rLineTo(100f, 100f)
        path.rLineTo(70f, -120f)
        path.rLineTo(150f, 80f)

        pathPaint.style = Paint.Style.STROKE

        textPaint.color = Color.RED
        textPaint.textSize = sp(12f).toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.getFillPath() 获取实际绘制的 Path

        paint.style = Paint.Style.FILL_AND_STROKE
        paint.strokeWidth = 0f
        // 第一处：获取 Path
        canvas.drawPath(path, paint)


        canvas.save()
        canvas.translate(0f, 200f)
        canvas.drawPath(path1, pathPaint)
//        canvas.restore()

//        canvas.save()
        canvas.translate(0f, 200f)
        paint.style = Paint.Style.STROKE
        // 第二处：设置 Style 为 STROKE 后再获取 Path
        canvas.drawPath(path, paint)
//        canvas.restore()

//        canvas.save()
        canvas.translate(0f, 200f)
        canvas.drawPath(path2, pathPaint)
//        canvas.restore()

//        canvas.save()
        canvas.translate(0f, 200f)
        paint.strokeWidth = 40f
        // 第三处：Style 为 STROKE 并且线条宽度为 40 时的 Path
        canvas.drawPath(path, paint)
//        canvas.restore()

//        canvas.save()
        canvas.translate(0f, 200f)
        canvas.drawPath(path3, pathPaint)
        canvas.restore()
    }
}
