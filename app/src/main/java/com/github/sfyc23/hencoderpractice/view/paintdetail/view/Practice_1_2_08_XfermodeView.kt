package com.github.sfyc23.hencoderpractice.view.paintdetail.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.github.sfyc23.hencoderpractice.R

class Practice_1_2_08_XfermodeView : View {
    companion object Factory {
        val TAG = Practice_1_2_08_XfermodeView::class.java.simpleName
    }
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap1: Bitmap
    internal var bitmap2: Bitmap

    internal var xfermode1: Xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC)
    internal var xfermode2: Xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
    internal var xfermode3: Xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.batman)
        bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 paint.setXfermode() 设置不同的结合绘制效果

        // 别忘了用 canvas.saveLayer() 开启 off-screen buffer

        var saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG)

        canvas.drawBitmap(bitmap1, 0f, 0f, paint)

        // 第一个：PorterDuff.Mode.SRC
        paint.setXfermode(xfermode1)
        canvas.drawBitmap(bitmap2, 0f, 0f, paint)
        paint.setXfermode(null)

        canvas.drawBitmap(bitmap1, (bitmap1.width + 100).toFloat(), 0f, paint)
        // 第二个：PorterDuff.Mode.DST_IN
        paint.setXfermode(xfermode2)
        canvas.drawBitmap(bitmap2, (bitmap1.width + 100).toFloat(), 0f, paint)
        paint.setXfermode(null)

        canvas.drawBitmap(bitmap1, 0f, (bitmap1.height + 20).toFloat(), paint)
        // 第三个：PorterDuff.Mode.DST_OUT
        paint.setXfermode(xfermode3)
        canvas.drawBitmap(bitmap2, 0f, (bitmap1.height + 20).toFloat(), paint)
        paint.setXfermode(null)
        // 用完之后使用 canvas.restore() 恢复 off-screen buffer
        canvas.restoreToCount(saved)
    }
}
