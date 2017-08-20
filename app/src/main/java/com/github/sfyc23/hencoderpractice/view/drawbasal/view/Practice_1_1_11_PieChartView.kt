package com.github.sfyc23.hencoderpractice.view.drawbasal.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.util.Log
import android.view.View

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
class Practice_1_1_11_PieChartView : View {

    companion object Factory {
        val TAG = Practice_1_1_11_PieChartView::class.java.simpleName
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //        综合练习
        //        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        val paint6 = Paint(Paint.ANTI_ALIAS_FLAG)

        val centerX = width / 2f
        val centerY = height * 0.382f
        val radius = 350f


        val paintTest = Paint()
        paintTest.style = Paint.Style.FILL
        paintTest.strokeWidth = 20f

        val texts = arrayOf("Lollipop", "Marshmallow", "Froyo", "Gingerbread", "Ice Cream SandWich", "JellyBean", "KitKat")

        val colors = arrayOf("#9926b7", "#9f9f9d", "#009788", "#2196f3", "#f44236", "#fec107")
        val Angles = intArrayOf(10, 10, 35, 125, 125, 55)

        val paint = Paint()
        paint.style = Paint.Style.FILL
        var currentAngle = 0
        for (i in Angles.indices) {
            paint.color = Color.parseColor(colors[i])
            val sweepAngle = Angles[i]
            canvas.drawArc(300f, 50f, 1000f, 750f, currentAngle.toFloat(), (sweepAngle - 2).toFloat(), true, paint)// 绘制扇形
            currentAngle += sweepAngle


            var angleMath = 0.0
            if (currentAngle > 180) {
                angleMath = (360 - currentAngle) * 3.14 / 180
            } else {
                angleMath = -currentAngle * 3.14 / 180
            }
            val d1 = (360 - currentAngle) * 3.14 / 180
            val d2 = -currentAngle * 3.14 / 180
            Log.e("TAG,", (Math.cos(d1) == Math.cos(d2)).toString() + "")

//            val x1 = (centerX + radius * Math.cos(angleMath)).toInt()
//            val y1 = (centerY + radius * Math.sin(angleMath)).toInt()
//            canvas.drawCircle(x1.toFloat(), y1.toFloat(), 10f, paintTest)
        }


    }


}
