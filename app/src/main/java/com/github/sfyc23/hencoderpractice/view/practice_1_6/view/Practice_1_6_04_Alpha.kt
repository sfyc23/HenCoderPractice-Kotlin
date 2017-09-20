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

class Practice_1_6_04_Alpha : RelativeLayout {

    companion object Factory {
        val TAG = Practice_1_6_04_Alpha::class.java.simpleName
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
        noteTv.text = "next alpha(0.5f)"
        animateBt.onClick {
            when (state) {
                0 -> {
                    imageView.animate().alpha(0.5f)
                    noteTv.text = "next alpha(1f)"
                }
                1 -> {
                    imageView.animate().alpha(1f)
                    noteTv.text = "next alpha(0f)"
                }
                2 -> {
                    imageView.animate().alpha(0f)
                    noteTv.text = "next alpha(1f)"
                }
                3 -> {
                    imageView.animate().alpha(1f)
                    noteTv.text = "next alpha(0.5f)"
                }
            }
            state++
            if (state == 4) {
                state = 0
            }
        }
    }
}