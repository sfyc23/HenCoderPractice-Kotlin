package com.github.sfyc23.hencoderpractice.view.paintdetail.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp


class Practice_1_2_12_PathEffectView : View {
    companion object Factory {
        val TAG = Practice_1_2_12_PathEffectView::class.java.simpleName
    }
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var path = Path()
    var textPaint = Paint()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 8f

        path.moveTo(50f, 100f)
        path.rLineTo(50f, 100f)
        path.rLineTo(80f, -150f)
        path.rLineTo(100f, 100f)
        path.rLineTo(70f, -120f)
        path.rLineTo(150f, 80f)

        textPaint.color = Color.RED
        textPaint.textSize = sp(16f).toFloat()

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        //第零处，原图
        canvas.save()
        canvas.drawPath(path, paint)
        canvas.drawText("原图", 600f, 120f, textPaint);


        // 第一处：CornerPathEffect（把所有拐角变成圆角）
        canvas.translate(0f, 200f)
        paint.pathEffect = CornerPathEffect(50f)
        canvas.drawPath(path, paint)
        canvas.drawText("1.CornerPathEffect（把所有拐角变成圆角）", 600f, 120f, textPaint);


        // 第二处：DiscretePathEffect(把线条进行随机的偏离，让轮廓变得乱七八糟。乱七八糟的方式和程度由参数决定。)
        canvas.translate(0f, 200f)
        paint.pathEffect = DiscretePathEffect(20f,5f)
        canvas.drawPath(path, paint)
        canvas.drawText("2.DiscretePathEffect", 600f, 120f, textPaint)

        // 第三处：DashPathEffect(使用虚线来绘制线条。)
        canvas.translate(0f, 200f)
        paint.pathEffect = DashPathEffect(floatArrayOf(20f, 10f, 5f, 10f), 0f)
        canvas.drawPath(path, paint)
//        canvas.restore()
        canvas.drawText("3.DashPathEffect(使用虚线来绘制线条。)", 600f, 120f, textPaint)

        // 第四处：PathDashPathEffect(这个方法比 DashPathEffect 多一个前缀 Path ，所以顾名思义，它是使用一个 Path 来绘制「虚线」)
        canvas.translate(0f, 200f)
        val dashPath = Path()
        dashPath.lineTo(20f, -30f)
        dashPath.lineTo(40f, 0f)
        dashPath.close()
        paint.pathEffect = PathDashPathEffect(dashPath, 50f, 0f, PathDashPathEffect.Style.MORPH)
        canvas.drawPath(path, paint)
        canvas.drawText("4.PathDashPathEffect(使用path来绘制线条。)", 600f, 120f, textPaint)


        // 第五处：SumPathEffect(这是一个组合效果类的 PathEffect 。它的行为特别简单，就是分别按照两种 PathEffect 分别对目标进行绘制。)
        canvas.translate(0f, 200f)
        val dashEffect1 = DashPathEffect(floatArrayOf(20f, 10f), 0f)
        val discreteEffect1 = DiscretePathEffect(20f, 5f)
        paint.pathEffect = SumPathEffect(dashEffect1, discreteEffect1)
        canvas.drawPath(path, paint)
        canvas.drawText("5.SumPathEffect(组合效果类)", 600f, 120f, textPaint)


        // 第六处：ComposePathEffect(这也是一个组合效果类的 PathEffect 。不过它是先对目标 Path 使用一个 PathEffect，然后再对这个改变后的 Path 使用另一个 PathEffect。)
        canvas.translate(0f, 200f)
        paint.pathEffect = ComposePathEffect(DashPathEffect(floatArrayOf(20f, 10f), 0f), DiscretePathEffect(20f, 5f))
        canvas.drawPath(path, paint)
        canvas.drawText("6.ComposePathEffect(组合效果类)", 600f, 120f, textPaint)

        canvas.restore()
    }
}
