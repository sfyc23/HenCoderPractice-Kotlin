package com.github.sfyc23.hencoderpractice.view.canvashelp.view

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.dip

class Practice_1_4_13_CameraRotateHittingFaceView : View {
    companion object Factory {
        val TAG = Practice_1_4_13_CameraRotateHittingFaceView::class.java.simpleName
    }
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap

    internal var camera = Camera()
    internal var matrix = Matrix()
    internal var degree: Int = 0
    internal var animator = ObjectAnimator.ofInt(this, "degree", 0, 360)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {

        //将 bitmap 放大俩倍
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
        val scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.width * 2, bitmap.height * 2, true)
        bitmap.recycle()
        bitmap = scaledBitmap

        animator.duration = 5000//旋转周期 5s
        animator.interpolator = LinearInterpolator()//线性插值器
        animator.repeatCount = ValueAnimator.INFINITE//旋转次数，无限循环

        camera.setLocation(0f, 0f, -dip(6f).toFloat())
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animator.start()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animator.end()
    }

    fun setDegree(degree: Int) {
        this.degree = degree
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.save()

        /*
        Canvas 的几何变换顺序是反的，所以要把移动到中心的代码写在下面，把从中心移动回来的代码写在上面。
         */
        camera.save()//保存 Camera 的状态
        camera.rotateX(degree.toFloat())//旋转 Camera 的三维空间
        canvas.translate(width / 2f,  height / 2f) // 旋转之后把投影移动回来
        camera.applyToCanvas(canvas)// 把旋转投影到 Canvas
        canvas.translate(-width / 2f,  -height / 2f)// 旋转之前把绘制内容移动到轴心（原点）
        camera.restore()// 恢复 Camera 的状态

        canvas.drawBitmap(bitmap, width / 2f - bitmap.width / 2f, height / 2f - bitmap.height / 2f, paint)
        canvas.restore()
    }
}