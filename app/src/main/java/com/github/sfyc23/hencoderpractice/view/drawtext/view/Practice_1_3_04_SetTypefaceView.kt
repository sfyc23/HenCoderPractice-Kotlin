package com.github.sfyc23.hencoderpractice.view.drawtext.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

class Practice_1_3_04_SetTypefaceView : View {
    companion object Factory {
        val TAG = Practice_1_3_04_SetTypefaceView::class.java.simpleName
    }
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var text = "Hello HenCoder"
    var typeface: Typeface

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint.textSize = sp(16f).toFloat()
        typeface = Typeface.createFromAsset(context.assets, "Satisfy-Regular.ttf")
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.setTypeface() 来设置不同的字体

        // 第一处：填入 null 来设置默认字体
        paint.typeface = Typeface.DEFAULT
        canvas.drawText(text + "(DEFAULT)", 50f, 100f, paint)

        // 第二处：填入 Typeface.SERIF 来设置衬线字体（宋体）
        paint.typeface = Typeface.SERIF
        canvas.drawText(text + "(SERIF)", 50f, 200f, paint)

        // 第三处：填入 typeface 对象来使用 assets 目录下的 "Satisfy-Regular.ttf" 文件
        paint.typeface = typeface
        canvas.drawText(text + "(Satisfy-Regular.ttf)", 50f, 300f, paint)
    }
}
