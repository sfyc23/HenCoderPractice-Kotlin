package com.hencoder.hencoderpracticedraw1.kt

import com.github.sfyc23.hencoderpractice.R
import com.github.sfyc23.hencoderpractice.view.canvashelp.view.*
import com.github.sfyc23.hencoderpractice.view.drawbasal.view.*
import com.github.sfyc23.hencoderpractice.view.draworder.view.Practice_1_5_01_AfterOnDrawView
import com.github.sfyc23.hencoderpractice.view.drawtext.view.*
import com.github.sfyc23.hencoderpractice.view.paintdetail.view.*
import com.github.sfyc23.hencoderpractice.view.practice_1_6.view.*
import com.hencoder.hencoderpracticedraw5.practice.*


/**
 * Author :leilei on 2017/8/13 23:23
 */
class DatabaseService {
    companion object {
        fun getInstance() = Holder.instance
    }

    private object Holder {
        val instance = DatabaseService()
    }

    fun getMainPageList(): ArrayList<MainPage> {
        var mainPages = ArrayList<MainPage>()
        return mainPages.apply {
            add(MainPage(R.drawable.ic_1_1, R.string.draw_basal, R.id.nav_draw_basal))
            add(MainPage(R.drawable.ic_1_2, R.string.paint_detail, R.id.nav_paint_detail))
            add(MainPage(R.drawable.ic_1_3, R.string.draw_text, R.id.nav_draw_text))
            add(MainPage(R.drawable.ic_1_4, R.string.canvas_help, R.id.nav_canvas_help))
            add(MainPage(R.drawable.ic_1_5, R.string.canvas_order, R.id.nav_canvas_order))
            add(MainPage(R.drawable.ic_1_6, R.string.view_property_animator_simple, R.id.nav_view_property_animator_simple))
        }
    }

    fun getDataListByStringRes(stringRes: Int): MutableList<PageModel> {
        when (stringRes) {
            R.string.draw_basal -> {
                return getDataList1_1()
            }
            R.string.paint_detail -> {
                return getDataList1_2()
            }
            R.string.draw_text -> {
                return getDataList1_3()
            }
            R.string.canvas_help -> {
                return getDataList1_4()
            }
            R.string.canvas_order -> {
                return getDataList1_5()
            }
            R.string.view_property_animator_simple ->{
                return getDataList1_6()
            }
        }
        return mutableListOf()
    }

    fun getDataList1_1(): MutableList<PageModel> {
        var pageModels = ArrayList<PageModel>()
        pageModels.apply {
            add(PageModel(R.string.title_draw_color, Practice_1_1_1_DrawColorView.TAG))
            add(PageModel(R.string.title_draw_circle, Practice_1_1_2_DrawCircleView.TAG))
            add(PageModel(R.string.title_draw_rect, Practice_1_1_3_DrawRectView.TAG))
            add(PageModel(R.string.title_draw_point, Practice_1_1_4_DrawPointView.TAG))
            add(PageModel(R.string.title_draw_oval, Practice_1_1_5_DrawOvalView.TAG))

            add(PageModel(R.string.title_draw_line, Practice_1_1_6_DrawLineView.TAG))
            add(PageModel(R.string.title_draw_round_rect, Practice_1_1_7_DrawRoundRectView.TAG))
            add(PageModel(R.string.title_draw_arc, Practice_1_1_8_DrawArcView.TAG))
            add(PageModel(R.string.title_draw_path, Practice_1_1_9_DrawPathView.TAG))
            add(PageModel(R.string.title_draw_histogram, Practice_1_1_10_HistogramView.TAG))

            add(PageModel(R.string.title_draw_pie_chart, Practice_1_1_11_PieChartView.TAG))

        }
        return pageModels
    }

    fun getDataList1_2(): MutableList<PageModel> {
        var pageModels = ArrayList<PageModel>()
        pageModels.apply {
            add(PageModel(R.string.title_linear_gradient, Practice_1_2_01_LinearGradientView.TAG))
            add(PageModel(R.string.title_radial_gradient, Practice_1_2_02_RadialGradientView.TAG))
            add(PageModel(R.string.title_sweep_gradient, Practice_1_2_03_SweepGradientView.TAG))
            add(PageModel(R.string.title_bitmap_shader, Practice_1_2_04_BitmapShaderView.TAG))
            add(PageModel(R.string.title_compose_shader, Practice_1_2_05_ComposeShaderView.TAG))

            add(PageModel(R.string.title_lighting_color_filter, Practice_1_2_06_LightingColorFilterView.TAG))
            add(PageModel(R.string.title_color_matrix_color_filter, Practice_1_2_07_ColorMatrixColorFilterView.TAG))
            add(PageModel(R.string.title_xfermode, Practice_1_2_08_XfermodeView.TAG))
            add(PageModel(R.string.title_stroke_cap, Practice_1_2_09_StrokeCapView.TAG))
            add(PageModel(R.string.title_stroke_join, Practice_1_2_10_StrokeJoinView.TAG))

            add(PageModel(R.string.title_stroke_miter, Practice_1_2_11_StrokeMiterView.TAG))
            add(PageModel(R.string.title_path_effect, Practice_1_2_12_PathEffectView.TAG))
            add(PageModel(R.string.title_shader_layer, Practice_1_2_13_ShadowLayerView.TAG))
            add(PageModel(R.string.title_mask_filter, Practice_1_2_14_MaskFilterView.TAG))
            add(PageModel(R.string.title_fill_path, Practice_1_2_15_FillPathView.TAG))
            add(PageModel(R.string.title_text_path, Practice_1_2_16_TextPathView.TAG))

        }
        return pageModels
    }

    fun getDataList1_3(): MutableList<PageModel> {
        var pageModels = ArrayList<PageModel>()
        pageModels.apply {
            add(PageModel(R.string.title_draw_text, Practice_1_3_01_DrawTextView.TAG))
            add(PageModel(R.string.title_static_layout, Practice_1_3_02_StaticLayoutView.TAG))
            add(PageModel(R.string.title_set_text_size, Practice_1_3_03_SetTextSizeView.TAG))
            add(PageModel(R.string.title_set_typeface, Practice_1_3_04_SetTypefaceView.TAG))
            add(PageModel(R.string.title_set_fake_bold_text, Practice_1_3_05_SetFakeBoldTextView.TAG))

            add(PageModel(R.string.title_set_strike_thru_text, Practice_1_3_06_SetStrikeThruTextView.TAG))
            add(PageModel(R.string.title_set_underline_text, Practice_1_3_07_SetUnderlineTextView.TAG))
            add(PageModel(R.string.title_set_text_skew_x, Practice_1_3_08_SetTextSkewXView.TAG))
            add(PageModel(R.string.title_set_text_scale_x, Practice_1_3_09_SetTextScaleXView.TAG))

            add(PageModel(R.string.title_set_text_align, Practice_1_3_10_SetTextAlignView.TAG))
            add(PageModel(R.string.title_get_font_spacing, Practice_1_3_11_GetFontSpacingView.TAG))
            add(PageModel(R.string.title_measure_text, Practice_1_3_12_MeasureTextView.TAG))
            add(PageModel(R.string.title_get_text_bounds, Practice_1_3_13_GetTextBoundsView.TAG))
            add(PageModel(R.string.title_get_font_metrics, Practice_1_3_14_GetFontMetricsView.TAG))
        }
        return pageModels
    }

    fun getDataList1_4(): MutableList<PageModel> {
        var pageModels = ArrayList<PageModel>()
        pageModels.apply {
            add(PageModel(R.string.title_clip_rect, Practice_1_4_01_ClipRectView.TAG))
            add(PageModel(R.string.title_clip_path, Practice_1_4_02_ClipPathView.TAG))
            add(PageModel(R.string.title_translate, Practice_1_4_03_TranslateView.TAG))
            add(PageModel(R.string.title_scale, Practice_1_4_04_ScaleView.TAG))
            add(PageModel(R.string.title_rotate, Practice_1_4_05_RotateView.TAG))

            add(PageModel(R.string.title_skew, Practice_1_4_06_SkewView.TAG))
            add(PageModel(R.string.title_matrix_translate, Practice_1_4_07_MatrixTranslateView.TAG))
            add(PageModel(R.string.title_matrix_scale, Practice_1_4_08_MatrixScaleView.TAG))
            add(PageModel(R.string.title_matrix_rotate, Practice_1_4_09_MatrixRotateView.TAG))

            add(PageModel(R.string.title_matrix_skew, Practice_1_4_10_MatrixSkewView.TAG))
            add(PageModel(R.string.title_camera_rotate, Practice_1_4_11_CameraRotateView.TAG))
            add(PageModel(R.string.title_camera_rotate_fixed, Practice_1_4_12_CameraRotateFixedView.TAG))
            add(PageModel(R.string.title_camera_rotate_hitting_face, Practice_1_4_13_CameraRotateHittingFaceView.TAG))
            add(PageModel(R.string.title_flipboard, Practice_1_4_14_FlipboardView.TAG))

        }
        return pageModels
    }

    fun getDataList1_5(): MutableList<PageModel> {
        var pageModels = ArrayList<PageModel>()
        pageModels.apply {
            add(PageModel(R.string.title_after_on_draw, Practice_1_5_01_AfterOnDrawView.TAG))
            add(PageModel(R.string.title_before_on_draw, Practice_1_5_02_BeforeOnDrawView.TAG))
            add(PageModel(R.string.title_on_draw_layout, Practice_1_5_03_OnDrawLayout.TAG))
            add(PageModel(R.string.title_dispatch_draw, Practice_1_5_04_DispatchDrawLayout.TAG))
            add(PageModel(R.string.title_on_draw_layout, Practice_1_5_05_AfterOnDrawForegroundView.TAG))

            add(PageModel(R.string.title_before_on_draw_foreground, Practice_1_5_06_BeforeOnDrawForegroundView.TAG))
            add(PageModel(R.string.title_after_draw, Practice_1_5_07_AfterDrawView.TAG))
            add(PageModel(R.string.title_before_draw, Practice_1_5_08_BeforeDrawView.TAG))
        }
        return pageModels
    }

    fun getDataList1_6(): MutableList<PageModel> {
        var pageModels = ArrayList<PageModel>()
        pageModels.apply {
            add(PageModel(R.string.title_translation, Practice_1_6_01_Translation.TAG))
            add(PageModel(R.string.title_rotation, Practice_1_6_02_Rotation.TAG))
            add(PageModel(R.string.title_scale_translation, Practice_1_6_03_Scale.TAG))
            add(PageModel(R.string.title_alpha, Practice_1_6_04_Alpha.TAG))
            add(PageModel(R.string.title_multi_properties, Practice_1_6_05_MultiProperties.TAG))
            add(PageModel(R.string.title_duration, Practice_1_6_06_Duration.TAG))
            add(PageModel(R.string.title_interpolator, Practice_1_6_07_Interpolator.TAG))
            add(PageModel(R.string.title_object_animator, Practice_1_6_08_ObjectAnimatorLayout.TAG))
        }
        return pageModels
    }

}

class PageModel(
        var titleRes: Int,
        var tag: String
)


/**
 * 用于主页 list 的跳转
 */
data class MainPage(
        var imageRes: Int,
        var titleRes: Int,
        var navRes: Int
)