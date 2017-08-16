package com.github.sfyc23.hencoderpractice.view.paintdetail.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.sp

/**
NORMAL: 内外都模糊绘制
SOLID: 内部正常绘制，外部模糊
INNER: 内部模糊，外部不绘制
OUTER: 内部不绘制，外部模糊（什么鬼？）
 */
class Practice_1_2_14_MaskFilterView : View {
    companion object Factory {
        val TAG = Practice_1_2_14_MaskFilterView::class.java.simpleName
    }
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap
    internal var textPaint = Paint()
    internal var bitmapHeight: Int
    internal var bitmapWidth: Int

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.what_the_fuck)
        bitmapHeight = bitmap.height
        bitmapWidth = bitmap.width

        textPaint.color = Color.RED
        textPaint.textSize = sp(12f).toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 用 Paint.setMaskFilter 来设置不同的 BlurMaskFilter

        canvas.save()
        // 第零个：原图
        canvas.drawBitmap(bitmap, 100f, 50f, paint)
        canvas.drawText("原图", bitmapWidth + 160f, bitmapHeight / 2 + 50f, textPaint)

        // 第一个：NORMAL（内外都模糊绘制）
        canvas.translate(0f, (bitmapHeight + 100).toFloat())
        paint.setMaskFilter(BlurMaskFilter(50f, BlurMaskFilter.Blur.NORMAL))
        canvas.drawBitmap(bitmap, 100f, 50f, paint)
        canvas.drawText("NORMAL", bitmapWidth + 160f, bitmapHeight / 2 + 50f, textPaint)

        // 第二个：INNER（内部正常绘制，外部模糊）
        canvas.translate(0f, (bitmapHeight + 100).toFloat())
        paint.setMaskFilter(BlurMaskFilter(50f, BlurMaskFilter.Blur.INNER))
        canvas.drawBitmap(bitmap, 100f, 50f, paint)
        canvas.drawText("INNER", bitmapWidth + 160f, bitmapHeight / 2 + 50f, textPaint)

        // 第三个：OUTER（内部模糊，外部不绘制）
        canvas.translate(0f, (bitmapHeight + 100).toFloat())
        paint.setMaskFilter(BlurMaskFilter(50f, BlurMaskFilter.Blur.OUTER))
        canvas.drawBitmap(bitmap, 100f, 50f, paint)
        canvas.drawText("OUTER", bitmapWidth + 160f, bitmapHeight / 2 + 50f, textPaint)

        // 第四个：SOLID（内部不绘制，外部模糊（什么鬼？））
        canvas.translate(0f, (bitmapHeight + 100).toFloat())
        paint.setMaskFilter(BlurMaskFilter(50f, BlurMaskFilter.Blur.SOLID))
        canvas.drawBitmap(bitmap, 100f, 50f, paint)
        canvas.drawText("SOLID", bitmapWidth + 160f, bitmapHeight / 2 + 50f, textPaint)

        canvas.restore()
    }
}
