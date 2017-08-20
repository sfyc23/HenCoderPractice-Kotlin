package com.github.sfyc23.hencoderpractice.view.drawbasal.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

class Practice_1_1_10_HistogramView : View {

    companion object Factory {
        val TAG = Practice_1_1_10_HistogramView::class.java.simpleName
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //        综合练习
        //        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        var bottomHeight = height * 0.5f//Y 水平线的坐标点
        var leftWidth = 150f//X 水平线的坐标点
        val histWidth = 140f//柱形图的宽
        val histSpace = 20f// 每个柱形图的间隔

        //---------------------------先画白色边框---------------------------
        val whitePaint = Paint()
        whitePaint.color = Color.WHITE
        whitePaint.style = Paint.Style.STROKE
        whitePaint.strokeWidth = 5f

        val path = Path()
        path.moveTo(leftWidth, 50f)
        path.lineTo(leftWidth, bottomHeight)
        path.lineTo(1400f, bottomHeight)
        canvas.drawPath(path, whitePaint)


        //----------------------------------------画柱形图------------------------------------------

        val histHeights = floatArrayOf(20f, 60f, 60f, 250f, 400f, 650f, 460f) //柱形图的高度

        val greenPaint = Paint() //柱形图的画笔
        greenPaint.color = Color.GREEN
        greenPaint.style = Paint.Style.STROKE
        greenPaint.strokeWidth = histWidth


        val path1 = Path()
        var tempXPaint = 0f
        canvas.drawPath(path1, greenPaint)
        for (i in histHeights.indices) {
            tempXPaint = 150 + 0.5f * histWidth + (i + 1) * histSpace + i * histWidth
            path1.moveTo(tempXPaint, bottomHeight)
            path1.lineTo(tempXPaint, bottomHeight - histHeights[i])
            canvas.drawPath(path1, greenPaint)
        }

        //----------------------------------------画柱形图文字描述------------------------------------------
        val histTexts = arrayOf("Froyo", "GB", "ICS", "JB", "KitKat", "L", "M")
        val textPaint = Paint()
        textPaint.textSize = sp(10).toFloat()
        textPaint.color = Color.WHITE
        textPaint.textAlign = Paint.Align.CENTER//文字对齐方式，居中对齐

        for (i in histTexts.indices) {
            canvas.drawText(histTexts[i], leftWidth + (i + 1) * (histWidth + histSpace) - histWidth / 2, bottomHeight + 50f, textPaint)
        }

        //---------------------------柱形图的底部文字---------------------------
        val bottomPaint = Paint()
        bottomPaint.textSize = sp(18).toFloat()
        bottomPaint.color = Color.WHITE
        bottomPaint.textAlign = Paint.Align.CENTER//文字对齐方式，居中对齐
        canvas.drawText("直方图", width / 2f, bottomHeight + 200f, bottomPaint)

    }
}
