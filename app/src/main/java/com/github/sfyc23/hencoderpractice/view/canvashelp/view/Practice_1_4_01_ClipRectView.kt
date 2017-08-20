package com.github.sfyc23.hencoderpractice.view.canvashelp.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.github.sfyc23.hencoderpractice.R

import org.jetbrains.anko.sp

class Practice_1_4_01_ClipRectView : View {

    companion object Factory {
        val TAG = Practice_1_4_01_ClipRectView::class.java.simpleName
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


        //画一个中心坐标线
        canvas.drawLine(width / 2f, 0f, width / 2f, height.toFloat(), textPaint)
        canvas.drawLine(0f, height * 0.382f, width.toFloat(), height * 0.382f, textPaint)

        //原图
        canvas.save()//保存 canvas 的状态
        canvas.translate(width / 4f, height * 0.382f)//将坐标移动到中心位置
        canvas.drawBitmap(bitmap, -bitmap.width / 2f, -bitmap.height / 2f, paint)//将图标刚好绘制到中心位置
        canvas.drawText("原内容", 0f, bitmap.height / 2f + 100f, textPaint)//一些描述文字
        canvas.restore()//恢复 canvas 的状态


        //裁剪后
        canvas.save()
        canvas.translate(width * 3 / 4f, height * 0.382f)

        canvas.save()
        canvas.clipRect(-bitmap.width / 2f, -100f, 300f, bitmap.width / 2f);
        canvas.drawBitmap(bitmap, -bitmap.width / 2f, -bitmap.height / 2f, paint)
        canvas.restore()

        canvas.drawText("裁剪后", 0f, bitmap.height / 2f + 100f, textPaint)

        canvas.restore()


    }
}
