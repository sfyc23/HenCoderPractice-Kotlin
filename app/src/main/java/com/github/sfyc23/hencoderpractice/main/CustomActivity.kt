package com.github.sfyc23.hencoderpractice.main

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.*
import org.jetbrains.anko.design.appBarLayout

class CustomActivity : Activity() {

//    lateinit var pdv:PracticeDefaultView

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var layout = UI {
            verticalLayout {

//                <android.support.design.widget.AppBarLayout
//                android:layout_width="match_parent"
//                android:layout_height="wrap_content">
//                <android.support.v7.widget.Toolbar
//                android:id="@+id/toolbar"
//                android:layout_width="match_parent"
//                android:layout_height="?attr/actionBarSize"
//                android:background="?attr/colorPrimary"
//                android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar"
//                app:popupTheme="@style/ThemeOverlay.AppCompat.Light"/>
//                </android.support.design.widget.AppBarLayout>

                appBarLayout {
                    lparams(matchParent, wrapContent)
                    themedToolbar(R.style.ToolbarCommon) {
                        popupTheme = R.style.ToolbarPopupTheme
                        title = "loveyou"

                    }
                }



                /*
                 android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:layout_gravity="start"
        android:fitsSystemWindows="true"
        app:headerLayout="@layout/nav_header_main"
        app:menu="@menu/activity_main_drawer"
                 */
            /*    navigationView {
                    fitsSystemWindows = true

                }*/



            }
        }.view
        setContentView(layout)
//        pdv.note = "lei lei"
//        setContentView(R.layout.test_default_view)
    }
}










