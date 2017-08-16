package com.github.sfyc23.hencoderpractice.view.paintdetail.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class Practice_1_2_02_RadialGradientView : View {
    companion object Factory {
        val TAG = Practice_1_2_02_RadialGradientView::class.java.simpleName
    }
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        // 用 Paint.setShader(shader) 设置一个 RadialGradient
        // RadialGradient 的参数：圆心坐标：(300, 300)；半径：200；颜色：#E91E63 到 #2196F3
        //RadialGradient(float centerX, float centerY, float radius, int centerColor, int edgeColor, @NonNull TileMode tileMode) {
        paint.shader = RadialGradient(300f, 300f, 200f, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(300f, 300f, 200f, paint)
    }
}
