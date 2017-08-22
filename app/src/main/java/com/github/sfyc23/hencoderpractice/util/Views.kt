package com.hencoder.hencoderpracticedraw1.kt

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.Gravity
import android.view.View
import android.view.ViewManager
import android.widget.ImageView
import android.widget.LinearLayout
import com.github.sfyc23.hencoderpractice.R
import com.github.sfyc23.hencoderpractice.main.PracticeDefaultView
import com.github.sfyc23.hencoderpractice.view.canvashelp.view.*
import com.github.sfyc23.hencoderpractice.view.drawbasal.view.*
import com.github.sfyc23.hencoderpractice.view.draworder.view.Practice_1_5_01_AfterOnDrawView
import com.github.sfyc23.hencoderpractice.view.drawtext.view.*
import com.github.sfyc23.hencoderpractice.view.paintdetail.view.*
import com.github.sfyc23.hencoderpractice.view.paintdetail.view.Practice_1_2_03_SweepGradientView
import com.github.sfyc23.hencoderpractice.view.paintdetail.view.Practice_1_2_04_BitmapShaderView
import com.hencoder.hencoderpracticedraw5.practice.*
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView

@RequiresApi(Build.VERSION_CODES.M)
        /**
         * Author :leilei on 2017/8/13 22:26
         */

fun ViewManager.practice1View(tag: String, theme: Int = 0): View {

    when (tag) {
    //--------------------------------1.1 绘制基础------------------------------------
        Practice_1_1_1_DrawColorView.TAG -> return practice_1_1_1_DrawColorView(theme) {}
        Practice_1_1_2_DrawCircleView.TAG -> return practice_1_1_2_DrawCircleView(theme) {}
        Practice_1_1_3_DrawRectView.TAG -> return practice_1_1_3_DrawRectView(theme) {}
        Practice_1_1_4_DrawPointView.TAG -> return practice_1_1_4_DrawPointView(theme) {}
        Practice_1_1_5_DrawOvalView.TAG -> return practice_1_1_5_DrawOvalView(theme) {}

        Practice_1_1_6_DrawLineView.TAG -> return practice_1_1_6_DrawLineView(theme) {}
        Practice_1_1_7_DrawRoundRectView.TAG -> return practice_1_1_7_DrawRoundRectView(theme) {}
        Practice_1_1_8_DrawArcView.TAG -> return practice_1_1_8_DrawArcView(theme) {}
        Practice_1_1_9_DrawPathView.TAG -> return practice_1_1_9_DrawPathView(theme) {}
        Practice_1_1_10_HistogramView.TAG -> return practice_1_1_10_HistogramView(theme) {}

        Practice_1_1_11_PieChartView.TAG -> return practice_1_1_11_PieChartView(theme) {}

    //-------------------------------- 1.2 paint 详细 ------------------------------------
        Practice_1_2_01_LinearGradientView.TAG -> return practice_1_2_01_LinearGradientView(theme) {}
        Practice_1_2_02_RadialGradientView.TAG -> return practice_1_2_02_RadialGradientView(theme) {}
        Practice_1_2_03_SweepGradientView.TAG -> return practice_1_2_03_SweepGradientView(theme) {}
        Practice_1_2_04_BitmapShaderView.TAG -> return practice_1_2_04_BitmapShaderView(theme) {}
        Practice_1_2_05_ComposeShaderView.TAG -> return practice_1_2_05_ComposeShaderView(theme) {}

        Practice_1_2_06_LightingColorFilterView.TAG -> return practice_1_2_06_LightingColorFilterView(theme) {}
        Practice_1_2_07_ColorMatrixColorFilterView.TAG -> return practice_1_2_07_ColorMatrixColorFilterView(theme) {}
        Practice_1_2_08_XfermodeView.TAG -> return practice_1_2_08_XfermodeView(theme) {}
        Practice_1_2_09_StrokeCapView.TAG -> return practice_1_2_09_StrokeCapView(theme) {}
        Practice_1_2_10_StrokeJoinView.TAG -> return practice_1_2_10_StrokeJoinView(theme) {}

        Practice_1_2_11_StrokeMiterView.TAG -> return practice_1_2_11_StrokeMiterView(theme) {}
        Practice_1_2_12_PathEffectView.TAG -> return practice_1_2_12_PathEffectView(theme) {}
        Practice_1_2_13_ShadowLayerView.TAG -> return practice_1_2_13_ShadowLayerView(theme) {}
        Practice_1_2_14_MaskFilterView.TAG -> {
            return  practice_1_2_14_MaskFilterView(theme){}
        }
        Practice_1_2_15_FillPathView.TAG -> return practice_1_2_15_FillPathView(theme) {}
        Practice_1_2_16_TextPathView.TAG -> return practice_1_2_16_TextPathView(theme) {}


    //-------------------------------- 1.3 draw text ------------------------------------
        Practice_1_3_01_DrawTextView.TAG -> return practice_1_3_01_DrawTextView(theme) {}
        Practice_1_3_02_StaticLayoutView.TAG -> return practice_1_3_02_StaticLayoutView(theme) {}
        Practice_1_3_03_SetTextSizeView.TAG -> return practice_1_3_03_SetTextSizeView(theme) {}
        Practice_1_3_04_SetTypefaceView.TAG -> return practice_1_3_04_SetTypefaceView(theme) {}
        Practice_1_3_05_SetFakeBoldTextView.TAG -> return practice_1_3_05_SetFakeBoldTextView(theme) {}

        Practice_1_3_06_SetStrikeThruTextView.TAG -> return practice_1_3_06_SetStrikeThruTextView(theme) {}
        Practice_1_3_07_SetUnderlineTextView.TAG -> return practice_1_3_07_SetUnderlineTextView(theme) {}
        Practice_1_3_08_SetTextSkewXView.TAG -> return practice_1_3_08_SetTextSkewXView(theme) {}
        Practice_1_3_09_SetTextScaleXView.TAG -> return practice_1_3_09_SetTextScaleXView(theme) {}
        Practice_1_3_10_SetTextAlignView.TAG -> return practice_1_3_10_SetTextAlignView(theme) {}

        Practice_1_3_11_GetFontSpacingView.TAG -> return practice_1_3_11_GetFontSpacingView(theme) {}
        Practice_1_3_12_MeasureTextView.TAG -> return practice_1_3_12_MeasureTextView(theme) {}
        Practice_1_3_13_GetTextBoundsView.TAG -> return practice_1_3_13_GetTextBoundsView(theme) {}
        Practice_1_3_14_GetFontMetricsView.TAG -> return practice_1_3_14_GetFontMetricsView(theme) {}


    //--------------------------------start 1.4 draw 助手 start------------------------------------
        Practice_1_4_01_ClipRectView.TAG -> return practice_1_4_01_ClipRectView(theme) {}
        Practice_1_4_02_ClipPathView.TAG -> return practice_1_4_02_ClipPathView(theme) {}
        Practice_1_4_03_TranslateView.TAG -> return practice_1_4_03_TranslateView(theme) {}
        Practice_1_4_04_ScaleView.TAG -> return practice_1_4_04_ScaleView(theme) {}
        Practice_1_4_05_RotateView.TAG -> return practice_1_4_05_RotateView(theme) {}

        Practice_1_4_06_SkewView.TAG -> return practice_1_4_06_SkewView(theme) {}
        Practice_1_4_07_MatrixTranslateView.TAG -> return practice_1_4_07_MatrixTranslateView(theme) {}
        Practice_1_4_08_MatrixScaleView.TAG -> return practice_1_4_08_MatrixScaleView(theme) {}
        Practice_1_4_09_MatrixRotateView.TAG -> return practice_1_4_09_MatrixRotateView(theme) {}

        Practice_1_4_10_MatrixSkewView.TAG -> return practice_1_4_10_MatrixSkewView(theme) {}
        Practice_1_4_11_CameraRotateView.TAG -> return practice_1_4_11_CameraRotateView(theme) {}
        Practice_1_4_12_CameraRotateFixedView.TAG -> return practice_1_4_12_CameraRotateFixedView(theme) {}
        Practice_1_4_13_CameraRotateHittingFaceView.TAG -> return practice_1_4_13_CameraRotateHittingFaceView(theme) {}
        Practice_1_4_14_FlipboardView.TAG -> return practice_1_4_14_FlipboardView(theme) {}


        Practice_1_5_01_AfterOnDrawView.TAG -> {
            return frameLayout() {
                practice_1_5_01_AfterOnDrawView(theme) {
                    scaleType = ImageView.ScaleType.CENTER_CROP
                    imageResource = R.drawable.batman
                }.lparams(width = dip(200), height = dip(200)) {
                    gravity = Gravity.CENTER
                }
            }
        }
        Practice_1_5_02_BeforeOnDrawView.TAG -> {
            return frameLayout() {
                practice_1_5_02_BeforeOnDrawView(theme) {
                    textResource = R.string.about_hencoder
                    textSize = 16f
                }.lparams() {
                    //                    gravity = Gravity.CENTER
                }
            }
        }
        Practice_1_5_03_OnDrawLayout.TAG -> {
            return frameLayout() {
                practice_1_5_03_OnDrawLayout(theme) {
                }.lparams(width = dip(200), height = dip(200)) {
                    gravity = Gravity.CENTER
                }
            }
        }
        Practice_1_5_04_DispatchDrawLayout.TAG -> {
            return linearLayout() {
                lparams(matchParent, wrapContent)
                gravity = Gravity.CENTER
                practice_1_5_04_DispatchDrawLayout(theme) {
                    orientation = LinearLayout.VERTICAL
                    imageView {
                        scaleType = ImageView.ScaleType.CENTER_CROP
                        imageResource = R.drawable.batman
                    }.lparams(width = dip(160), height = dip(160))
                    textView {
                        backgroundColor = Color.parseColor("#AAAAAA")
                        gravity = Gravity.CENTER
                        textResource = R.string.batman
                        textSize = 25f
                        textColor = Color.BLACK
                    }.lparams(dip(160), dip(50))
                }.lparams() {
                    gravity = Gravity.CENTER
                }
            }
        }
        Practice_1_5_05_AfterOnDrawForegroundView.TAG -> {
            return frameLayout() {
                practice_1_5_05_AfterOnDrawForegroundView(theme) {
                    scaleType = ImageView.ScaleType.CENTER_CROP
                    imageResource = R.drawable.batman
                    foregroundTintList = ColorStateList.valueOf(R.color.material_color_cyan_600)
                }.lparams(width = dip(200), height = dip(200)) {
                    gravity = Gravity.CENTER
                }
            }
        }
        Practice_1_5_06_BeforeOnDrawForegroundView.TAG -> {
            return frameLayout() {
                practice_1_5_06_BeforeOnDrawForegroundView(theme) {
                    scaleType = ImageView.ScaleType.CENTER_CROP
                    imageResource = R.drawable.batman
                    foregroundTintList = ColorStateList.valueOf(R.color.material_color_cyan_600)
                }.lparams(width = dip(200), height = dip(200)) {
                    gravity = Gravity.CENTER
                }
            }
        }
        Practice_1_5_07_AfterDrawView.TAG -> {
            return frameLayout() {
                practice_1_5_07_AfterDrawView(theme) {
                    scaleType = ImageView.ScaleType.CENTER_CROP
                    imageResource = R.drawable.batman
                    foregroundTintList = ColorStateList.valueOf(R.color.material_color_cyan_600)
                }.lparams(width = dip(200), height = dip(200)) {
                    gravity = Gravity.CENTER
                }
            }
        }
        Practice_1_5_08_BeforeDrawView.TAG -> {
            return frameLayout() {
                practice_1_5_08_BeforeDrawView(theme) {
                    textResource = R.string.hello
                    textSize = 16f
                    maxLines = 1
                }.lparams(matchParent, wrapContent)
            }
        }

        else -> return practiceDefaultView(theme) {}
    }

}

inline fun ViewManager.practiceDefaultView(theme: Int = 0, init: PracticeDefaultView.() -> Unit): PracticeDefaultView {
    return ankoView({ PracticeDefaultView(it) }, theme, init)
}


//--------------------------------start 1.1 绘制基础 start------------------------------------
inline fun ViewManager.practice_1_1_1_DrawColorView(theme: Int = 0, init: Practice_1_1_1_DrawColorView.() -> Unit)
        = ankoView(::Practice_1_1_1_DrawColorView, theme, init)

inline fun ViewManager.practice_1_1_2_DrawCircleView(theme: Int = 0, init: Practice_1_1_2_DrawCircleView.() -> Unit)
        = ankoView(::Practice_1_1_2_DrawCircleView, theme, init)

inline fun ViewManager.practice_1_1_3_DrawRectView(theme: Int = 0, init: Practice_1_1_3_DrawRectView.() -> Unit)
        = ankoView(::Practice_1_1_3_DrawRectView, theme, init)

inline fun ViewManager.practice_1_1_4_DrawPointView(theme: Int = 0, init: Practice_1_1_4_DrawPointView.() -> Unit)
        = ankoView(::Practice_1_1_4_DrawPointView, theme, init)

inline fun ViewManager.practice_1_1_5_DrawOvalView(theme: Int = 0, init: Practice_1_1_5_DrawOvalView.() -> Unit)
        = ankoView(::Practice_1_1_5_DrawOvalView, theme, init)


inline fun ViewManager.practice_1_1_6_DrawLineView(theme: Int = 0, init: Practice_1_1_6_DrawLineView.() -> Unit)
        = ankoView(::Practice_1_1_6_DrawLineView, theme, init)

inline fun ViewManager.practice_1_1_7_DrawRoundRectView(theme: Int = 0, init: Practice_1_1_7_DrawRoundRectView.() -> Unit)
        = ankoView(::Practice_1_1_7_DrawRoundRectView, theme, init)

inline fun ViewManager.practice_1_1_8_DrawArcView(theme: Int = 0, init: Practice_1_1_8_DrawArcView.() -> Unit)
        = ankoView(::Practice_1_1_8_DrawArcView, theme, init)

inline fun ViewManager.practice_1_1_9_DrawPathView(theme: Int = 0, init: Practice_1_1_9_DrawPathView.() -> Unit)
        = ankoView(::Practice_1_1_9_DrawPathView, theme, init)

inline fun ViewManager.practice_1_1_10_HistogramView(theme: Int = 0, init: Practice_1_1_10_HistogramView.() -> Unit)
        = ankoView(::Practice_1_1_10_HistogramView, theme, init)

inline fun ViewManager.practice_1_1_11_PieChartView(theme: Int = 0, init: Practice_1_1_11_PieChartView.() -> Unit)
        = ankoView(::Practice_1_1_11_PieChartView, theme, init)
//--------------------------------end 1.1 绘制基础 end------------------------------------


//--------------------------------start 1.2 Paint 详细 start------------------------------------
inline fun ViewManager.practice_1_2_01_LinearGradientView(theme: Int = 0, init: Practice_1_2_01_LinearGradientView.() -> Unit)
        = ankoView(::Practice_1_2_01_LinearGradientView, theme, init)

inline fun ViewManager.practice_1_2_02_RadialGradientView(theme: Int = 0, init: Practice_1_2_02_RadialGradientView.() -> Unit)
        = ankoView(::Practice_1_2_02_RadialGradientView, theme, init)

inline fun ViewManager.practice_1_2_03_SweepGradientView(theme: Int = 0, init: Practice_1_2_03_SweepGradientView.() -> Unit)
        = ankoView(::Practice_1_2_03_SweepGradientView, theme, init)

inline fun ViewManager.practice_1_2_04_BitmapShaderView(theme: Int = 0, init: Practice_1_2_04_BitmapShaderView.() -> Unit)
        = ankoView(::Practice_1_2_04_BitmapShaderView, theme, init)

inline fun ViewManager.practice_1_2_05_ComposeShaderView(theme: Int = 0, init: Practice_1_2_05_ComposeShaderView.() -> Unit)
        = ankoView(::Practice_1_2_05_ComposeShaderView, theme, init)


inline fun ViewManager.practice_1_2_06_LightingColorFilterView(theme: Int = 0, init: Practice_1_2_06_LightingColorFilterView.() -> Unit)
        = ankoView(::Practice_1_2_06_LightingColorFilterView, theme, init)

inline fun ViewManager.practice_1_2_07_ColorMatrixColorFilterView(theme: Int = 0, init: Practice_1_2_07_ColorMatrixColorFilterView.() -> Unit)
        = ankoView(::Practice_1_2_07_ColorMatrixColorFilterView, theme, init)

inline fun ViewManager.practice_1_2_08_XfermodeView(theme: Int = 0, init: Practice_1_2_08_XfermodeView.() -> Unit)
        = ankoView(::Practice_1_2_08_XfermodeView, theme, init)

inline fun ViewManager.practice_1_2_09_StrokeCapView(theme: Int = 0, init: Practice_1_2_09_StrokeCapView.() -> Unit)
        = ankoView(::Practice_1_2_09_StrokeCapView, theme, init)

inline fun ViewManager.practice_1_2_10_StrokeJoinView(theme: Int = 0, init: Practice_1_2_10_StrokeJoinView.() -> Unit)
        = ankoView(::Practice_1_2_10_StrokeJoinView, theme, init)

inline fun ViewManager.practice_1_2_11_StrokeMiterView(theme: Int = 0, init: Practice_1_2_11_StrokeMiterView.() -> Unit)
        = ankoView(::Practice_1_2_11_StrokeMiterView, theme, init)

inline fun ViewManager.practice_1_2_12_PathEffectView(theme: Int = 0, init: Practice_1_2_12_PathEffectView.() -> Unit)
        = ankoView(::Practice_1_2_12_PathEffectView, theme, init)

inline fun ViewManager.practice_1_2_13_ShadowLayerView(theme: Int = 0, init: Practice_1_2_13_ShadowLayerView.() -> Unit)
        = ankoView(::Practice_1_2_13_ShadowLayerView, theme, init)

inline fun ViewManager.practice_1_2_14_MaskFilterView(theme: Int = 0, init: Practice_1_2_14_MaskFilterView.() -> Unit)
        = ankoView(::Practice_1_2_14_MaskFilterView, theme, init)

inline fun ViewManager.practice_1_2_15_FillPathView(theme: Int = 0, init: Practice_1_2_15_FillPathView.() -> Unit)
        = ankoView(::Practice_1_2_15_FillPathView, theme, init)

inline fun ViewManager.practice_1_2_16_TextPathView(theme: Int = 0, init: Practice_1_2_16_TextPathView.() -> Unit)
        = ankoView(::Practice_1_2_16_TextPathView, theme, init)

//--------------------------------end 1.2 Paint 详细 end------------------------------------


//--------------------------------start 1.3 绘制文字 start------------------------------------
inline fun ViewManager.practice_1_3_01_DrawTextView(theme: Int = 0, init: Practice_1_3_01_DrawTextView.() -> Unit)
        = ankoView(::Practice_1_3_01_DrawTextView, theme, init)

inline fun ViewManager.practice_1_3_02_StaticLayoutView(theme: Int = 0, init: Practice_1_3_02_StaticLayoutView.() -> Unit)
        = ankoView(::Practice_1_3_02_StaticLayoutView, theme, init)

inline fun ViewManager.practice_1_3_03_SetTextSizeView(theme: Int = 0, init: Practice_1_3_03_SetTextSizeView.() -> Unit)
        = ankoView(::Practice_1_3_03_SetTextSizeView, theme, init)

inline fun ViewManager.practice_1_3_04_SetTypefaceView(theme: Int = 0, init: Practice_1_3_04_SetTypefaceView.() -> Unit)
        = ankoView(::Practice_1_3_04_SetTypefaceView, theme, init)

inline fun ViewManager.practice_1_3_05_SetFakeBoldTextView(theme: Int = 0, init: Practice_1_3_05_SetFakeBoldTextView.() -> Unit)
        = ankoView(::Practice_1_3_05_SetFakeBoldTextView, theme, init)

inline fun ViewManager.practice_1_3_06_SetStrikeThruTextView(theme: Int = 0, init: Practice_1_3_06_SetStrikeThruTextView.() -> Unit)
        = ankoView(::Practice_1_3_06_SetStrikeThruTextView, theme, init)

inline fun ViewManager.practice_1_3_07_SetUnderlineTextView(theme: Int = 0, init: Practice_1_3_07_SetUnderlineTextView.() -> Unit)
        = ankoView(::Practice_1_3_07_SetUnderlineTextView, theme, init)

inline fun ViewManager.practice_1_3_08_SetTextSkewXView(theme: Int = 0, init: Practice_1_3_08_SetTextSkewXView.() -> Unit)
        = ankoView(::Practice_1_3_08_SetTextSkewXView, theme, init)

inline fun ViewManager.practice_1_3_09_SetTextScaleXView(theme: Int = 0, init: Practice_1_3_09_SetTextScaleXView.() -> Unit)
        = ankoView(::Practice_1_3_09_SetTextScaleXView, theme, init)

inline fun ViewManager.practice_1_3_10_SetTextAlignView(theme: Int = 0, init: Practice_1_3_10_SetTextAlignView.() -> Unit)
        = ankoView(::Practice_1_3_10_SetTextAlignView, theme, init)


inline fun ViewManager.practice_1_3_11_GetFontSpacingView(theme: Int = 0, init: Practice_1_3_11_GetFontSpacingView.() -> Unit)
        = ankoView(::Practice_1_3_11_GetFontSpacingView, theme, init)

inline fun ViewManager.practice_1_3_12_MeasureTextView(theme: Int = 0, init: Practice_1_3_12_MeasureTextView.() -> Unit)
        = ankoView(::Practice_1_3_12_MeasureTextView, theme, init)

inline fun ViewManager.practice_1_3_13_GetTextBoundsView(theme: Int = 0, init: Practice_1_3_13_GetTextBoundsView.() -> Unit)
        = ankoView(::Practice_1_3_13_GetTextBoundsView, theme, init)

inline fun ViewManager.practice_1_3_14_GetFontMetricsView(theme: Int = 0, init: Practice_1_3_14_GetFontMetricsView.() -> Unit)
        = ankoView(::Practice_1_3_14_GetFontMetricsView, theme, init)

//--------------------------------end 1.3绘制文字 end------------------------------------


//--------------------------------start 1.4 draw 助手 start------------------------------------
inline fun ViewManager.practice_1_4_01_ClipRectView(theme: Int = 0, init: Practice_1_4_01_ClipRectView.() -> Unit)
        = ankoView(::Practice_1_4_01_ClipRectView, theme, init)

inline fun ViewManager.practice_1_4_02_ClipPathView(theme: Int = 0, init: Practice_1_4_02_ClipPathView.() -> Unit)
        = ankoView(::Practice_1_4_02_ClipPathView, theme, init)

inline fun ViewManager.practice_1_4_03_TranslateView(theme: Int = 0, init: Practice_1_4_03_TranslateView.() -> Unit)
        = ankoView(::Practice_1_4_03_TranslateView, theme, init)

inline fun ViewManager.practice_1_4_04_ScaleView(theme: Int = 0, init: Practice_1_4_04_ScaleView.() -> Unit)
        = ankoView(::Practice_1_4_04_ScaleView, theme, init)

inline fun ViewManager.practice_1_4_05_RotateView(theme: Int = 0, init: Practice_1_4_05_RotateView.() -> Unit)
        = ankoView(::Practice_1_4_05_RotateView, theme, init)

inline fun ViewManager.practice_1_4_06_SkewView(theme: Int = 0, init: Practice_1_4_06_SkewView.() -> Unit)
        = ankoView(::Practice_1_4_06_SkewView, theme, init)

inline fun ViewManager.practice_1_4_07_MatrixTranslateView(theme: Int = 0, init: Practice_1_4_07_MatrixTranslateView.() -> Unit)
        = ankoView(::Practice_1_4_07_MatrixTranslateView, theme, init)

inline fun ViewManager.practice_1_4_08_MatrixScaleView(theme: Int = 0, init: Practice_1_4_08_MatrixScaleView.() -> Unit)
        = ankoView(::Practice_1_4_08_MatrixScaleView, theme, init)

inline fun ViewManager.practice_1_4_09_MatrixRotateView(theme: Int = 0, init: Practice_1_4_09_MatrixRotateView.() -> Unit)
        = ankoView(::Practice_1_4_09_MatrixRotateView, theme, init)

inline fun ViewManager.practice_1_4_10_MatrixSkewView(theme: Int = 0, init: Practice_1_4_10_MatrixSkewView.() -> Unit)
        = ankoView(::Practice_1_4_10_MatrixSkewView, theme, init)

inline fun ViewManager.practice_1_4_11_CameraRotateView(theme: Int = 0, init: Practice_1_4_11_CameraRotateView.() -> Unit)
        = ankoView(::Practice_1_4_11_CameraRotateView, theme, init)

inline fun ViewManager.practice_1_4_12_CameraRotateFixedView(theme: Int = 0, init: Practice_1_4_12_CameraRotateFixedView.() -> Unit)
        = ankoView(::Practice_1_4_12_CameraRotateFixedView, theme, init)

inline fun ViewManager.practice_1_4_13_CameraRotateHittingFaceView(theme: Int = 0, init: Practice_1_4_13_CameraRotateHittingFaceView.() -> Unit)
        = ankoView(::Practice_1_4_13_CameraRotateHittingFaceView, theme, init)

inline fun ViewManager.practice_1_4_14_FlipboardView(theme: Int = 0, init: Practice_1_4_14_FlipboardView.() -> Unit)
        = ankoView(::Practice_1_4_14_FlipboardView, theme, init)

//--------------------------------end 1.4 draw 助手 end------------------------------------


//--------------------------------start 1.5 绘制顺序 start------------------------------------
inline fun ViewManager.practice_1_5_01_AfterOnDrawView(theme: Int = 0, init: Practice_1_5_01_AfterOnDrawView.() -> Unit): Practice_1_5_01_AfterOnDrawView {
    return ankoView({ Practice_1_5_01_AfterOnDrawView(it) }, theme, init)
}

inline fun ViewManager.practice_1_5_02_BeforeOnDrawView(theme: Int = 0, init: Practice_1_5_02_BeforeOnDrawView.() -> Unit): Practice_1_5_02_BeforeOnDrawView {
    return ankoView({ Practice_1_5_02_BeforeOnDrawView(it) }, theme, init)
}

inline fun ViewManager.practice_1_5_03_OnDrawLayout(theme: Int = 0, init: Practice_1_5_03_OnDrawLayout.() -> Unit): Practice_1_5_03_OnDrawLayout {
    return ankoView({ Practice_1_5_03_OnDrawLayout(it) }, theme, init)
}

inline fun ViewManager.practice_1_5_04_DispatchDrawLayout(theme: Int = 0, init: Practice_1_5_04_DispatchDrawLayout.() -> Unit): Practice_1_5_04_DispatchDrawLayout {
    return ankoView({ Practice_1_5_04_DispatchDrawLayout(it) }, theme, init)
}

inline fun ViewManager.practice_1_5_05_AfterOnDrawForegroundView(theme: Int = 0, init: Practice_1_5_05_AfterOnDrawForegroundView.() -> Unit): Practice_1_5_05_AfterOnDrawForegroundView {
    return ankoView({ Practice_1_5_05_AfterOnDrawForegroundView(it) }, theme, init)
}

inline fun ViewManager.practice_1_5_06_BeforeOnDrawForegroundView(theme: Int = 0, init: Practice_1_5_06_BeforeOnDrawForegroundView.() -> Unit): Practice_1_5_06_BeforeOnDrawForegroundView {
    return ankoView({ Practice_1_5_06_BeforeOnDrawForegroundView(it) }, theme, init)
}

inline fun ViewManager.practice_1_5_07_AfterDrawView(theme: Int = 0, init: Practice_1_5_07_AfterDrawView.() -> Unit): Practice_1_5_07_AfterDrawView {
    return ankoView({ Practice_1_5_07_AfterDrawView(it) }, theme, init)
}

inline fun ViewManager.practice_1_5_08_BeforeDrawView(theme: Int = 0, init: Practice_1_5_08_BeforeDrawView.() -> Unit): Practice_1_5_08_BeforeDrawView {
    return ankoView({ Practice_1_5_08_BeforeDrawView(it) }, theme, init)
}