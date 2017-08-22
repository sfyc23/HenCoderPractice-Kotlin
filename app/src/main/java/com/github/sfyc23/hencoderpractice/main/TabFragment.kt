package com.github.sfyc23.hencoderpractice.main

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.hencoder.hencoderpracticedraw1.kt.DatabaseService
import com.hencoder.hencoderpracticedraw1.kt.PageModel
import com.hencoder.hencoderpracticedraw1.kt.practice1View
import org.jetbrains.anko.*
import org.jetbrains.anko.design.themedTabLayout
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.viewPager

class TabFragment : Fragment() {

    var stringRes: Int = 0

    lateinit var tabLayout: TabLayout
    lateinit var pager: ViewPager
    lateinit var pageModels: MutableList<PageModel>

    companion object Factory {
        val BUNDLE_KEY_TAG = "bundle_key_tag"
        fun newInstance(stringRes: Int) = TabFragment().apply {
            arguments = Bundle().apply {
                putInt(BUNDLE_KEY_TAG, stringRes)
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            stringRes = arguments.getInt(NewPageFragment.BUNDLE_KEY_TAG)
        }
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = UI {
            linearLayout {
                orientation = LinearLayout.VERTICAL
                lparams(width = matchParent, height = matchParent)
                backgroundColor = Color.parseColor("#33000000")

                tabLayout = themedTabLayout() {
                    //                    id = R.id.tabLayout
                    lparams(width = matchParent, height = dip(48))
                    tabMode = TabLayout.MODE_SCROLLABLE
                    backgroundColor = Color.WHITE
                }

                pager = viewPager {
                    //                    id = R.id.pager
                }.lparams(width = matchParent, height = matchParent)
            }
        }.view

        pageModels = DatabaseService.getInstance().getDataListByStringRes(stringRes)

        pager.adapter = CustomPagerAdapter(context, pageModels)
        tabLayout.setupWithViewPager(pager)

        return view
    }


    class CustomPagerAdapter(private val mContext: Context, val pageModels: MutableList<PageModel>) : PagerAdapter() {

        @RequiresApi(Build.VERSION_CODES.M)
        override fun instantiateItem(collection: ViewGroup, position: Int): Any {
            var viewTag = pageModels.get(position).tag
            var layout = mContext.UI {
                practice1View(viewTag)
            }.view
            collection.addView(layout)
            return layout
        }

        override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
            collection.removeView(view as View)
        }

        override fun getCount(): Int {
            return pageModels.size
        }

        override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
            return view === `object`
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mContext.getString(pageModels.get(position).titleRes)
        }

    }


}


