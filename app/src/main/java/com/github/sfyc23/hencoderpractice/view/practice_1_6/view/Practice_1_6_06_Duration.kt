package com.github.sfyc23.hencoderpractice.view.practice_1_6.view

import android.content.Context
import android.util.AttributeSet
import android.widget.*
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.dip
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick


class Practice_1_6_06_Duration : LinearLayout {
    companion object Factory {
        val TAG = Practice_1_6_06_Duration::class.java.simpleName
    }

    lateinit var durationSb: SeekBar
    lateinit var durationValueTv: TextView
    lateinit var animateBt: Button
    lateinit var imageView: ImageView

    var duration = 300L
    var animated: Boolean = false

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        durationSb = find<SeekBar>(R.id.durationSb)
        durationValueTv = find<TextView>(R.id.durationValueTv)
        durationValueTv.text = context.getString(R.string.ms_with_value, duration)
        durationSb.max = 10
        durationSb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                duration = progress * 300L
                durationValueTv.text = context.getString(R.string.ms_with_value, duration)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })

        animateBt = find<Button>(R.id.animateBt)
        imageView = find<ImageView>(R.id.imageView)
        animateBt.onClick {
            if (!animated) {
                imageView.animate().translationX(dip(100).toFloat()).duration = duration
            } else {
                imageView.animate().translationX(0f).duration = duration
            }
            animated = !animated
        }
    }
}
