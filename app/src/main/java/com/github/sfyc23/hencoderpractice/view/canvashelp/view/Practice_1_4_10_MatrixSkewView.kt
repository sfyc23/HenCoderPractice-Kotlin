package com.github.sfyc23.hencoderpractice.view.canvashelp.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.sp

class Practice_1_4_10_MatrixSkewView : View {
    companion object Factory {
        val TAG = Practice_1_4_10_MatrixSkewView::class.java.simpleName
    }

    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap
    var myMatrix = Matrix()
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

        //先移动坐标
        canvas.save()
        myMatrix.reset()
        myMatrix.postTranslate(width / 4f, height * 0.382f)
        myMatrix.postSkew(0f, -0.5f, width / 4f, height * 0.382f)
        canvas.concat(myMatrix)
        canvas.drawBitmap(bitmap, -bitmap.width / 2f, -bitmap.height / 2f, paint)
        canvas.drawText("Y轴 45度", 0f, bitmap.height / 2 + 100f, textPaint)
        canvas.restore()



        canvas.save()
        myMatrix.reset()
        myMatrix.postTranslate(width * 3 / 4f, height * 0.382f)
        myMatrix.postSkew(-0.5f, 0f, width * 3 / 4f, height * 0.382f)
        canvas.concat(myMatrix)
        canvas.drawBitmap(bitmap, -bitmap.width / 2f, -bitmap.height / 2f, paint)
        canvas.drawText("Y轴 -45度", 0f, bitmap.height / 2 + 100f, textPaint)
        canvas.restore()
    }
}
