package com.github.sfyc23.hencoderpractice.view.canvashelp.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.sp

class Practice_1_4_02_ClipPathView : View {
    companion object Factory {
        val TAG = Practice_1_4_02_ClipPathView::class.java.simpleName
    }

    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap
    var textPaint = Paint()

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

        //画一个中心坐标线
        canvas.drawLine(width / 2f, 0f, width / 2f, height.toFloat(), textPaint)
        canvas.drawLine(0f, height * 0.382f, width.toFloat(), height * 0.382f, textPaint)

        //先移动坐标
        canvas.save()
        canvas.translate(width / 6f, height * 0.382f)
        canvas.drawBitmap(bitmap, -bitmap.width / 2f, -bitmap.height / 2f, paint)
        canvas.restore()


        canvas.save()
        canvas.translate(width * 3 / 6f, height * 0.382f)
        var path1 = Path()
        path1.addCircle(0f, 0f, 150f, Path.Direction.CW)
        canvas.clipPath(path1)
        canvas.drawBitmap(bitmap, -bitmap.width / 2f, -bitmap.height / 2f, paint)
        canvas.restore()


        canvas.save()
        canvas.translate(width * 5 / 6f, height * 0.382f)
        var path2 = Path()

        path2.addCircle(0f, 0f, 150f, Path.Direction.CW)
        path2.fillType = Path.FillType.INVERSE_WINDING
        canvas.clipPath(path2)
        canvas.drawBitmap(bitmap, -bitmap.width / 2f, -bitmap.height / 2f, paint)
        canvas.restore()

    }
}
