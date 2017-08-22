package com.github.sfyc23.hencoderpractice.main

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.sp


/**
 * 如果没有其他的，默认的页面
 */
class PracticeDefaultView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        View(context, attrs, defStyleAttr) {
    companion object Factory {
        val TAG = PracticeDefaultView::class.java.simpleName
    }

    var paint:Paint
    var note: String? = null
//        set(value) {
//            note = value
//        }
//        get() = this.note


    init {

        init(context, attrs, defStyleAttr)
        paint = Paint()
        paint.textSize = sp(16).toFloat();
        paint.textAlign = Paint.Align.CENTER
    }

    fun init(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        if (attrs == null) {
            return
        }
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.PracticeDefaultView, defStyleAttr, 0)
        note = attributes.getString(R.styleable.PracticeDefaultView_note)
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.RED)
        if (note == null) {
            canvas.drawText("请输出 view 的地址", width / 2f, height / 2f, paint)
        } else {
            canvas.drawText(note, width / 2f, height / 2f, paint)
        }

    }
}

