package com.github.sfyc23.base.ext

import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import org.jetbrains.anko.internals.AnkoInternals
import org.jetbrains.anko.textColor

/**
 * Author :leilei on 2017/9/8 01:18
 */
var android.widget.Spinner.entries: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(value) {
        var ents = resources.getStringArray(value)
        ents?.let {
            val adapter = ArrayAdapter<CharSequence>(
                    context, android.R.layout.simple_spinner_item, ents)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            setAdapter(adapter)
        }
    }


var View.foregroundTintListResource: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    @RequiresApi(Build.VERSION_CODES.M)
    set(value) {
        foregroundTintList = ColorStateList.valueOf(value)
    }

var TextView.textColorResource: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(value) {
        textColor = ContextCompat.getColor(context, value)
    }

var Button.textColorResource: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(value) {
        textColor = ContextCompat.getColor(context, value)
    }

var TabLayout.tabTextAppearance: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = org.jetbrains.anko.internals.AnkoInternals.noGetter()
    @RequiresApi(Build.VERSION_CODES.M)
    set(value) {
        foregroundTintList = android.content.res.ColorStateList.valueOf(value)
//        context.obtainStyledAttributes(value)
//        resources.
        var ta: TypedArray = resources.obtainTypedArray(value)

    }
