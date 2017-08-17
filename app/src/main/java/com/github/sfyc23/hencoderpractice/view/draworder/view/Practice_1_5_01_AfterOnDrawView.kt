package com.github.sfyc23.hencoderpractice.view.draworder.view

/**
 * Author :leilei on 2017/8/16 15:02
 */
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.sp

class Practice_1_5_01_AfterOnDrawView : AppCompatImageView {
    companion object Factory {
        val TAG = Practice_1_5_01_AfterOnDrawView::class.java.simpleName
    }
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 在 super.onDraw() 的下方插入绘制代码，让绘制内容盖住原主体内容

        paint.color = Color.parseColor("#FFC107")
        paint.textSize = sp(10).toFloat()
        drawable?.let {
            canvas.save()
            canvas.concat(getImageMatrix())
            var bounds = drawable.bounds
            canvas.drawText(getResources().getString(R.string.image_size, bounds.width(), bounds.height()), 20f, 40f, paint);
            canvas.restore()
        }
    }


}