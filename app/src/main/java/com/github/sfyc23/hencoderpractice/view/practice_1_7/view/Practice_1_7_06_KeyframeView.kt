package com.github.sfyc23.hencoderpractice.view.practice_1_7.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.github.sfyc23.base.ext.dp
import com.github.sfyc23.base.ext.dpToFloat

class Practice_1_7_06_KeyframeView : View {
    val radius = dp(80)

    var _progress = 0f
    var progress: Float
        get() = _progress
        set(value) {
            value?.let {
                _progress = value
                invalidate()
            }
        }

/*    internal var progress = 0f

    fun getProgress(): Float {
        return progress
    }

    fun setProgress(progress: Float) {
        this.progress = progress
        invalidate()
    }*/


    var arcRectF = RectF()

    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint.textSize = dpToFloat(40)
        paint.textAlign = Paint.Align.CENTER
    }


    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = width / 2f
        val centerY = height / 2f

        paint.color = Color.parseColor("#E91E63")
        paint.style = Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeWidth = dpToFloat(16)

        arcRectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius)
        canvas.drawArc(arcRectF, 135f, progress * 2.7f, false, paint)

        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
        canvas.drawText("${progress.toInt()}%", centerX, centerY - (paint.ascent() + paint.descent()) / 2, paint)
    }
}
