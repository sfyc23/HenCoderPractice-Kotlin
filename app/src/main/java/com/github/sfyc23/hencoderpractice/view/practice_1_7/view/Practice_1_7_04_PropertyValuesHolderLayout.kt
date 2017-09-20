package com.github.sfyc23.hencoderpractice.view.practice_1_7.view

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout

import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick


class Practice_1_7_04_PropertyValuesHolderLayout : RelativeLayout {
    companion object Factory {
        val TAG = Practice_1_7_04_PropertyValuesHolderLayout::class.java.simpleName
    }

    lateinit var view: View
    lateinit var animateBt: Button

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        view = find(R.id.objectAnimatorView)
        animateBt = find<Button>(R.id.animateBt)

        animateBt.onClick {
            val holder1 = PropertyValuesHolder.ofFloat("scaleX", 0f, 1f)
            val holder2 = PropertyValuesHolder.ofFloat("scaleY", 0f, 1f)
            val holder3 = PropertyValuesHolder.ofFloat("alpha", 0f, 1f)

            ObjectAnimator.ofPropertyValuesHolder(view, holder1, holder2, holder3).start()

        }
    }
}
