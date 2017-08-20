package com.github.sfyc23.hencoderpractice.main

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import com.github.sfyc23.hencoderpractice.view.paintdetail.view.Practice_1_2_14_MaskFilterView
import com.hencoder.hencoderpracticedraw1.kt.practice1View
import org.jetbrains.anko.UI

class CustomActivity : Activity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var layout = UI {
            practice1View(Practice_1_2_14_MaskFilterView.TAG)
/*            scrollView() {
//                lparams(matchParent, wrapContent)
                verticalLayout() {
                    lparams(matchParent, wrapContent)

                    textView("你好"){

                    }
                    practice1View(Practice_1_5_01_AfterOnDrawView.TAG)
                    button("button"){

                    }
//                    practice1View(Practice_1_2_14_MaskFilterView.TAG)

                }*/
//              }

        }.view
        setContentView(layout)
    }
}




