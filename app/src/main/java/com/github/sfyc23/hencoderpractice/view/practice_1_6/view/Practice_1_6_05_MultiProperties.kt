package com.github.sfyc23.hencoderpractice.view.practice_1_6.view

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.dip
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick

class Practice_1_6_05_MultiProperties : RelativeLayout {
    companion object Factory {
        val TAG = Practice_1_6_05_MultiProperties::class.java.simpleName
    }

    lateinit var animateBt: Button
    lateinit var imageView: ImageView
    lateinit var noteTv: TextView
    var animated: Boolean = false

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        animateBt = find<Button>(R.id.animateBt)
        imageView = find<ImageView>(R.id.imageView)
        noteTv = find<TextView>(R.id.noteTv)
        noteTv.text = ".translationX(dip(200))\n" +
                ".rotation(360f)\n" +
                ".scaleX(1f)\n" +
                ".scaleY(1f)\n" +
                ".alpha(1f)"
        imageView.apply {
            scaleX = 0f
            scaleY = 0f
            alpha = 0f
        }

        animateBt.onClick {
            if (!animated) {
                imageView.animate()
                        .translationX(dip(100).toFloat())
                        .rotation(360f)
                        .scaleX(1f)
                        .scaleY(1f)
                        .alpha(1f)
            } else {
                imageView.animate()
                        .translationX(0f)
                        .rotation(360f)
                        .scaleX(1f)
                        .scaleY(1f)
                        .alpha(0f)
            }
            animated = !animated
        }


    }
}
