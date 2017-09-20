package com.github.sfyc23.hencoderpractice.view.paintdetail.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

class Practice_1_2_11_StrokeMiterView : View {
    companion object Factory {
        val TAG = Practice_1_2_11_StrokeMiterView::class.java.simpleName
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

        canvas.translate(100f, 100f)
        canvas.drawPath(path, paint)
        canvas.drawText("原图(默认)", 300f, 60f, textPaint);

        // MITER 值：1
        canvas.translate(0f, 250f)
        paint.strokeMiter = 1f;
        canvas.drawPath(path, paint)
        canvas.drawText("MITER 值：1", 300f, 60f, textPaint);

        canvas.translate(0f, 250f)
        // MITER 值：2
        paint.strokeMiter = 2f;
        canvas.drawPath(path, paint)
        canvas.drawText("MITER 值：2", 300f, 60f, textPaint);


        canvas.translate(0f, 250f)
        // MITER 值：5
        paint.strokeMiter = 5f;
        canvas.drawPath(path, paint)
        canvas.drawText("MITER 值：5", 300f, 60f, textPaint);

        canvas.restore()
    }
}
