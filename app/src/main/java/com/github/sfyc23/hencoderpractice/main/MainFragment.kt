package com.github.sfyc23.hencoderpractice.main

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.sfyc23.hencoderpractice.R
import com.github.sfyc23.hencoderpractice.util.DividerDecoration
import com.hencoder.hencoderpracticedraw1.kt.DatabaseService
import org.jetbrains.anko.dip
import org.jetbrains.anko.padding
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI


class MainFragment : Fragment() {

    private var mParam1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val dividerDeco = DividerDecoration.Builder(this.activity)
                .setHeight(R.dimen.default_divider_height)
                .setColorResource(R.color.colorPrimary)
                .build()
        var items = DatabaseService.getInstance().getMainPageList()
        var mAdapter = MainAdapter(activity.baseContext, items = items)
        var view = UI {
            recyclerView {
                padding = dip(16)
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
                adapter = mAdapter
                addItemDecoration(dividerDeco)
            }
        }.view
        return view
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {

        private val ARG_PARAM1 = "param1"

        /**
         * @param param1 Parameter 1.
         */
        fun newInstance(): MainFragment {
            val fragment = MainFragment()
            val args = Bundle()
//            args.putString(ARG_PARAM1, param1)
            fragment.arguments = args
            return fragment
        }
    }


}
