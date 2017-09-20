package com.github.sfyc23.hencoderpractice.view.practice_1_7.view

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout

import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick


class Practice_1_7_05_AnimatorSetLayout : RelativeLayout {

    companion object Factory {
        val TAG = Practice_1_7_05_AnimatorSetLayout::class.java.simpleName
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
            view.translationX = -200f
            val animator1 = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
            val animator2 = ObjectAnimator.ofFloat(view, "translationX", -200f, 200f)
            val animator3 = ObjectAnimator.ofFloat(view, "rotation", 0f, 1080f)
            animator3.setDuration(1000)

            AnimatorSet().apply {
                play(animator1).before(animator2) // 先执行 1 再执行 2
                playTogether(animator2, animator3) // 2 和 3 同时开始
                start()
            }

        }
    }
}
