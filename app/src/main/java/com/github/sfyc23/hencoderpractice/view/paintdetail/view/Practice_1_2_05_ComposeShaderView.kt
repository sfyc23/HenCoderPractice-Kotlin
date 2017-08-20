package com.github.sfyc23.hencoderpractice.view.paintdetail.view

import android.content.Context
import android.graphics.*
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.sp


class Practice_1_2_05_ComposeShaderView : View {

    companion object Factory {
        val TAG = Practice_1_2_05_ComposeShaderView::class.java.simpleName
    }

    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)//描述性文字
    var radius = 250f //圆的半径

    var bpMan: Bitmap
    var shMan: Shader

    var bpLogo: Bitmap
    var shLogo: Shader

    var cs:ComposeShader

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null) // 硬件加速下 ComposeShader 不能使用两个同类型的 Shader

        // 用 Paint.setShader(shader) 设置一个 ComposeShader
        // Shader 1: BitmapShader 图片：R.drawable.batman
        // Shader 2: BitmapShader 图片：R.drawable.batman_logo

        bpMan = BitmapFactory.decodeResource(resources, R.drawable.batman)
        shMan = BitmapShader(bpMan, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

        bpLogo = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)
        shLogo = BitmapShader(bpLogo, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

        cs = ComposeShader(shMan, shLogo, PorterDuff.Mode.DST_OUT)
        textPaint.apply {
            color = Color.WHITE//文字颜色
            textSize = sp(16f).toFloat()//文字大小
            textAlign = Paint.Align.CENTER//文字对齐方式，居中对齐
        }
//        paint.shader = cs
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawText("2.5 ComposeShader 混合着色器", width / 2f, 140f, textPaint)//描述文字
//        canvas.drawCircle(200f, 200f, 200f, paint);

        //第一个实心圆
        canvas.save()//保存当前canvas
        canvas.translate(width / 4f, height / 4f)
//        paint1.pathEffect = DashPathEffect(floatArrayOf(5f), 0f)
        canvas.drawCircle(0f, 0f, radius, paint)
        canvas.drawText("圆形范围", 0f, radius + 140f, textPaint)//描述文字
        canvas.restore()//将canvas恢复原样

        //第一层
        canvas.save()//保存当前canvas
        canvas.translate(width * 3 / 4f, height / 4f)

        canvas.drawBitmap(bpMan, -bpMan.width / 2f, -bpMan.height / 2f, paint)
        canvas.drawText("第一层", 0f, radius + 140f, textPaint)//描述文字
        canvas.restore()//将 canvas 恢复原样

         //第二层
        canvas.save()//保存当前canvas
        canvas.translate(width / 4f, height * 3 / 4f)
        canvas.drawBitmap(bpLogo, -bpLogo.width / 2f, -bpLogo.height / 2f, paint)
        canvas.drawText("第二层", 0f, radius + 140f, textPaint)//描述文字
        canvas.restore()//将 canvas 恢复原样


        canvas.save()//保存当前canvas
        //图像绘制是从当前坐标开始绘制，所以不能将Canvas移动到圆心
        canvas.translate(width * 3 / 4f - radius, height * 3 / 4f - radius)
        paint.shader = cs
        canvas.drawCircle(radius, radius, radius, paint)
        canvas.drawText("绘制效果(DST_OUT)", radius, 2 * radius + 140f, textPaint)//描述文字
        canvas.restore()//将canvas恢复原样
    }
}
