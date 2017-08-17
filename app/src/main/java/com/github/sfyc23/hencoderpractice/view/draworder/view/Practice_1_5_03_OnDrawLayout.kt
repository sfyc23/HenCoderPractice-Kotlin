package com.hencoder.hencoderpracticedraw5.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.LinearLayout

class Practice_1_5_03_OnDrawLayout : LinearLayout {
    companion object Factory {
        val TAG = Practice_1_5_03_OnDrawLayout::class.java.simpleName
    }

    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        // 在这里插入 setWillNotDraw(false) 以启用完整的绘制流程
        setWillNotDraw(false)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var pattern1 = Pattern(width,height)
        pattern1.draw(canvas)
    }

    private class Pattern {

        companion object Factory {
            private val PATTERN_RATIO = 5f / 6
        }

        internal var patternPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        lateinit var spots: Array<Spot>
        var width: Int = 0
        var height: Int = 0

        constructor (width: Int, height: Int) {
            this.width = width
            this.height = height
//            spots = emptyArray()
//            spots[0] = Spot(0.24f, 0.3f, 0.026f)
//            spots[1] = Spot(0.69f, 0.25f, 0.067f)
//            spots[2] = Spot(0.32f, 0.6f, 0.067f)
//            spots[3] = Spot(0.62f, 0.78f, 0.083f)
            spots = arrayOf(Spot(0.24f, 0.3f, 0.026f),Spot(0.69f, 0.25f, 0.067f),Spot(0.32f, 0.6f, 0.067f),Spot(0.62f, 0.78f, 0.083f))
            patternPaint.color = Color.parseColor("#A0E91E63")
        }

         fun draw(canvas: Canvas) {
            val repitition = Math.ceil((width.toFloat() / height).toDouble()).toInt()
            for (i in 0..spots.size * repitition - 1) {
                val spot = spots[i % spots.size]
                canvas.drawCircle((i / spots.size).toFloat() * height.toFloat() * PATTERN_RATIO + spot.relativeX * height,
                        spot.relativeY * height,
                        spot.relativeSize * height, patternPaint)
            }
        }
    }

    class Spot(val relativeX: Float, val relativeY: Float, val relativeSize: Float)
}
