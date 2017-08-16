package com.github.sfyc23.hencoderpractice.dialog

import android.annotation.SuppressLint
import android.app.DialogFragment
import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.TextView
import com.github.sfyc23.hencoderpractice.R
import org.jetbrains.anko.*


class MessageDialog : DialogFragment() {

    companion object Factory {
        val TAG = MessageDialog::class.java.simpleName
        val ARG_ICON = "icon"
        val ARG_TITLE = "title"
        val ARG_MESSAGE = "message"

        /**
         * Use from Activities.

         * @param icon     dialog icon
         * *
         * @param title    dialog title
         * *
         * @param message  dialog message
         * *
         * @param fragment target fragment
         * *
         * @return a new instance of MessageDialog
         */
         fun newInstance(icon: Int, title: String, message: String, fragment: Fragment? = null): MessageDialog {
            val confirmDialog = MessageDialog()
            val args = Bundle()
            args.putInt(ARG_ICON, icon)
            args.putString(ARG_TITLE, title)
            args.putString(ARG_MESSAGE, message)
            confirmDialog.arguments = args
            if (fragment != null) confirmDialog.setTargetFragment(fragment, 0)
            return confirmDialog
        }
    }

    /**
     * <ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:scrollbars="vertical"
    android:scrollbarStyle="outsideInset">

    <TextView
    android:id="@+id/message"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:paddingTop="24dp"
    android:layout_marginLeft="24dp"
    android:layout_marginStart="24dp"
    android:layout_marginRight="24dp"
    android:layout_marginEnd="24dp"
    android:paddingBottom="24dp"
    tools:text="Message"/>

    </ScrollView>
     */

    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): AlertDialog {
        val dialogView = activity.UI {
            scrollView {
                lparams(matchParent, wrapContent)
                //outsideInset
                scrollBarStyle = View.SCROLLBARS_OUTSIDE_INSET

                textView {
                    id = R.id.message
                }.lparams(matchParent, wrapContent){
                    bottomPadding = dip(24)
                    topPadding = dip(24)
                    leftMargin = dip(24)
                    marginStart = dip(24)
                    rightMargin = dip(24)
                    marginEnd = dip(24)

                }
            }

        }.view

//        val dialogView = LayoutInflater.from(activity)
//                .inflate(R.layout.dialog_message, null)

        val messageView = dialogView.findViewById<View>(R.id.message) as TextView
        messageView.movementMethod = LinkMovementMethod.getInstance()
        messageView.text = Html.fromHtml(arguments.getString(ARG_MESSAGE))


        val builder = AlertDialog.Builder(activity, R.style.AppTheme_AlertDialog)
        builder.setTitle(arguments.getString(ARG_TITLE))
                .setIcon(arguments.getInt(ARG_ICON))
                .setView(dialogView)
                .setPositiveButton(R.string.OK) { dialog, which -> dialog.dismiss() }

        return builder.create()
    }


}
