package com.github.sfyc23.hencoderpractice.view.paintdetail.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.github.sfyc23.hencoderpractice.R


class Practice_1_2_05_ComposeShaderView : View {

    companion object Factory {
        val TAG = Practice_1_2_05_ComposeShaderView::class.java.simpleName
    }

    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null) // 硬件加速下 ComposeShader 不能使用两个同类型的 Shader

        // 用 Paint.setShader(shader) 设置一个 ComposeShader
        // Shader 1: BitmapShader 图片：R.drawable.batman
        // Shader 2: BitmapShader 图片：R.drawable.batman_logo

        var bp1 = BitmapFactory.decodeResource(resources, R.drawable.batman)
        var s1: Shader = BitmapShader(bp1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        var bp2 = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)
        var s2: Shader = BitmapShader(bp2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        var cs = ComposeShader(s1,s2,PorterDuff.Mode.DST_IN);
        paint.shader = cs;
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(200f, 200f, 200f, paint)
    }
}
