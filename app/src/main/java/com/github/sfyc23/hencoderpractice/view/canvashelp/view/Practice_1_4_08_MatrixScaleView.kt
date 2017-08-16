package com.github.sfyc23.hencoderpractice.view.canvashelp.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.sp

class Practice_1_4_08_MatrixScaleView : View {
    companion object Factory {
        val TAG = Practice_1_4_08_MatrixScaleView::class.java.simpleName
    }
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap
    internal var matrix = Matrix()
    internal var textPaint = Paint()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
        textPaint.color = Color.RED
        textPaint.textSize = sp(16f).toFloat()
        textPaint.textAlign = Paint.Align.CENTER
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //先移动坐标
        canvas.save()
        matrix.reset()
        matrix.postTranslate(width / 6f, height / 2f)
        canvas.concat(matrix)
        canvas.drawBitmap(bitmap, -bitmap.width / 2f, -bitmap.height / 2f, paint)
        canvas.drawText("原文件", 0f, bitmap.height / 2 + 100f, textPaint)
        canvas.restore()


        canvas.save()
        matrix.reset()
        matrix.postTranslate(width * 3 / 6f, height / 2f)
        matrix.postScale(0.8f, 0.8f, bitmap.width / 2f, bitmap.height / 2f)
        canvas.concat(matrix)
        canvas.drawBitmap(bitmap, -bitmap.width / 2f, -bitmap.height / 2f, paint)
        canvas.drawText("放缩0.8", 0f, bitmap.height / 2 + 100f, textPaint)
        canvas.restore()


        canvas.save()
        matrix.reset()
        matrix.postTranslate(width * 5 / 6f, height / 2f)
        matrix.postScale(1f, 1.2f)
        canvas.concat(matrix)
        canvas.drawBitmap(bitmap, -bitmap.width / 2f, -bitmap.height / 2f, paint)
        canvas.drawText("1f,1.2f", 0f, bitmap.height / 2 + 100f, textPaint)
        canvas.restore()
    }
}
