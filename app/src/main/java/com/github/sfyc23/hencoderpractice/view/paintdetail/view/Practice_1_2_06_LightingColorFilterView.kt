package com.github.sfyc23.hencoderpractice.view.paintdetail.view

import android.content.Context
import android.graphics.*
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.sp


class Practice_1_2_06_LightingColorFilterView : View {
    companion object Factory {
        val TAG = Practice_1_2_06_LightingColorFilterView::class.java.simpleName
    }

    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)//描述性文字
    var bitmap: Bitmap

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
        textPaint.apply {
            color = Color.WHITE//文字颜色
            textSize = sp(16f).toFloat()//文字大小
            textAlign = Paint.Align.CENTER//文字对齐方式，居中对齐
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawText("2.6 LightingColorFilter 光亮效果", width / 2f, 140f, textPaint)//描述文字
        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter

        canvas.drawBitmap(bitmap, 160f, 180f, paint)
        canvas.drawText("原图", 300f + bitmap.width, 180f + bitmap.height / 2f, textPaint)//描述文字

        // 第一个 LightingColorFilter：去掉红色部分
//        var lightingColorFilter = LightingColorFilter(0x00ffff, 0x000000)
        paint.colorFilter = LightingColorFilter(0x00ffff, 0x000000)
        canvas.drawBitmap(bitmap, 160f, bitmap.height + 300f, paint)
        canvas.drawText("红色部分", 300f + bitmap.width, 1.5f* bitmap.height + 300f, textPaint)//描述文字

        // 第二个 LightingColorFilter：增强绿色部分
        paint.colorFilter = LightingColorFilter(0x00ffff, 0x003000)
        canvas.drawBitmap(bitmap, 160f, 2 * bitmap.height + 360f, paint)
        canvas.drawText("绿色部分", 300f + bitmap.width, 2.5f * bitmap.height + 360f, textPaint)//描述文字
    }
}
