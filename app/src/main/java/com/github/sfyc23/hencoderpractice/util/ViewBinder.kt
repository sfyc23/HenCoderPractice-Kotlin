package com.hencoder.hencoderpracticedraw1.kt

import android.view.View

/**
 * Author :leilei on 2017/8/13 17:49
 */
interface ViewBinder<in T> {
    fun bind(t: T) : View
    fun unbind(t: T)
}