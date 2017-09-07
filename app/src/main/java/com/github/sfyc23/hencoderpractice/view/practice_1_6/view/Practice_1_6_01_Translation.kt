package com.github.sfyc23.hencoderpractice.view.practice_1_6.view

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Outline
import android.graphics.Paint
import android.graphics.Path
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.support.annotation.RequiresApi
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.dip
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.sp

class Practice_1_6_01_Translation : RelativeLayout {

    companion object Factory {
        val TAG = Practice_1_6_01_Translation::class.java.simpleName
    }

    lateinit var animateBt: Button
    lateinit var imageView: ImageView
    lateinit var noteTv: TextView

    var paint: TextPaint

    var translationStateCount = if (SDK_INT > Build.VERSION_CODES.LOLLIPOP) 6 else 4
    var translationState = 0

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint = TextPaint(Paint.ANTI_ALIAS_FLAG)
        paint.apply {
            color = Color.RED
            textSize = sp(16f).toFloat()//文字大小
            textAlign = Paint.Align.CENTER//文字对齐方式，居中对齐
        }
    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animateBt = find<Button>(R.id.animateBt)
        imageView = find<ImageView>(R.id.imageView)
        noteTv = find<TextView>(R.id.noteTv)
        if (SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            // 给音乐图标加上合适的阴影,当进行X轴操作时使用。
            imageView.outlineProvider = MusicOutlineProvider()
        }

        noteTv.text = "onClick translationX(100f)"
        animateBt.onClick {
            when (translationState) {
                0 -> {
                    imageView.animate().translationX(dip(100f).toFloat())
                    noteTv.text = "next translationX(0f)"
                }
                1 -> {
                    imageView.animate().translationX(0f)
                    noteTv.text = "next translationY(50f)"
                }
                2 -> {
                    imageView.animate().translationY(dip(50f).toFloat())

                    noteTv.text = "next translationY(0f)"
                }
                3 -> {
                    imageView.animate().translationY(0f)
                    noteTv.text = "next translationZ(15f)"

                }
                4 -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        imageView.animate().translationZ(dip(15f).toFloat())

                        noteTv.text = "next translationZ(0f)"
                    }
                }
                5 -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        imageView.animate().translationZ(0f)
                        noteTv.text = "next translationX(100f)"
                    }
                }
            }
            translationState++
            if (translationState == translationStateCount) {
                translationState = 0
            }
        }
    }
}

/**
 * 为音乐图标设置三角形的 Outline。
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
class MusicOutlineProvider : ViewOutlineProvider() {
    var path = Path()

    init {
        path.moveTo(0f, dpToPixel(10f))
        path.lineTo(dpToPixel(7f), dpToPixel(2f))
        path.lineTo(dpToPixel(116f), dpToPixel(58f))
        path.lineTo(dpToPixel(116f), dpToPixel(70f))
        path.lineTo(dpToPixel(7f), dpToPixel(128f))
        path.lineTo(0f, dpToPixel(120f))
        path.close()
    }

    override fun getOutline(view: View, outline: Outline) {
        outline.setConvexPath(path)
    }
}

fun dpToPixel(dp: Float): Float {
    val metrics = Resources.getSystem().displayMetrics
    return dp * metrics.density
}