package com.github.sfyc23.hencoderpractice.view.practice_1_6.view

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.find

class Practice_1_6_02_Rotation : RelativeLayout {

    companion object Factory {
        val TAG = Practice_1_6_02_Rotation::class.java.simpleName
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
        noteTv.text = "next rotation(180f)"
        animateBt.setOnClickListener {
            when (state) {
                0 -> {
                    imageView.animate().rotation(180f)
                    noteTv.text = "next rotation(0f)"
                }
                1 -> {
                    imageView.animate().rotation(0f)
                    noteTv.text = "next rotationX(180f)"
                }
                2 -> {
                    imageView.animate().rotationX(180f)
                    noteTv.text = "next rotationX(0f)"
                }
                3 -> {
                    imageView.animate().rotationX(0f)
                    noteTv.text = "next rotationY(180f)"
                }
                4 -> {
                    imageView.animate().rotationY(180f)
                    noteTv.text = "next rotationY(0f)"
                }
                5 -> {
                    imageView.animate().rotationY(0f)
                    noteTv.text = "next rotation(180f)"
                }
            }
            state++
            if (state == 6) {
                state = 0
            }
        }
    }
}