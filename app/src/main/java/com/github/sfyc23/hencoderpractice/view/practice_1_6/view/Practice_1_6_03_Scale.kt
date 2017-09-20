package com.github.sfyc23.hencoderpractice.view.practice_1_6.view

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick

class Practice_1_6_03_Scale : RelativeLayout {

    companion object Factory {
        val TAG = Practice_1_6_03_Scale::class.java.simpleName
    }

    lateinit var animateBt: Button
    lateinit var imageView: ImageView
    lateinit var noteTv: TextView
    var state = 0

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animateBt = find<Button>(R.id.animateBt)
        imageView = find<ImageView>(R.id.imageView)
        noteTv = find<TextView>(R.id.noteTv)
        noteTv.text = "next scaleX(1.5f)"
        animateBt.onClick {
            when (state) {
                0 -> {
                    imageView.animate().scaleX(1.5f)
                    noteTv.text = "next scaleX(1f)"
                }
                1 -> {
                    imageView.animate().scaleX(1f)
                    noteTv.text = "next scale(0.5f)"
                }
                2 -> {
                    imageView.animate().scaleY(0.5f)
                    noteTv.text = "next scaleY(1.0f)"
                }
                3 -> {
                    imageView.animate().scaleY(1.0f)
                    noteTv.text = "next scaleX(1.5f)"
                }
            }
            state++
            if (state == 4) {
                state = 0
            }
        }
    }
}