package com.github.sfyc23.base.ext

import android.app.Fragment
import android.content.Context
import android.support.annotation.DimenRes
import android.view.View
import org.jetbrains.anko.AnkoContext

/**
 * Author :leilei on 2017/9/8 00:04
 */

//returns dip(dp) dimension value in pixels


fun Context.dp(value: Int): Int = (value * resources.displayMetrics.density).toInt()
fun Context.dp(value: Float): Int = (value * resources.displayMetrics.density).toInt()
fun Context.dpToFloat(value: Int): Float = value * resources.displayMetrics.density
fun Context.dpToFloat(value: Float): Float = value * resources.displayMetrics.density

//return sp dimension value in pixels
//fun Context.sp(value: Int): Int = (value * resources.displayMetrics.scaledDensity).toInt()
//fun Context.sp(value: Float): Int = (value * resources.displayMetrics.scaledDensity).toInt()
fun Context.spToFloat(value: Int): Float = value * resources.displayMetrics.scaledDensity
fun Context.spToFloat(value: Float): Float = value * resources.displayMetrics.scaledDensity

//converts px value into dip or sp
//fun Context.px2dip(px: Int): Float = px.toFloat() / resources.displayMetrics.density
//fun Context.px2sp(px: Int): Float = px.toFloat() / resources.displayMetrics.scaledDensity

fun Context.dimen(@DimenRes resource: Int): Int = resources.getDimensionPixelSize(resource)


//the same for nested DSL components
inline fun AnkoContext<*>.dp(value: Int): Int = ctx.dp(value)
inline fun AnkoContext<*>.dp(value: Float): Int = ctx.dp(value)
inline fun AnkoContext<*>.dpToFloat(value: Int): Float = ctx.dpToFloat(value)
inline fun AnkoContext<*>.dpToFloat(value: Float): Float = ctx.dpToFloat(value)
inline fun AnkoContext<*>.spToFloat(value: Int): Float = ctx.spToFloat(value)
inline fun AnkoContext<*>.spToFloat(value: Float): Float = ctx.spToFloat(value)


//the same for the views
inline fun View.dp(value: Int): Int = context.dp(value)
inline fun View.dp(value: Float): Int = context.dp(value)
inline fun View.dpToFloat(value: Int): Float = context.dpToFloat(value)
inline fun View.dpToFloat(value: Float): Float = context.dpToFloat(value)
inline fun View.spToFloat(value: Int): Float = context.spToFloat(value)
inline fun View.spToFloat(value: Float): Float = context.spToFloat(value)


//the same for Fragments
inline fun Fragment.dp(value: Int): Int = activity.dp(value)
inline fun Fragment.dp(value: Float): Int = activity.dp(value)
inline fun Fragment.dpToFloat(value: Int): Float = activity.dpToFloat(value)
inline fun Fragment.dpToFloat(value: Float): Float = activity.dpToFloat(value)
inline fun Fragment.spToFloat(value: Int): Float = activity.spToFloat(value)
inline fun Fragment.spToFloat(value: Float): Float = activity.spToFloat(value)

