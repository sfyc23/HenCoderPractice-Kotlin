package com.github.sfyc23.hencoderpractice.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.github.sfyc23.hencoderpractice.R
import com.github.sfyc23.hencoderpractice.data.eventbus.MessageEvent
import com.github.sfyc23.hencoderpractice.dialog.MessageDialog
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.find


class MainActivity : AppCompatActivity() {

    private var mFragment: Fragment? = null
    lateinit var drawerLayout: DrawerLayout
    lateinit var toolbar: Toolbar
    lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = find<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)


        drawerLayout = find<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView = find<NavigationView>(R.id.nav_view)
        setupDrawerContent()
        navigationView.setCheckedItem(R.id.nav_main)
        selectFragment(R.id.nav_main)

    }


    override fun onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else if (!toolbar.title.equals(getString(R.string.app_name))) {
            toolbar.title = getString(R.string.app_name)
            mFragment = MainFragment.newInstance()
            supportFragmentManager.beginTransaction().replace(R.id.contentFrame, mFragment).commit()
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setupDrawerContent() {
        navigationView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawers()
            selectFragment(it.itemId)
            true
        }
    }


    private fun selectFragment(fragmentId: Int) {
        when (fragmentId) {
            R.id.nav_github -> {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://github.com/sfyc23/HenCoderPractice-Kotlin")
                startActivity(Intent.createChooser(intent, getString(R.string.intent_chooser)))
                return
            }
            R.id.nav_about -> {
                MessageDialog.newInstance(
                        R.drawable.ic_info_grey600_24dp,
                        getString(R.string.about_title),
                        getString(R.string.about_body),
                        null
                ).show(fragmentManager, MessageDialog.TAG)
                return
            }
            R.id.nav_main -> {
                toolbar.title = getString(R.string.app_name)
                mFragment = MainFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.contentFrame, mFragment).commit()
            }
            R.id.nav_draw_basal -> {
                mFragment = TabFragment.newInstance(R.string.draw_basal)
                toolbar.title = getString(R.string.draw_basal)
                supportFragmentManager.beginTransaction().replace(R.id.contentFrame, mFragment).commit()
            }
            R.id.nav_paint_detail -> {
                toolbar.title = getString(R.string.paint_detail)
                mFragment = TabFragment.newInstance(R.string.paint_detail)
                supportFragmentManager.beginTransaction().replace(R.id.contentFrame, mFragment).commit()
            }
            R.id.nav_draw_text -> {
                toolbar.title = getString(R.string.draw_text)
                mFragment = TabFragment.newInstance(R.string.draw_text)
                supportFragmentManager.beginTransaction().replace(R.id.contentFrame, mFragment).commit()
            }
            R.id.nav_canvas_help -> {
                toolbar.title = getString(R.string.canvas_help)
                mFragment = TabFragment.newInstance(R.string.canvas_help)
                supportFragmentManager.beginTransaction().replace(R.id.contentFrame, mFragment).commit()
            }
            R.id.nav_canvas_order -> {
                toolbar.title = getString(R.string.canvas_order)
                mFragment = TabFragment.newInstance(R.string.canvas_order)
                supportFragmentManager.beginTransaction().replace(R.id.contentFrame, mFragment).commit()
            }
            R.id.nav_view_property_animator_simple -> {
                toolbar.title = getString(R.string.view_property_animator_simple)
                mFragment = TabFragment.newInstance(R.string.view_property_animator_simple)
                supportFragmentManager.beginTransaction().replace(R.id.contentFrame, mFragment).commit()
            }
            R.id.nav_view_property_animator_advanced -> {
                toolbar.title = getString(R.string.view_property_animator_advanced)
                mFragment = TabFragment.newInstance(R.string.view_property_animator_advanced)
                supportFragmentManager.beginTransaction().replace(R.id.contentFrame, mFragment).commit()
            }


        }

    }

    //———————————————————eventbus 相关————————————————————————————
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MessageEvent) {
        var mainPage = event.mainPage
        navigationView.setCheckedItem(mainPage.navRes)
        selectFragment(mainPage.navRes)
    }


    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this);
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this);
    }

}
