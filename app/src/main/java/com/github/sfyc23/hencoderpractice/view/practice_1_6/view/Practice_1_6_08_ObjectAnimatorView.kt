package com.github.sfyc23.hencoderpractice.view.practice_1_6.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

import org.jetbrains.anko.dip
import org.jetbrains.anko.sp

class Practice_1_6_08_ObjectAnimatorView : View {
    var radius:Float
    private var progress :Float = 0f
        /*set(value) {
            invalidate()
        }*/
    var arcRectF = RectF()

    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var textPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        radius = dip(80).toFloat()

        paint.apply {
            textSize = sp(16).toFloat()
            textAlign = Paint.Align.CENTER
            color = Color.parseColor("#E91E63")
            style = Paint.Style.STROKE
            strokeCap = Paint.Cap.ROUND
            strokeWidth = dip(15).toFloat()
        }
        textPaint.apply {
            textSize = sp(16).toFloat()
            textAlign = Paint.Align.CENTER
            color = Color.WHITE
            style = Paint.Style.FILL
        }

    }

    fun getProgress(): Float {
        return progress
    }

    fun setProgress(progress: Float) {
        this.progress = progress
        invalidate()
    }


    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = width / 2f
        val centerY = height / 2f


        arcRectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius)
        canvas.drawArc(arcRectF, 135f, progress * 2.7f, false, paint)


        canvas.drawText("${progress.toInt()}%", centerX, centerY - (textPaint.ascent() + textPaint.descent()) / 2, textPaint)
    }
}
