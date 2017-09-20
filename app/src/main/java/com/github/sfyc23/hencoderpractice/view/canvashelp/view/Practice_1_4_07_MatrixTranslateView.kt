package com.github.sfyc23.hencoderpractice.view.canvashelp.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.github.sfyc23.hencoderpractice.R


class Practice_1_4_07_MatrixTranslateView : View {
    companion object Factory {
        val TAG = Practice_1_4_07_MatrixTranslateView::class.java.simpleName
    }
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap
    var myMatrix = Matrix()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        myMatrix.reset()
        myMatrix.postTranslate(width / 4f, height / 2f)
        canvas.concat(myMatrix)
        canvas.drawBitmap(bitmap, -bitmap.width / 2f, -bitmap.height / 2f, paint)
        canvas.restore()

        canvas.save()
        myMatrix.reset()
        myMatrix.postTranslate(width * 3 / 4f, height / 2f)
        canvas.concat(myMatrix)
//        canvas.drawBitmap(bitmap, 0f, 0f, paint)
        canvas.drawBitmap(bitmap, -bitmap.width / 2f, -bitmap.height / 2f, paint)
        canvas.restore()

    }
}
