package com.github.sfyc23.hencoderpractice.view.paintdetail.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

class Practice_1_2_10_StrokeJoinView : View {
    companion object Factory {
        val TAG = Practice_1_2_10_StrokeJoinView::class.java.simpleName
    }
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var path = Path()
    var textPaint = Paint()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint.strokeWidth = 40f
        paint.style = Paint.Style.STROKE

        path.rLineTo(200f, 0f)
        path.rLineTo(-160f, 120f)

        textPaint.color = Color.RED
        textPaint.textSize = sp(16f).toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.save()

        // 使用 Paint.setStrokeJoin() 来设置不同的拐角形状

        canvas.translate(100f, 100f)
        // 第一种形状：MITER
        paint.strokeJoin = Paint.Join.MITER
        canvas.drawPath(path, paint)
        canvas.drawText("MITER（尖角） 默认", 250f, 60f, textPaint);

        canvas.translate(0f, 250f)
        // 第二种形状：BEVEL
        paint.strokeJoin = Paint.Join.BEVEL
        canvas.drawPath(path, paint)
        canvas.drawText("BEVEL（平角）", 250f, 60f, textPaint);

        canvas.translate(0f, 250f)
        // 第三种形状：ROUND
        paint.strokeJoin = Paint.Join.ROUND
        canvas.drawPath(path, paint)
        canvas.drawText("ROUND（圆角）", 250f, 60f, textPaint);

        canvas.restore()
    }
}
