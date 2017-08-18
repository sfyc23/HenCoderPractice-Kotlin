package com.github.sfyc23.hencoderpractice.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.github.sfyc23.hencoderpractice.R
import com.github.sfyc23.hencoderpractice.data.eventbus.MessageEvent
import com.hencoder.hencoderpracticedraw1.kt.MainPage
import org.greenrobot.eventbus.EventBus
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Author :leilei on 2017/8/17 20:56
 */
class MainAdapter(val context: Context, val items: ArrayList<MainPage>?) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {

        var view = Component(parent).createView(AnkoContext.Companion.create(parent.context, parent))
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (items == null) {
            return
        }
        holder.title.text = context.getString(items.get(position).titleRes)
        holder.image.imageResource = items.get(position).imageRes
        holder.itemView.onClick {
            EventBus.getDefault().postSticky(MessageEvent(items.get(position)))
        }
    }

    override fun getItemCount(): Int {
        items?.let {
            return items.size
        }
        return 0
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var image: ImageView

        init {
            title = itemView.findViewById(R.id.item_tv_title)
            image = itemView.findViewById(R.id.item_iv_header)
        }

    }

    class Component(parent: ViewGroup) : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
            //            frameLayout {
            themedLinearLayout(R.style.selectableItemBackground) {
                lparams(matchParent, dip(64))
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
                imageView {
                    id = R.id.item_iv_header
                    leftPadding = dip(16)
                    scaleType = ImageView.ScaleType.CENTER_CROP
                    imageResource = R.drawable.ic_menu_camera
                }.lparams(width = dip(40), height = dip(40))
                textView {
                    id = R.id.item_tv_title
                    padding = dip(16)
                    maxLines = 1
                    backgroundResource = R.color.transparent
                }.lparams()

            }

//            }
        }
    }


}
