package com.github.sfyc23.hencoderpractice.view.practice_2_1.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.SeekBar
import com.github.sfyc23.base.ext.dpToFloat
import com.github.sfyc23.hencoderpractice.R
import kotlin.properties.Delegates


/**
 * 这个类是用来做 ImageView 外部的可调整框架的，不必关注
 */
class Practice_2_1_01_AdjustablePanel : RelativeLayout {
    lateinit var parentLayout: FrameLayout
    lateinit var heightBar: SeekBar
    lateinit var widthBar: SeekBar

    var bottomMargin: Float by Delegates.notNull<Float>()
//    var minWidth: Float by Delegates.notNull<Float>()
//    var minHeight: Float by Delegates.notNull<Float>()

/*    var bottomMargin :Float by lazy {
        48f
//        dpToFloat(48)
    }*/
    var minWidth = dpToFloat(80)
    var minHeight = dpToFloat(100)



    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        parentLayout = findViewById(R.id.parentLayout)
        widthBar = findViewById(R.id.widthBar)
        heightBar = findViewById(R.id.heightBar)

        bottomMargin = dpToFloat(48)
//        minWidth = dpToFloat(80)
//        minHeight = dpToFloat(100)

        val listener = object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, percent: Int, b: Boolean) {
                val layoutParams = parentLayout.layoutParams as RelativeLayout.LayoutParams
                layoutParams.width = (minWidth + (this@Practice_2_1_01_AdjustablePanel.width - minWidth) * widthBar.progress / 100).toInt()
                layoutParams.height = (minHeight + (this@Practice_2_1_01_AdjustablePanel.height.toFloat()
                        - bottomMargin - minHeight) * heightBar.progress / 100).toInt()
                parentLayout.layoutParams = layoutParams
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        }
        widthBar.setOnSeekBarChangeListener(listener)
        heightBar.setOnSeekBarChangeListener(listener)
    }
}
