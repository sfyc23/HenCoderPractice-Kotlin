package com.github.sfyc23.hencoderpractice.view.canvashelp.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.github.sfyc23.hencoderpractice.R

import org.jetbrains.anko.sp

class Practice_1_4_05_RotateView : View {
    companion object Factory {
        val TAG = Practice_1_4_05_RotateView::class.java.simpleName
    }
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap
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
        canvas.translate(width / 6f, height / 2f)
        canvas.drawBitmap(bitmap, -bitmap.width / 2f, -bitmap.height / 2f, paint)
        canvas.drawText("原文件", 0f, bitmap.height / 2 + 100f, textPaint)
        canvas.restore()


        canvas.save()
        canvas.translate(width * 3 / 6f, height / 2f)

        canvas.save()
        canvas.rotate(45f)
        canvas.drawBitmap(bitmap, -bitmap.width / 2f, -bitmap.height / 2f, paint)
        canvas.restore()

        canvas.drawText("45度(中心)", 0f, bitmap.height / 2 + 200f, textPaint)
        canvas.restore()



        canvas.save()
        canvas.translate(width * 5 / 6f, height / 2f)
        canvas.save()
        canvas.rotate(180f, 100f, 100f)
        canvas.drawBitmap(bitmap, -bitmap.width / 2f, -bitmap.height / 2f, paint)
        canvas.restore()
        canvas.drawText("180度(偏)", 0f, bitmap.height / 2 + 100f, textPaint)
        canvas.restore()
    }
}