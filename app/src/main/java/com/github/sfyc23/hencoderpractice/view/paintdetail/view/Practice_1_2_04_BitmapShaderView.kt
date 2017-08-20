package com.github.sfyc23.hencoderpractice.view.paintdetail.view

import android.content.Context
import android.graphics.*
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.sp


class Practice_1_2_04_BitmapShaderView : View {
    companion object Factory {
        val TAG = Practice_1_2_04_BitmapShaderView::class.java.simpleName
    }

    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)//描述性文字
    var bitmap: Bitmap

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        // 用 Paint.setShader(shader) 设置一个 BitmapShader
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman);
        //将 bitmap 缩小一半
        bitmap = Bitmap.createScaledBitmap(bitmap, bitmap.width / 2, bitmap.height / 2, true)

        textPaint.apply {
            color = Color.WHITE//文字颜色
            textSize = sp(16f).toFloat()//文字大小
            textAlign = Paint.Align.CENTER//文字对齐方式，居中对齐
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawText("2.4 BitmapShader", width / 2f, 140f, textPaint)//描述文字

        var bottomHeight = 550f//Y 水平线的坐标点
        var leftWidth = 500f//X 水平线的坐标点
        var rectF = RectF(-350f, -200f, 800f, 200f)

        canvas.save()//保存当前canvas
        canvas.translate(leftWidth, 1f * bottomHeight)//将坐标移到屏幕中央
        paint.shader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        canvas.drawRect(rectF, paint)
        canvas.drawText("1. CLAMP （夹子模式)", 0f, -250f, textPaint)//描述文字
        canvas.restore()//将 canvas 恢复原样


        canvas.save()//保存当前canvas
        canvas.translate(leftWidth, 2f * bottomHeight)//将坐标移到屏幕中央
        paint.shader = BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        canvas.drawRect(rectF, paint)
        canvas.drawText("2.MIRROR （镜像模式)", 0f, -250f, textPaint)//描述文字
        canvas.restore()//将 canvas 恢复原样


        canvas.save()//保存当前canvas
        canvas.translate(leftWidth, 3f * bottomHeight)//将坐标移到屏幕中央
        paint.shader = BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        canvas.drawRect(rectF, paint)
        canvas.drawText("3.REPEAT （重复模式)", 0f, -250f, textPaint)//描述文字
        canvas.restore()//将 canvas 恢复原样
    }
}
