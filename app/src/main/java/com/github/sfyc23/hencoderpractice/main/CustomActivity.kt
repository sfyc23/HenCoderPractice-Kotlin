package com.github.sfyc23.hencoderpractice.main

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import com.hencoder.hencoderpracticedraw1.kt.practice1View
import com.hencoder.hencoderpracticedraw5.practice.Practice_1_5_04_DispatchDrawLayout
import org.jetbrains.anko.UI

class CustomActivity : Activity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var layout = UI {
//            practice1View(Practice_1_1_1_DrawColorView.TAG)
            practice1View(Practice_1_5_04_DispatchDrawLayout.TAG)
        }.view
        setContentView(layout)
    }
}




