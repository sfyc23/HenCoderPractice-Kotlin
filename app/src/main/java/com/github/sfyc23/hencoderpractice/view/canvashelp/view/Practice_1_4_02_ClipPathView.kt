package com.github.sfyc23.hencoderpractice.view.canvashelp.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.github.sfyc23.hencoderpractice.R

class Practice_1_4_02_ClipPathView : View {
    companion object Factory {
        val TAG = Practice_1_4_02_ClipPathView::class.java.simpleName
    }
    internal var paint = Paint()
    internal var bitmap: Bitmap
    internal var point1 = Point(200, 200)
    internal var point2 = Point(600, 200)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)


        //先移动坐标
        canvas.save()
        canvas.translate(width / 6f, height / 2f)
        canvas.drawBitmap(bitmap, -bitmap.width / 2f, -bitmap.height / 2f, paint)
        canvas.restore()


        canvas.save()
        canvas.translate(width * 3 / 6f, height / 2f)
        var path1 = Path()
        path1.addCircle(0f, 0f, 150f, Path.Direction.CW)
        canvas.clipPath(path1)
        canvas.drawBitmap(bitmap, -bitmap.width / 2f, -bitmap.height / 2f, paint)
        canvas.restore()


        canvas.save()
        canvas.translate(width * 5 / 6f, height / 2f)
        var path2 = Path()
        path2.fillType = Path.FillType.INVERSE_WINDING
        path2.addCircle(0f, 0f, 150f, Path.Direction.CW)
        canvas.clipPath(path2)
        canvas.drawBitmap(bitmap, -bitmap.width / 2f, -bitmap.height / 2f, paint)
        canvas.restore()

    }
}
