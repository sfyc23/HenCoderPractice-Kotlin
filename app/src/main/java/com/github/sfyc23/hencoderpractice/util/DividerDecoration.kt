package com.github.sfyc23.hencoderpractice.util

/**
 * Author :leilei on 2017/8/18 11:29
 */
import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.View

/**
 * A simple divider decoration with customizable colour, height, and left and right padding.
 */
class DividerDecoration private constructor(
        private val mHeight: Int,
        private val mLPadding: Int,
        private val mRPadding: Int,
        colour: Int) : RecyclerView.ItemDecoration() {
    private val mPaint: Paint

    init {
        mPaint = Paint()
        mPaint.color = colour
    }

    /**
     * {@inheritDoc}
     */
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
        val count = parent.childCount

        for (i in 0..count - 1) {
            val child = parent.getChildAt(i)
            val top = child.bottom
            val bottom = top + mHeight

            val left = child.left + mLPadding
            val right = child.right - mRPadding

            c.save()
            c.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), mPaint)
            c.restore()
        }
    }

    /**
     * {@inheritDoc}
     */
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        outRect.set(0, 0, 0, mHeight)
    }

    /**
     * A basic builder for divider decorations. The default builder creates a 1px thick black divider decoration.
     */
    class Builder(context: Context) {
        private val mResources: Resources
        private var mHeight: Int = 0
        private var mLPadding: Int = 0
        private var mRPadding: Int = 0
        private var mColour: Int = 0

        init {
            mResources = context.resources
            mHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX,
                    1f, context.resources.displayMetrics).toInt()
            mLPadding = 0
            mRPadding = 0
            mColour = Color.BLACK
        }

        /**
         * Set the divider height in pixels
         * @param pixels height in pixels
         * *
         * @return the current instance of the Builder
         */
        fun setHeight(pixels: Float): Builder {
            mHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, pixels, mResources.displayMetrics).toInt()

            return this
        }

        /**
         * Set the divider height in dp
         * @param resource height resource id
         * *
         * @return the current instance of the Builder
         */
        fun setHeight(@DimenRes resource: Int): Builder {
            mHeight = mResources.getDimensionPixelSize(resource)
            return this
        }

        /**
         * Sets both the left and right padding in pixels
         * @param pixels padding in pixels
         * *
         * @return the current instance of the Builder
         */
        fun setPadding(pixels: Float): Builder {
            setLeftPadding(pixels)
            setRightPadding(pixels)

            return this
        }

        /**
         * Sets the left and right padding in dp
         * @param resource padding resource id
         * *
         * @return the current instance of the Builder
         */
        fun setPadding(@DimenRes resource: Int): Builder {
            setLeftPadding(resource)
            setRightPadding(resource)
            return this
        }

        /**
         * Sets the left padding in pixels
         * @param pixelPadding left padding in pixels
         * *
         * @return the current instance of the Builder
         */
        fun setLeftPadding(pixelPadding: Float): Builder {
            mLPadding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, pixelPadding, mResources.displayMetrics).toInt()

            return this
        }

        /**
         * Sets the right padding in pixels
         * @param pixelPadding right padding in pixels
         * *
         * @return the current instance of the Builder
         */
        fun setRightPadding(pixelPadding: Float): Builder {
            mRPadding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, pixelPadding, mResources.displayMetrics).toInt()

            return this
        }

        /**
         * Sets the left padding in dp
         * @param resource left padding resource id
         * *
         * @return the current instance of the Builder
         */
        fun setLeftPadding(@DimenRes resource: Int): Builder {
            mLPadding = mResources.getDimensionPixelSize(resource)

            return this
        }

        /**
         * Sets the right padding in dp
         * @param resource right padding resource id
         * *
         * @return the current instance of the Builder
         */
        fun setRightPadding(@DimenRes resource: Int): Builder {
            mRPadding = mResources.getDimensionPixelSize(resource)

            return this
        }

        /**
         * Sets the divider colour
         * @param resource the colour resource id
         * *
         * @return the current instance of the Builder
         */
        fun setColorResource(@ColorRes resource: Int): Builder {
            setColor(mResources.getColor(resource))

            return this
        }

        /**
         * Sets the divider colour
         * @param color the colour
         * *
         * @return the current instance of the Builder
         */
        fun setColor(@ColorInt color: Int): Builder {
            mColour = color

            return this
        }

        /**
         * Instantiates a DividerDecoration with the specified parameters.
         * @return a properly initialized DividerDecoration instance
         */
        fun build(): DividerDecoration {
            return DividerDecoration(mHeight, mLPadding, mRPadding, mColour)
        }
    }
}
