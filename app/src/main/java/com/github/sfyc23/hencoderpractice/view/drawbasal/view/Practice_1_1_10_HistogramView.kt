package com.github.sfyc23.hencoderpractice.view.drawbasal.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

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

        //先画白色边框
        val whitePaint = Paint()
        whitePaint.color = Color.WHITE
        whitePaint.style = Paint.Style.STROKE
        whitePaint.strokeWidth = 5f

        val path = Path()
        path.moveTo(150f, 50f)
        path.lineTo(150f, 800f)
        path.lineTo(1400f, 800f)
        canvas.drawPath(path, whitePaint)

        //----------------------------------------------------------------------------------

        //柱形图的底部文字
        val bottomPaint = Paint()
        bottomPaint.textSize = 60f
        bottomPaint.color = Color.WHITE
        canvas.drawText("直方图", (width / 2).toFloat(), (height - 50).toFloat(), bottomPaint)

        //----------------------------------------画柱形图------------------------------------------
        val histWidth = 140//柱形图的宽
        val histSpace = 20// 每个柱形图的间隔

        //柱形图的高度
        val histHeights = intArrayOf(20, 60, 60, 250, 400, 650, 460)

        //柱形图的画笔
        val greenPaint = Paint()
        greenPaint.color = Color.GREEN
        greenPaint.style = Paint.Style.STROKE
        greenPaint.strokeWidth = histWidth.toFloat()

        val path1 = Path()
        for (i in 1..histHeights.size) {
            //        path1.reset();
            path1.moveTo((150 + i * (histWidth + histSpace)).toFloat(), 800f)
            path1.lineTo((150 + i * (histWidth + histSpace)).toFloat(), (800 - histHeights[i - 1]).toFloat())
            canvas.drawPath(path1, greenPaint)
        }

        //----------------------------------------画柱形图文字描述------------------------------------------
        //柱形图的文字描述
        val histTexts = arrayOf("Froyo", "GB", "ICS", "JB", "KitKat", "L", "M")
        val textPaint = Paint()
        textPaint.textSize = 40f
        textPaint.color = Color.WHITE

        for (i in 1..histTexts.size) {
            canvas.drawText(histTexts[i - 1], (150 + i * (histWidth + histSpace) - histWidth / 2).toFloat(), 840f, textPaint)
        }


    }
}
